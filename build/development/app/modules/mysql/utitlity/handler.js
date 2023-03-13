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
const promise_1 = __importDefault(require("mysql2/promise"));
const constant_1 = __importDefault(require("../const/constant"));
const global_1 = __importDefault(require("../../../config/global"));
const ok_1 = __importDefault(require("../packet/ok"));
const auth_1 = __importDefault(require("../packet/auth"));
const error_1 = __importDefault(require("../packet/error"));
const greeting_1 = __importDefault(require("../packet/greeting"));
const reserved_1 = __importDefault(require("./reserved"));
const mysql_worker_1 = require("../../worker/mysql_worker");
const query_parser_1 = __importDefault(require("../../query_parser/query_parser"));
class Handler {
    constructor() {
        this.conn = [];
        this.status = [];
        this.username = [];
        this.salt1 = [];
        this.salt2 = [];
        this.password = [];
        this.auth = [];
        this.parser = [];
        this.constant = new constant_1.default();
        this.reserved = new reserved_1.default();
    }
    connection(conn) {
        let remoteAddress = conn.remoteAddress + ':' + conn.remotePort;
        console.log('new client connection from mysql handler %s', remoteAddress);
        const session_uuid = uuid_1.v4();
        this.conn[session_uuid] = conn;
        this.conn[session_uuid];
        this.status[session_uuid] = false;
        this.username[session_uuid] = "";
        this.salt1[session_uuid] = "";
        this.salt2[session_uuid] = "";
        this.auth[session_uuid] = new auth_1.default();
        this.parser[session_uuid] = new query_parser_1.default();
        //Send GreetingPacket Mysql
        const greeting = new greeting_1.default();
        this.conn[session_uuid].write(greeting.pack("Enggano Data Core 0.0.1"));
        //Salt
        this.salt1[session_uuid] = greeting.salt1;
        this.salt2[session_uuid] = greeting.salt2;
        this.conn[session_uuid].on('data', (d) => {
            this.onData(d, session_uuid);
        });
        this.conn[session_uuid].on('close', () => {
            this.onClose(session_uuid);
        });
        this.conn[session_uuid].on('error', (err) => {
            this.onError(err, session_uuid);
        });
        this.auth[session_uuid].salt1 = Buffer.from(greeting.salt1);
        this.auth[session_uuid].salt2 = Buffer.from(greeting.salt2);
    }
    onData(d, session_uuid) {
        var e_1, _a;
        return __awaiter(this, void 0, void 0, function* () {
            const close1 = Buffer.from([0x01, 0x00, 0x00, 0x00, 0x0e]);
            const close2 = Buffer.from([0x01, 0x00, 0x00, 0x00, 0x01]);
            if (Buffer.compare(d, close1) == 0 || Buffer.compare(d, close2) == 0) {
                console.log("Close Connection");
                this.conn[session_uuid].destroy();
                return;
            }
            if (!this.status[session_uuid]) {
                this.auth[session_uuid].unpack(d);
                this.username[session_uuid] = this.auth[session_uuid].user;
                this.password[session_uuid] = this.auth[session_uuid].authResponse;
                const authData = this.auth[session_uuid].authenticate();
                if (authData["success"]) {
                    console.log("Success Auth");
                    const okPacket = new ok_1.default();
                    this.conn[session_uuid].write(okPacket.pack(0, 0, this.constant.Client.SERVER_STATUS_AUTOCOMMIT, 0));
                    this.status[session_uuid] = true;
                }
                else {
                    console.log("Error Auth");
                    const err = new error_1.default();
                    const errPacket = err.pack(authData.code, authData.errno, authData.sqlMessage, authData.sqlState, authData.index, authData.sql, 0x02);
                    this.conn[session_uuid].write(errPacket);
                }
            }
            else {
                console.log("");
                console.log("/---------------------------------------------------------------------------------------/");
                let query = d.slice(5, d.length).toString('latin1');
                console.log(query);
                let config = {
                    "host": global_1.default.HOST_DB,
                    "port": global_1.default.PORT_DB,
                    "user": global_1.default.USER_DB,
                    "password": global_1.default.PASS_DB,
                    "database": global_1.default.DB_INFO_SCHEMA,
                    "multipleStatements": true
                };
                let reserved = yield this.reserved.process(query);
                if (reserved.status) {
                    console.log(reserved.data);
                    if (reserved.action == "write") {
                        console.log(reserved.data);
                        this.conn[session_uuid].write(reserved.data);
                    }
                    else if (reserved.action == "query") {
                        query = reserved.data;
                        let dataSrcType = "mysql-jooq";
                        let configWorker = config;
                        console.log("Mysql JOOQ");
                        console.log(config);
                        let results = yield mysql_worker_1.mysqlProcess(query, configWorker, dataSrcType);
                        this.conn[session_uuid].write(results);
                    }
                }
                else {
                    const replace1 = /U\*[A-Za-z0-9 .]+\*/gmi;
                    query = query.replace(replace1, "");
                    query = yield this.parser[session_uuid].process(query);
                    console.log(`Query After Parser ${this.conn[session_uuid].remoteAddress}:${this.conn[session_uuid].remotePort} -> ${session_uuid}`);
                    console.log(query);
                    console.log("/---------------------------------------------------------------------------------------/");
                    console.log("");
                    //Config Process
                    let configWorker = {
                        "host": global_1.default.HOST_DB,
                        "port": global_1.default.PORT_DB,
                        "user": global_1.default.USER_DB,
                        "password": global_1.default.PASS_DB,
                        "database": global_1.default.DB,
                        "multipleStatements": true
                    };
                    console.log("----------------");
                    console.log(this.parser[session_uuid].table);
                    console.log("----------------");
                    const conn = yield promise_1.default.createConnection(config);
                    try {
                        for (var _b = __asyncValues(Object.entries(this.parser[session_uuid].table)), _c; _c = yield _b.next(), !_c.done;) {
                            const [key, value] = _c.value;
                            // for await (const [key, value] of Object.entries(this.parser[session_uuid].table)) {      // Sementara ditutup untuk multiple datasource
                            let queryParser = "SELECT d.datasource_physicalname, d.datasource_params FROM datasource d INNER JOIN metadata m ON d.`datasource_id`= m.`metadata_datasource` WHERE m.`metadata_model` =  '" + value + "' ";
                            let [rows, fields] = yield conn.execute(queryParser);
                            console.log("rows");
                            console.log(rows);
                            let datasourceConfig = JSON.parse(rows[0]['datasource_params']);
                            configWorker.host = datasourceConfig['connection']['host'];
                            configWorker.port = datasourceConfig['connection']['port'];
                            configWorker.user = datasourceConfig['connection']['user'];
                            configWorker.password = datasourceConfig['connection']['password'];
                            configWorker.database = datasourceConfig['connection']['database'];
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
                    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    if (query) {
                        let dataSrcType = "mysql";
                        console.log("Mysql");
                        let results = yield mysql_worker_1.mysqlProcess(query, configWorker, dataSrcType);
                        this.conn[session_uuid].write(results);
                    }
                }
            }
        });
    }
    onClose(session_uuid) {
        this._delete(session_uuid);
        console.log('connection %s closed', session_uuid);
        this._activeConnection();
    }
    onError(err, session_uuid) {
        console.log('Connection %s error: %s', session_uuid, err.message);
    }
    _delete(session_uuid) {
        return __awaiter(this, void 0, void 0, function* () {
            delete this.auth[session_uuid];
            delete this.status[session_uuid];
            delete this.username[session_uuid];
            delete this.salt1[session_uuid];
            delete this.salt2[session_uuid];
            delete this.conn[session_uuid];
            delete this.parser[session_uuid];
        });
    }
    _activeConnection() {
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
        console.log("");
        console.log("|----------------|----------------|----------------|");
        console.log(`Username ${this.username[session_uuid]}`);
        console.log(`Password ${this.password[session_uuid]}`);
        console.log(`Salt1 ${this.salt1[session_uuid]}`);
        console.log(`Salt2 ${this.salt2[session_uuid]}`);
        console.log("|----------------|----------------|----------------|");
        console.log("");
    }
}
exports.default = Handler;
