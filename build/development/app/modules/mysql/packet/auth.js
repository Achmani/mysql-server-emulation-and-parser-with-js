"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const buffer_1 = __importDefault(require("buffer"));
const packet_1 = __importDefault(require("./packet"));
const encrypt_1 = require("../utitlity/encrypt");
class AuthPacket extends packet_1.default {
    constructor() {
        super();
        this.clientFlags = 0;
        this.maxPacketSize = 0;
        this.charset = "";
        this.user = "";
        this.authResponseLen = 0;
        this.authResponse = "";
        this.database = "";
        this.pluginName = "";
        this.salt1 = [];
        this.salt2 = [];
        this.user_auth = {
            "root": "*52970E532176A5A18F067477500B9A3DE01B8EF4",
            "user": "*2470C0C06DEE42FD1618BB99005ADCA2EC9D1E19"
        };
    }
    pack() {
    }
    unpack(data) {
        this.buffer.from(data);
        this.buffer.seek = 4; // Header Packet Auth
        this.clientFlags = this.buffer.readU32();
        this.maxPacketSize = this.buffer.readU32();
        this.charset = this.buffer.readU8();
        this.buffer.readZero(23);
        this.user = this.buffer.readStringNul();
        this.buffer.readZero(1);
        this.authResponseLen = this.buffer.readU8();
        this.authResponse = this.buffer.readBytes(this.authResponseLen);
        if (this.buffer.buf.length - this.buffer.seek > 0) {
            this.database = this.buffer.readBytes(this.buffer.buf.length - this.buffer.seek);
        }
        this._log();
    }
    authenticate() {
        var result = [];
        //Check if user exist
        var password = this.user_auth[this.user];
        if (password) {
            password = password.substring(1);
            var auth1 = Buffer.from(this.salt1);
            var auth2 = Buffer.from(this.salt2);
            var auth_data = Buffer.concat([auth1, auth2]);
            const auth_str = auth_data.toString('binary');
            const cipher = buffer_1.default.transcode(Buffer.from(password, "hex"), "latin1", "utf8");
            const right = buffer_1.default.transcode(Buffer.from(encrypt_1.sha1(auth_str + cipher.toString())), "utf8", "latin1");
            const left = encrypt_1.xor(right, this.authResponse);
            const pwd = buffer_1.default.transcode(Buffer.from(encrypt_1.sha1(left)), "utf8", "latin1").toString("hex").toUpperCase();
            if (password === pwd) {
                result["success"] = true;
            }
            else {
                result["success"] = false;
                result["code"] = "ER_PASSWORD_NO_MATCH";
                result["sql"] = "";
                result["index"] = 0;
                result["sqlState"] = "HY000";
                result["sqlMessage"] = "Password not match";
                result["errno"] = 1133;
                console.log("Password not match");
            }
        }
        else {
            result["success"] = false;
            result["code"] = "ER_NO_SUCH_USER";
            result["sql"] = "";
            result["index"] = 0;
            result["sqlState"] = "HY000";
            result["sqlMessage"] = "User '" + this.user + "' doesn't exist";
            result["errno"] = 1449;
            console.log("User Not Found");
        }
        return result;
    }
    _log() {
        console.log("🚀 ~ file: auth.ts ~ line 110 ~ AuthPacket ~ user_auth", this.user_auth);
        console.log("🚀 ~ file: auth.ts ~ line 110 ~ AuthPacket ~ salt2", this.salt2);
        console.log("🚀 ~ file: auth.ts ~ line 110 ~ AuthPacket ~ salt1", this.salt1);
        console.log("🚀 ~ file: auth.ts ~ line 110 ~ AuthPacket ~ pluginName", this.pluginName);
        console.log("🚀 ~ file: auth.ts ~ line 110 ~ AuthPacket ~ database", this.database);
        console.log("🚀 ~ file: auth.ts ~ line 110 ~ AuthPacket ~ authResponse", this.authResponse);
        console.log("🚀 ~ file: auth.ts ~ line 110 ~ AuthPacket ~ authResponseLen", this.authResponseLen);
        console.log("🚀 ~ file: auth.ts ~ line 110 ~ AuthPacket ~ user", this.user);
        console.log("🚀 ~ file: auth.ts ~ line 110 ~ AuthPacket ~ charset", this.charset);
        console.log("🚀 ~ file: auth.ts ~ line 110 ~ AuthPacket ~ maxPacketSize", this.maxPacketSize);
        console.log("🚀 ~ file: auth.ts ~ line 110 ~ AuthPacket ~ clientFlags", this.clientFlags);
    }
}
exports.default = AuthPacket;
