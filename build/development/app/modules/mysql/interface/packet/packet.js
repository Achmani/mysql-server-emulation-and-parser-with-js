"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const constants_1 = __importDefault(require("../constants"));
const ubuffer_1 = __importDefault(require("../../helpers/ubuffer"));
class Packet {
    constructor(version) {
        this.buffer = new ubuffer_1.default();
        this.constant = new constants_1.default(version);
    }
}
exports.default = Packet;
