"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const packet_1 = __importDefault(require("./packet"));
class OkPacketDev extends packet_1.default {
    constructor() {
        super();
    }
    pack(AffectedRows, LastInsertID, StatusFlags, Warnings, ClientSessionTrack, ServerSessionStateChanged) {
        this.buffer.alloc(64);
        // Header Packet
        this.buffer.writeBytes([0x0b, 0x00, 0x00, 0x02]);
        // OK
        this.buffer.writeU8(this.constant.client.OK_PACKET);
        // Affected Rows
        this.buffer.writeLenEncode(AffectedRows);
        // Last Insert Id
        this.buffer.writeLenEncode(LastInsertID);
        // Status Flags
        this.buffer.writeU16(StatusFlags);
        // Warnings
        this.buffer.writeU8(0x00);
        this.buffer.writeU8(Warnings);
        this.buffer.writeU16(0);
        // Client Session Track
        this.buffer.writeLenEncode(ClientSessionTrack);
        // Server Session State Changed
        this.buffer.writeLenEncode(ServerSessionStateChanged);
        this.buffer.writeBytes([0x00, 0x00, 0x00]);
        //
        return this.buffer.data();
    }
    unpack(data) {
        this.buffer.from(data);
    }
    log() {
    }
}
exports.default = OkPacketDev;
