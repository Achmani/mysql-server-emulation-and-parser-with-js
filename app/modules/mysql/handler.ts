import net from 'net';
import { v4 } from 'uuid';
import mysql from 'mysql'
import { queryAsync, results } from '../../../helpers/mysql';

import Packets from './interface/packets';
import Constants from './interface/constants';
import AuthPacket, { resultAuth } from './8.0/packet/auth';

import { mysqlProcess } from '../worker/mysql_worker'
import QueryParser from '../query_parser/query_parser';
import Reserved, { resultReserved } from './helpers/reserved';
import { configDB, configDBInfoSchema } from '../../config/global';

export default class Handler {

    private mysqlversion: number = 8;
    private conn: Array<net.Socket>;
    private status: Array<boolean>;
    private username: Array<string>;
    private password: Array<string>;
    private constant: Constants;
    private reserved: Reserved;


    public constructor() {
        this.conn = [];
        this.status = [];
        this.username = [];
        this.password = [];
        this.reserved = new Reserved();
        this.constant = new Constants(this.mysqlversion);
    }

    public connection(conn: net.Socket) {

        let remoteAddress = conn.remoteAddress + ':' + conn.remotePort;
        console.log('new client connection from mysql handler %s', remoteAddress);
        const packets = new Packets(this.mysqlversion);

        const session_uuid = v4();
        this.conn[session_uuid] = conn;
        this.status[session_uuid] = false;
        this.username[session_uuid] = "";

        //  Send GreetingPacket Mysql
        const greeting = packets.GreetingPacket;
        this.conn[session_uuid].write(greeting.pack("Enggano Data Core 0.0.1"));

        //  Initialize Parser and Auth
        const auth: AuthPacket = packets.AuthPacket;
        const parser: QueryParser = new QueryParser();
        auth.setSalt1(greeting.getSalt1());
        auth.setSalt2(greeting.getSalt2());

        this.conn[session_uuid].on('data', (d: Buffer) => {
            this.onData(d, session_uuid, auth, parser, packets);
        });
        this.conn[session_uuid].on('close', () => {
            this.onClose(session_uuid);
        });
        this.conn[session_uuid].on('error', (err) => {
            this.onError(err, session_uuid);
        });

    }

    protected checkIsCloseConnection(d: Buffer, session_uuid: string): boolean {
        const close1 = Buffer.from([0x01, 0x00, 0x00, 0x00, 0x0e]);
        const close2 = Buffer.from([0x01, 0x00, 0x00, 0x00, 0x01]);
        if (Buffer.compare(d, close1) == 0 || Buffer.compare(d, close2) == 0) {
            this.conn[session_uuid].destroy();
            return false;
        }
        return true;
    }

    protected authenticate(d: Buffer, auth: AuthPacket): resultAuth {
        auth.unpack(d);
        const result: resultAuth = auth.authenticate();
        return result;
    }

    protected async processQueryReserved(query: string, session_uuid: string, packets: Packets, parser: QueryParser, reserved: resultReserved) {
        if (reserved.action == "write") {
            this.conn[session_uuid].write(reserved.data);
        } else if (reserved.action == "query") {
            query = reserved.data;
            let dataSrcType = "mysql";
            let results = await mysqlProcess(query, configDBInfoSchema, dataSrcType, reserved.is_eof);
            this.conn[session_uuid].write(results);
        }
    }

    protected async processQuery(query: string, session_uuid: string, packets: Packets, parser: QueryParser, reserved: resultReserved) {
        const replace1 = /U\*[A-Za-z0-9 .]+\*/gmi;
        query = query.replace(replace1, "");
        query = await parser.process(query);
        let listConfigDB: Array<mysql.ConnectionConfig> = [];

        for await (const [key, value] of Object.entries(parser.table)) {
            let queryParser = "SELECT d.datasource_physicalname, d.datasource_params FROM datasource d INNER JOIN metadata m ON d.`datasource_id`= m.`metadata_datasource` WHERE m.`metadata_model` =  '" + value + "' ";
            try {
                let configWorker = {};
                let results: results = await queryAsync(queryParser, configDBInfoSchema);
                let datasourceConfig = JSON.parse(results.rows[0]['datasource_params']);
                configWorker['host'] = datasourceConfig['connection']['host'];
                configWorker['port'] = datasourceConfig['connection']['port'];
                configWorker['user'] = datasourceConfig['connection']['user'];
                configWorker['password'] = datasourceConfig['connection']['password'];
                configWorker['database'] = datasourceConfig['connection']['database'];
                configWorker['multipleStatements'] = true;
                listConfigDB[0] = configWorker;

            } catch (error: any) {
            }
        };

        if (listConfigDB.length == 0) {
            //Default Information Schema
            listConfigDB.push(configDBInfoSchema);
        }

        listConfigDB.forEach(async configDB => {
            let dataSrcType = "mysql";
            console.log("Mysql");
            let results = await mysqlProcess(query, configDB, dataSrcType, true);
            this.conn[session_uuid].write(results);
            console.log("🚀 ~ Handler ~ checkReserved ~ results", results);
        });
    }

    protected async onData(d: Buffer, session_uuid: string, auth: AuthPacket, parser: QueryParser, packets: Packets) {
        try {
            let status: boolean = this.checkIsCloseConnection(d, session_uuid);
            if (!status) {
                return false;
            }

            if (!this.status[session_uuid]) {
                let results = this.authenticate(d, auth);
                if (results.success) {
                    this.conn[session_uuid].write(packets.OkPacket.pack(0, 0, this.constant.Client.SERVER_STATUS_AUTOCOMMIT, 0));
                    console.log("🚀 ~ Handler ~ onData ~ packets.OkPacket.pack(0, 0, this.constant.Client.SERVER_STATUS_AUTOCOMMIT, 0)", packets.OkPacket.pack(0, 0, this.constant.Client.SERVER_STATUS_AUTOCOMMIT, 0));
                    this.status[session_uuid] = true;
                } else {
                    this.conn[session_uuid].write(packets.ErrorPacket.pack(results.code, results.errno, results.sqlMessage, results.sqlState, results.index, results.sql, 0x02))
                    console.log("🚀 ~ Handler ~ onData ~ packets.ErrorPacket.pack(results.code, results.errno, results.sqlMessage, results.sqlState, results.index, results.sql, 0x02)", packets.ErrorPacket.pack(results.code, results.errno, results.sqlMessage, results.sqlState, results.index, results.sql, 0x02));
                    this.status[session_uuid] = false;
                }
            } else {
                let query = d.slice(5, d.length).toString('latin1');
                console.log("🚀 ~ file: handler.ts ~ line 153 ~ Handler ~ onData ~ query", query)
                let reserved: resultReserved = await this.reserved.process(query, packets);
                if (reserved.status) {
                    this.processQueryReserved(query, session_uuid, packets, parser, reserved);
                } else {
                    this.processQuery(query, session_uuid, packets, parser, reserved);
                }
            }

        } catch (error) {
            console.log("🚀 ~ file: handler.ts ~ line 156 ~ Handler ~ onData ~ error", error);
        }

    }

    protected async delete(session_uuid: string) {
        delete this.status[session_uuid];
        delete this.username[session_uuid];
        delete this.conn[session_uuid];
    }

    protected onClose(session_uuid) {
        this.delete(session_uuid);
        console.log('connection %s closed', session_uuid);
        this.activeConnection();
    }

    protected onError(err, session_uuid) {
        console.log('Connection %s error: %s', session_uuid, err.message);
    }

    protected activeConnection() {
        console.log("");
        console.log("|---------------|---------------|---------------|---------------|");
        console.log("|Active Connection                                              |");
        console.log("|---------------|---------------|---------------|---------------|");
        for (const [key, value] of Object.entries(this.conn)) {
            console.log(`| ${key}`);
        }
        console.log("|---------------|---------------|---------------|---------------|");
        console.log("");
    }

    protected log(session_uuid: string) {

    }

}