"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __asyncValues = (this && this.__asyncValues) || function (o) {
    if (!Symbol.asyncIterator) throw new TypeError("Symbol.asyncIterator is not defined.");
    var m = o[Symbol.asyncIterator], i;
    return m ? m.call(o) : (o = typeof __values === "function" ? __values(o) : o[Symbol.iterator](), i = {}, verb("next"), verb("throw"), verb("return"), i[Symbol.asyncIterator] = function () { return this; }, i);
    function verb(n) { i[n] = o[n] && function (v) { return new Promise(function (resolve, reject) { v = o[n](v), settle(resolve, reject, v.done, v.value); }); }; }
    function settle(resolve, reject, d, v) { Promise.resolve(v).then(function(v) { resolve({ value: v, done: d }); }, reject); }
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const uuid_1 = require("uuid");
const mysql_1 = require("../../../helpers/mysql");
const packets_1 = __importDefault(require("./interface/packets"));
const constants_1 = __importDefault(require("./interface/constants"));
const mysql_worker_1 = require("../worker/mysql_worker");
const query_parser_1 = __importDefault(require("../query_parser/query_parser"));
const reserved_1 = __importDefault(require("./helpers/reserved"));
const global_1 = require("../../config/global");
class Handler {
    constructor() {
        this.mysqlversion = 8;
        this.conn = [];
        this.status = [];
        this.username = [];
        this.password = [];
        this.reserved = new reserved_1.default();
        this.constant = new constants_1.default(this.mysqlversion);
    }
    connection(conn) {
        let remoteAddress = conn.remoteAddress + ':' + conn.remotePort;
        console.log('new client connection from mysql handler %s', remoteAddress);
        const packets = new packets_1.default(this.mysqlversion);
        const session_uuid = uuid_1.v4();
        this.conn[session_uuid] = conn;
        this.status[session_uuid] = false;
        this.username[session_uuid] = "";
        //  Send GreetingPacket Mysql
        const greeting = packets.GreetingPacket;
        this.conn[session_uuid].write(greeting.pack("Enggano Data Core 0.0.1"));
        //  Initialize Parser and Auth
        const auth = packets.AuthPacket;
        const parser = new query_parser_1.default();
        auth.setSalt1(greeting.getSalt1());
        auth.setSalt2(greeting.getSalt2());
        this.conn[session_uuid].on('data', (d) => {
            this.onData(d, session_uuid, auth, parser, packets);
        });
        this.conn[session_uuid].on('close', () => {
            this.onClose(session_uuid);
        });
        this.conn[session_uuid].on('error', (err) => {
            this.onError(err, session_uuid);
        });
    }
    checkIsCloseConnection(d, session_uuid) {
        const close1 = Buffer.from([0x01, 0x00, 0x00, 0x00, 0x0e]);
        const close2 = Buffer.from([0x01, 0x00, 0x00, 0x00, 0x01]);
        if (Buffer.compare(d, close1) == 0 || Buffer.compare(d, close2) == 0) {
            this.conn[session_uuid].destroy();
            return false;
        }
        return true;
    }
    authenticate(d, auth) {
        auth.unpack(d);
        const result = auth.authenticate();
        return result;
    }
    processQueryReserved(query, session_uuid, packets, parser, reserved) {
        return __awaiter(this, void 0, void 0, function* () {
            if (reserved.action == "write") {
                this.conn[session_uuid].write(reserved.data);
            }
            else if (reserved.action == "query") {
                query = reserved.data;
                let dataSrcType = "mysql";
                let results = yield mysql_worker_1.mysqlProcess(query, global_1.configDBInfoSchema, dataSrcType, reserved.is_eof);
                this.conn[session_uuid].write(results);
            }
        });
    }
    processQuery(query, session_uuid, packets, parser, reserved) {
        var e_1, _a;
        return __awaiter(this, void 0, void 0, function* () {
            const replace1 = /U\*[A-Za-z0-9 .]+\*/gmi;
            query = query.replace(replace1, "");
            query = yield parser.process(query);
            let listConfigDB = [];
            try {
                for (var _b = __asyncValues(Object.entries(parser.table)), _c; _c = yield _b.next(), !_c.done;) {
                    const [key, value] = _c.value;
                    let queryParser = "SELECT d.datasource_physicalname, d.datasource_params FROM datasource d INNER JOIN metadata m ON d.`datasource_id`= m.`metadata_datasource` WHERE m.`metadata_model` =  '" + value + "' ";
                    try {
                        let configWorker = {};
                        let results = yield mysql_1.queryAsync(queryParser, global_1.configDBInfoSchema);
                        let datasourceConfig = JSON.parse(results.rows[0]['datasource_params']);
                        configWorker['host'] = datasourceConfig['connection']['host'];
                        configWorker['port'] = datasourceConfig['connection']['port'];
                        configWorker['user'] = datasourceConfig['connection']['user'];
                        configWorker['password'] = datasourceConfig['connection']['password'];
                        configWorker['database'] = datasourceConfig['connection']['database'];
                        configWorker['multipleStatements'] = true;
                        listConfigDB[0] = configWorker;
                    }
                    catch (error) {
                    }
                }
            }
            catch (e_1_1) { e_1 = { error: e_1_1 }; }
            finally {
                try {
                    if (_c && !_c.done && (_a = _b.return)) yield _a.call(_b);
                }
                finally { if (e_1) throw e_1.error; }
            }
            ;
            if (listConfigDB.length == 0) {
                //Default Information Schema
                listConfigDB.push(global_1.configDBInfoSchema);
            }
            listConfigDB.forEach((configDB) => __awaiter(this, void 0, void 0, function* () {
                let dataSrcType = "mysql";
                console.log("Mysql");
                let results = yield mysql_worker_1.mysqlProcess(query, configDB, dataSrcType, true);
                this.conn[session_uuid].write(results);
                console.log("🚀 ~ Handler ~ checkReserved ~ results", results);
            }));
        });
    }
    onData(d, session_uuid, auth, parser, packets) {
        return __awaiter(this, void 0, void 0, function* () {
            try {
                let status = this.checkIsCloseConnection(d, session_uuid);
                if (!status) {
                    return false;
                }
                if (!this.status[session_uuid]) {
                    let results = this.authenticate(d, auth);
                    if (results.success) {
                        this.conn[session_uuid].write(packets.OkPacket.pack(0, 0, this.constant.Client.SERVER_STATUS_AUTOCOMMIT, 0));
                        console.log("🚀 ~ Handler ~ onData ~ packets.OkPacket.pack(0, 0, this.constant.Client.SERVER_STATUS_AUTOCOMMIT, 0)", packets.OkPacket.pack(0, 0, this.constant.Client.SERVER_STATUS_AUTOCOMMIT, 0));
                        this.status[session_uuid] = true;
                    }
                    else {
                        this.conn[session_uuid].write(packets.ErrorPacket.pack(results.code, results.errno, results.sqlMessage, results.sqlState, results.index, results.sql, 0x02));
                        console.log("🚀 ~ Handler ~ onData ~ packets.ErrorPacket.pack(results.code, results.errno, results.sqlMessage, results.sqlState, results.index, results.sql, 0x02)", packets.ErrorPacket.pack(results.code, results.errno, results.sqlMessage, results.sqlState, results.index, results.sql, 0x02));
                        this.status[session_uuid] = false;
                    }
                }
                else {
                    let query = d.slice(5, d.length).toString('latin1');
                    console.log("🚀 ~ file: handler.ts ~ line 153 ~ Handler ~ onData ~ query", query);
                    let reserved = yield this.reserved.process(query, packets);
                    if (reserved.status) {
                        this.processQueryReserved(query, session_uuid, packets, parser, reserved);
                    }
                    else {
                        this.processQuery(query, session_uuid, packets, parser, reserved);
                    }
                }
            }
            catch (error) {
                console.log("🚀 ~ file: handler.ts ~ line 156 ~ Handler ~ onData ~ error", error);
            }
        });
    }
    delete(session_uuid) {
        return __awaiter(this, void 0, void 0, function* () {
            delete this.status[session_uuid];
            delete this.username[session_uuid];
            delete this.conn[session_uuid];
        });
    }
    onClose(session_uuid) {
        this.delete(session_uuid);
        console.log('connection %s closed', session_uuid);
        this.activeConnection();
    }
    onError(err, session_uuid) {
        console.log('Connection %s error: %s', session_uuid, err.message);
    }
    activeConnection() {
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
    log(session_uuid) {
    }
}
exports.default = Handler;
