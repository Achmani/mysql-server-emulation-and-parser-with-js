"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const net_1 = __importDefault(require("net"));
const global_1 = __importDefault(require("./app/config/global"));
const handler_1 = __importDefault(require("./app/modules/mysql/handler"));
const server = net_1.default.createServer();
const handler = new handler_1.default();
server.on('connection', (conn) => {
    handler.connection(conn);
});
let port = global_1.default.PORT_SERVER;
let hostname = global_1.default.HOST_SERVER;
server.listen(port, hostname, function () {
    console.log("Enggano Data Integrator Start " + hostname + ":" + port);
});
