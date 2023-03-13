"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const packet_1 = __importDefault(require("./packet"));
class ErrorPacket extends packet_1.default {
    constructor() {
        super();
    }
    pack(code, errno, sqlMessage, sqlState, index, sql, orderPacket) {
        this.buffer.alloc(256);
        const lengths = 0x00 + sqlMessage.length + sqlState.length + 4;
        // Header Packet
        this.buffer.writeBytes([lengths, 0x00, 0x00, orderPacket]);
        // Error Packet
        this.buffer.writeBytes([0xff]);
        // Error Code
        this.buffer.writeU16(this.constant.Error[code]);
        // SQL State Marker
        this.buffer.writeString("#");
        // SQL State
        this.buffer.writeString(String(sqlState));
        // Error Message                                                                                                                                                                                                
        this.buffer.writeString(String(sqlMessage));
        return this.buffer.data();
    }
    unpack(data) {
    }
}
exports.default = ErrorPacket;
