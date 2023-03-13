"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const ok_1 = __importDefault(require("../8.0/packet/ok"));
const auth_1 = __importDefault(require("../8.0/packet/auth"));
const error_1 = __importDefault(require("../8.0/packet/error"));
const greeting_1 = __importDefault(require("../8.0/packet/greeting"));
class Packet {
    constructor(version) {
        this.OkPacket = new ok_1.default(version);
        this.AuthPacket = new auth_1.default(version);
        this.ErrorPacket = new error_1.default(version);
        this.GreetingPacket = new greeting_1.default(version);
        //default for the future can use if from version
        if (version == 8) {
            this.OkPacket = new ok_1.default(version);
            this.AuthPacket = new auth_1.default(version);
            this.ErrorPacket = new error_1.default(version);
            this.GreetingPacket = new greeting_1.default(version);
        }
    }
}
exports.default = Packet;
