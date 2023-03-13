"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const buffer_1 = __importDefault(require("buffer"));
const auth_1 = __importDefault(require("../../interface/packet/auth"));
const encrypt_1 = require("../../helpers/encrypt");
const constants_1 = __importDefault(require("../../interface/constants"));
class AuthPacket extends auth_1.default {
    constructor(version) {
        super(version);
    }
    pack() {
    }
    unpack(data) {
        let constant = new constants_1.default(8);
        this.buffer.from(data);
        this.buffer.seek = 4; // Header Packet Auth
        this.clientFlags = this.buffer.readU32();
        let isconnectwithdb = constant.Client.CLIENT_CONNECT_WITH_DB & this.clientFlags;
        let ispluginauth = constant.Client.CLIENT_PLUGIN_AUTH & this.clientFlags;
        let isconnectattrs = constant.Client.CLIENT_CONNECT_ATTRS & this.clientFlags;
        this.maxPacketSize = this.buffer.readU32();
        this.charset = this.buffer.readU8();
        this.buffer.readZero(23);
        this.user = this.buffer.readStringNul().toString('utf8');
        this.buffer.readZero(1);
        this.authResponseLen = this.buffer.readU8();
        this.authResponse = this.buffer.readBytes(this.authResponseLen);
        if (isconnectwithdb) {
            this.database = this.buffer.readStringNul().toString('utf8');
        }
        if (ispluginauth) {
            this.pluginName = this.buffer.readStringNul().toString('utf8');
        }
        if (isconnectattrs) {
        }
    }
    authenticate() {
        let result = {
            success: false,
            code: "ER_NO_SUCH_USER",
            sql: "",
            index: 0,
            sqlState: "HY000",
            sqlMessage: "User doesn't exist",
            errno: 1449
        };
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
                result.success = true;
            }
            else {
                result.success = false;
                result.code = "ER_PASSWORD_NO_MATCH";
                result.sqlMessage = "Password not match";
                result.errno = 1133;
            }
        }
        return result;
    }
}
exports.default = AuthPacket;
