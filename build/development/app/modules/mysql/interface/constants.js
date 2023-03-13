"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const error_1 = __importDefault(require("../8.0/constant/error"));
const client_1 = __importDefault(require("../8.0/constant/client"));
class Constants {
    constructor(version) {
        this.Client = new client_1.default();
        this.Error = new error_1.default();
        //default for the future can use if from version
        if (version == 8) {
            this.Client = new client_1.default();
            this.Error = new error_1.default();
        }
    }
}
exports.default = Constants;
