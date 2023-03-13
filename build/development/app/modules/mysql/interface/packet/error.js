"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const packet_1 = __importDefault(require("./packet"));
class IError extends packet_1.default {
    constructor(version) {
        super(version);
        this.code = 0;
        this.errno = 0;
        this.sqlMessage = "";
        this.sqlState = "";
        this.index = 0;
        this.sql = "";
        this.orderPacket = 0.;
    }
    _log() {
        console.log("🚀 ~ file: error.ts ~ line 23 ~ Errors ~ orderPacket", this.orderPacket);
        console.log("🚀 ~ file: error.ts ~ line 23 ~ Errors ~ sql", this.sql);
        console.log("🚀 ~ file: error.ts ~ line 23 ~ Errors ~ index", this.index);
        console.log("🚀 ~ file: error.ts ~ line 23 ~ Errors ~ sqlState", this.sqlState);
        console.log("🚀 ~ file: error.ts ~ line 23 ~ Errors ~ sqlMessage", this.sqlMessage);
        console.log("🚀 ~ file: error.ts ~ line 23 ~ Errors ~ errno", this.errno);
        console.log("🚀 ~ file: error.ts ~ line 23 ~ Errors ~ code", this.code);
    }
}
exports.default = IError;
