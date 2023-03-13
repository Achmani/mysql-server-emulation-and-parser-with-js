"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const constant_1 = __importDefault(require("../const/constant"));
const ubuffer_1 = __importDefault(require("../utitlity/ubuffer"));
class Packet {
    constructor() {
        this.buffer = new ubuffer_1.default();
        this.constant = new constant_1.default();
    }
}
exports.default = Packet;
