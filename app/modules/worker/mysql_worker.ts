import { queryAsync } from '../../../helpers/mysql';
import Packets from '../mysql/interface/packets';
import MysqlParser from '../mysql_parser/mysql_parser';


export async function mysqlProcess(query: string, configWorker: Object, dataSrcType: string, is_eof: boolean) {

    let packets = new Packets(8);

    const parser = new MysqlParser();
    let res = [];
    let buf: any;
    try {
        let results: any = await queryAsync(query, configWorker);
        res["success"] = true;
        res["fields"] = results.fields;
        res["rows"] = results.rows;
        if (results.rows.length >= 1) {
            let constructor_packet = results.rows[0].constructor.name;
            if (constructor_packet == "OkPacket") {
                buf = packets.OkPacket.pack(1, 1, 1, 1, 0x01);
            } else if (constructor_packet == "ErrorPacket") {
                buf = packets.OkPacket.pack(1, 1, 1, 1, 0x01);
            } else {
                buf = parser.process(res, is_eof);
            }
        } else {
            buf = packets.OkPacket.pack(1, 1, 1, 1);
        }
    } catch (error: any) {
        res["success"] = false;
        res["code"] = error.code;
        res["sql"] = error.sql;
        res["index"] = error.index;
        // res["index"] = 1;
        res["sqlState"] = error.sqlState;
        res["sqlMessage"] = error.sqlMessage;
        res["errno"] = error.errno;
        buf = parser.error(res);
    }
    return buf;
}
