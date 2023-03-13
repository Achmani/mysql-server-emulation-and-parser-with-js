"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const error_1 = __importDefault(require("../../interface/packet/error"));
class ErrorPacket extends error_1.default {
    constructor(version) {
        super(version);
    }
    pack(code, errno, sqlMessage, sqlState, index, sql, orderPacket) {
        try {
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
        catch (err) {
        }
    }
    unpack(data) {
    }
}
exports.default = ErrorPacket;
