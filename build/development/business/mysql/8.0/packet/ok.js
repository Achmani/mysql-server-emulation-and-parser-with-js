"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const packet_1 = __importDefault(require("./packet"));
class OkPacket extends packet_1.default {
    constructor() {
        super();
        this.AffectedRows = 1;
        this.LastInsertID = 1;
        this.StatusFlags = 1;
        this.Warnings = 1;
    }
    pack(AffectedRows, LastInsertID, StatusFlags, Warnings) {
        this.buffer.alloc(64);
        // i don't know what it is
        this.buffer.writeBytes([0x07, 0x00, 0x00, 0x02]);
        // OK
        this.buffer.writeU8(this.constant.Client.OK_PACKET);
        1;
        // affected rows
        this.buffer.writeLenEncode(AffectedRows);
        // last insert id
        this.buffer.writeLenEncode(LastInsertID);
        // status
        this.buffer.writeU16(StatusFlags);
        // warnings
        this.buffer.writeU16(Warnings);
        return this.buffer.data();
    }
    unpack(data) {
        this.buffer.from(data);
    }
    _log() {
        console.log("🚀 ~ file: ok.ts ~ line 52 ~ OkPacket ~ Warnings", this.Warnings);
        console.log("🚀 ~ file: ok.ts ~ line 52 ~ OkPacket ~ StatusFlags", this.StatusFlags);
        console.log("🚀 ~ file: ok.ts ~ line 52 ~ OkPacket ~ LastInsertID", this.LastInsertID);
        console.log("🚀 ~ file: ok.ts ~ line 52 ~ OkPacket ~ AffectedRows", this.AffectedRows);
    }
}
exports.default = OkPacket;
