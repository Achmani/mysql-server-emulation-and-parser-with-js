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
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.mysqlProcess = void 0;
const mysql_1 = require("../../../helpers/mysql");
const packets_1 = __importDefault(require("../mysql/interface/packets"));
const mysql_parser_1 = __importDefault(require("../mysql_parser/mysql_parser"));
function mysqlProcess(query, configWorker, dataSrcType, is_eof) {
    return __awaiter(this, void 0, void 0, function* () {
        let packets = new packets_1.default(8);
        const parser = new mysql_parser_1.default();
        let res = [];
        let buf;
        try {
            let results = yield mysql_1.queryAsync(query, configWorker);
            res["success"] = true;
            res["fields"] = results.fields;
            res["rows"] = results.rows;
            if (results.rows.length >= 1) {
                let constructor_packet = results.rows[0].constructor.name;
                if (constructor_packet == "OkPacket") {
                    buf = packets.OkPacket.pack(1, 1, 1, 1, 0x01);
                }
                else if (constructor_packet == "ErrorPacket") {
                    buf = packets.OkPacket.pack(1, 1, 1, 1, 0x01);
                }
                else {
                    buf = parser.process(res, is_eof);
                }
            }
            else {
                buf = packets.OkPacket.pack(1, 1, 1, 1);
            }
        }
        catch (error) {
            res["success"] = false;
            res["code"] = error.code;
            res["sql"] = error.sql;
            res["index"] = error.index;
            // res["index"] = 1;
            res["sqlState"] = error.sqlState;
            res["sqlMessage"] = error.sqlMessage;
            res["errno"] = error.errno;
            buf = parser.error(res);
        }
        return buf;
    });
}
exports.mysqlProcess = mysqlProcess;
