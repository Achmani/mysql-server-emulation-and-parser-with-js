"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const packet_1 = __importDefault(require("./packet"));
class IGreeting extends packet_1.default {
    constructor(version) {
        super(version);
        this.buffer.alloc(256);
        // DefaultAuthPluginName is the default plugin name.
        this.DefaultAuthPluginName = "mysql_native_password";
        // DefaultServerCapability is the default server capability.
        this.DefaultServerCapability = this.constant.Client.CLIENT_LONG_PASSWORD |
            this.constant.Client.CLIENT_LONG_FLAG |
            this.constant.Client.CLIENT_CONNECT_WITH_DB |
            this.constant.Client.CLIENT_PROTOCOL_41 |
            this.constant.Client.CLIENT_TRANSACTIONS |
            this.constant.Client.CLIENT_MULTI_STATEMENTS |
            this.constant.Client.CLIENT_PLUGIN_AUTH |
            this.constant.Client.CLIENT_DEPRECATE_EOF |
            this.constant.Client.CLIENT_SECURE_CONNECTION;
        // DefaultClientCapability is the default client capability.
        this.DefaultClientCapability = this.constant.Client.CLIENT_LONG_PASSWORD |
            this.constant.Client.CLIENT_LONG_FLAG |
            this.constant.Client.CLIENT_PROTOCOL_41 |
            this.constant.Client.CLIENT_TRANSACTIONS |
            this.constant.Client.CLIENT_MULTI_STATEMENTS |
            this.constant.Client.CLIENT_PLUGIN_AUTH |
            this.constant.Client.CLIENT_DEPRECATE_EOF |
            this.constant.Client.CLIENT_SECURE_CONNECTION;
        this.salt = [];
        this.salt1 = [];
        this.salt2 = [];
    }
    _log() {
        console.log("🚀 ~ file: greeting.ts ~ line 46 ~ Greeting ~ salt2", this.salt2);
        console.log("🚀 ~ file: greeting.ts ~ line 46 ~ Greeting ~ salt", this.salt);
        console.log("🚀 ~ file: greeting.ts ~ line 46 ~ Greeting ~ salt1", this.salt1);
        console.log("🚀 ~ file: greeting.ts ~ line 46 ~ Greeting ~ DefaultServerCapability", this.DefaultServerCapability);
        console.log("🚀 ~ file: greeting.ts ~ line 46 ~ Greeting ~ DefaultAuthPluginName", this.DefaultAuthPluginName);
    }
}
exports.default = IGreeting;
