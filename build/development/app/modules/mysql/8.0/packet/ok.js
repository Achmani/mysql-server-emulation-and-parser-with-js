"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const ok_1 = __importDefault(require("../../interface/packet/ok"));
class OkPacket extends ok_1.default {
    constructor(version) {
        super(version);
        this.AffectedRows = 1;
        this.LastInsertID = 1;
        this.StatusFlags = 1;
        this.Warnings = 1;
    }
    pack(AffectedRows, LastInsertID, StatusFlags, Warnings, OrderPacket = 0x02) {
        this.buffer.alloc(64);
        // Header Packet
        this.buffer.writeBytes([0x07, 0x00, 0x00, OrderPacket]);
        // OK
        this.buffer.writeU8(this.constant.Client.OK_PACKET);
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
}
exports.default = OkPacket;
