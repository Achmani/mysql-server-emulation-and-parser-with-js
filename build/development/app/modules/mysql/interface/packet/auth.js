"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const packet_1 = __importDefault(require("./packet"));
class IAuth extends packet_1.default {
    constructor(version) {
        super(version);
        this.clientFlags = 0;
        this.maxPacketSize = 0;
        this.charset = "";
        this.user = "";
        this.authResponseLen = 0;
        this.authResponse = Buffer.from("");
        this.database = "";
        this.pluginName = "";
        this.salt1 = [];
        this.salt2 = [];
        this.user_auth = {
            "root": "*52970E532176A5A18F067477500B9A3DE01B8EF4",
            "user": "*2470C0C06DEE42FD1618BB99005ADCA2EC9D1E19"
        };
    }
    _log() {
        console.log("🚀 ~ file: auth.ts ~ line 35 ~ Auth ~ user_auth", this.user_auth);
        console.log("🚀 ~ file: auth.ts ~ line 35 ~ Auth ~ salt2", this.salt2);
        console.log("🚀 ~ file: auth.ts ~ line 35 ~ Auth ~ salt1", this.salt1);
        console.log("🚀 ~ file: auth.ts ~ line 35 ~ Auth ~ pluginName", this.pluginName);
        console.log("🚀 ~ file: auth.ts ~ line 35 ~ Auth ~ database", this.database);
        console.log("🚀 ~ file: auth.ts ~ line 35 ~ Auth ~ authResponse", this.authResponse);
        console.log("🚀 ~ file: auth.ts ~ line 35 ~ Auth ~ authResponseLen", this.authResponseLen);
        console.log("🚀 ~ file: auth.ts ~ line 35 ~ Auth ~ user", this.user);
        console.log("🚀 ~ file: auth.ts ~ line 35 ~ Auth ~ charset", this.charset);
        console.log("🚀 ~ file: auth.ts ~ line 35 ~ Auth ~ maxPacketSize", this.maxPacketSize);
        console.log("🚀 ~ file: auth.ts ~ line 35 ~ Auth ~ clientFlags", this.clientFlags);
        console.log("🚀 ~ IAuth ~ _log ~ this.buffer.buf.length", this.buffer.buf.length);
        console.log("🚀 ~ IAuth ~ _log ~ this.buffer.seek", this.buffer.seek);
    }
    setSalt1(salt1) {
        this.salt1 = salt1;
    }
    setSalt2(salt2) {
        this.salt2 = salt2;
    }
}
exports.default = IAuth;
