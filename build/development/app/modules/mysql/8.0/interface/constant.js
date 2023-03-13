"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const error_1 = __importDefault(require("../constant/error"));
const client_1 = __importDefault(require("../constant/client"));
class Constant {
    constructor() {
        this.Client = new client_1.default();
        this.Error = new error_1.default();
    }
}
exports.default = Constant;
