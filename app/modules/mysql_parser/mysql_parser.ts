import Packets from "../mysql/interface/packets";
import { convertBase, writeLengthCodedNumber, writeIntToBuffer } from "../mysql/helpers/util";
export default class MysqlParser {

    protected packets: Packets;

    constructor() {
        this.packets = new Packets(8);
    }

    error(data: any) {
        const err = this.packets.ErrorPacket;
        const buf = err.pack(data.code, data.errno, data.sqlMessage, data.sqlState, data.index, data.sql, 0x01);
        return buf;
    }

    ok() {
        const ok = this.packets.OkPacket;
        const buf = ok.pack(1, 1, 1, 1);
        return buf;
    }

    process(data, is_eof:boolean) {

        // var Header = Buffer.from([0x01, 0x00, 0x00, 0x01, 0x0c]);
        var length_fields = 0x00 + data.fields.length;
        var Header = Buffer.from([0x01, 0x00, 0x00, 0x01, length_fields]);

        var tmp: (Buffer | Array<Buffer>)[] = [];

        tmp.push(Header);

        var packet_id = 0x02;

        //Generate Fields Buffer
        data.fields.forEach(el => {

            // console.log("fields");

            var db_name = Buffer.from(el.db);
            var db_length = Buffer.from([el.db.length]);

            var table_name = Buffer.from(el.table);
            var table_length = Buffer.from([el.table.length]);

            var org_table_name = Buffer.from([0x00]);
            var org_table_length;
            if (el.orgTable) {
                org_table_name = Buffer.from(el.orgTable);
                org_table_length = Buffer.from([el.orgTable.length]);
            }

            var field_name = Buffer.from(el.name);
            var field_length = Buffer.from([el.name.length]);

            var org_field_name = Buffer.from([0x00]);
            var org_field_length;
            if (el.orgName) {
                org_field_name = Buffer.from(el.orgName);
                org_field_length = Buffer.from([el.orgName.length]);
            }

            var tmp_fields: (Buffer)[] = [];
            tmp_fields.push(db_length);
            tmp_fields.push(db_name);

            tmp_fields.push(table_length);
            tmp_fields.push(table_name);

            //Org Table assume its empty
            if (!el.orgTable) {
                tmp_fields.push(org_table_name);
            } else {
                tmp_fields.push(org_table_length);
                tmp_fields.push(org_table_name);
            }

            tmp_fields.push(field_length);
            tmp_fields.push(field_name);

            //Org Table assume its empty
            if (!el.orgName) {
                tmp_fields.push(org_field_name);
            } else {
                tmp_fields.push(org_field_length);
                tmp_fields.push(org_field_name);
            }

            var tmp_packet = Buffer.concat(tmp_fields);
            var HeaderLength = 0x00 + tmp_packet.length + 17;

            var PacketHeader = Buffer.from([HeaderLength, 0x00, 0x00, packet_id++, 0x03]);
            var def = Buffer.from("def");

            tmp.push(PacketHeader);
            tmp.push(def);

            tmp.push(db_length);
            tmp.push(db_name);

            tmp.push(table_length);
            tmp.push(table_name);

            //Org Table assume its empty
            if (!el.orgTable) {
                tmp.push(org_table_name);
            } else {
                tmp.push(org_table_length);
                tmp.push(org_table_name);
            }

            tmp.push(field_length);
            tmp.push(field_name);

            //Org Table assume its empty
            if (!el.orgName) {
                tmp.push(org_field_name);
            } else {
                tmp.push(org_field_length);
                tmp.push(org_field_name);
            }

            //[0c]
            var xC = Buffer.from([0x0c]);
            tmp.push(xC);

            //Charset
            var charset = Buffer.from(convertBase(el.charsetNr, 2));
            tmp.push(charset);

            //Max Length Field
            var max_length_field = writeLengthCodedNumber(el.length, 4);
            tmp.push(max_length_field);

            //Column Data Type
            var column_data_type = Buffer.from([el.type]);
            tmp.push(column_data_type);

            //Flags
            var flags = writeLengthCodedNumber(el.flags, 2);
            tmp.push(flags);

            //Decimals
            var decimals = Buffer.from([el.decimals]);
            tmp.push(decimals);

            //Filler
            var filler = Buffer.from([0x00, 0x00]);
            tmp.push(filler);

        });

        if (is_eof) {
            var EOF_Packet = Buffer.from([0x05, 0x00, 0x00, packet_id++, 0xfe, 0x00, 0x00, 0x02, 0x00]);
            tmp.push(EOF_Packet);
        }

        //Generate Rows Buffer
        data.rows.forEach(el => {
            var tmp_rows: (Buffer)[] = []
            data.fields.forEach(field => {
                var temp = el[field.name];
                var buffer = Buffer.from([0xfb]);
                if (temp) {
                    buffer = Buffer.from(String(temp));
                    //timestamp
                    if (field.type == 7) {
                        var date = new Date(temp);
                        temp = date.toLocaleString("sv-SE");
                        buffer = Buffer.from(temp);
                    }
                    var count_temp = writeIntToBuffer(buffer.length);
                    tmp_rows.push(count_temp);
                } else {
                    if (temp === "") {
                        buffer = Buffer.from([0x00]);
                    } else if (temp === 0) {
                        buffer = Buffer.from([0x01, 0x30]);
                    }
                }
                tmp_rows.push(buffer);
            });

            tmp_rows = Buffer.concat(tmp_rows);

            var packet_id_length = 0x00 + tmp_rows.length;
            var tmpConvertBase = convertBase(packet_id_length, 3);
            tmpConvertBase.push(packet_id++);
            var TempHeader = Buffer.from(tmpConvertBase);

            tmp.push(TempHeader);
            tmp.push(tmp_rows);
        })

        if (is_eof) {
            var tmppp1 = Buffer.from([0x05, 0x00, 0x00, packet_id]);
            var tmppp2 = Buffer.from([0xfe, 0x00, 0x00, 0x02, 0x00]);
        } else {
            var tmppp1 = Buffer.from([0x07, 0x00, 0x00, packet_id]);
            var tmppp2 = Buffer.from([0xfe, 0x00, 0x00, 0x22, 0x00, 0x00, 0x00]);
        }

        tmp.push(tmppp1);
        tmp.push(tmppp2);

        const buffer = Buffer.concat(tmp);

        return buffer;
    }

}