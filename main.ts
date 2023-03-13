import net from 'net';
import sanitizedConfig from './app/config/global';
import Handler from './app/modules/mysql/handler';

const server = net.createServer();
const handler = new Handler();
server.on('connection', (conn: net.Socket) => {
    handler.connection(conn);
});

let port = sanitizedConfig.PORT_SERVER;
let hostname = sanitizedConfig.HOST_SERVER;

server.listen(port, hostname, function () {
    console.log("Enggano Data Integrator Start " + hostname + ":" + port);
});