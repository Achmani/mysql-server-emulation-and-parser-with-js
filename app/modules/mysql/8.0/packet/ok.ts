import IOk from "../../interface/packet/ok";

export default class OkPacket extends IOk {

    constructor(version: number) {
        super(version);
        this.AffectedRows = 1;
        this.LastInsertID = 1;
        this.StatusFlags = 1;
        this.Warnings = 1;
    }

    public pack(AffectedRows: number, LastInsertID: number, StatusFlags: number, Warnings: number, OrderPacket = 0x02) {

        this.buffer.alloc(64);
        // Header Packet
        this.buffer.writeBytes([0x07, 0x00, 0x00, OrderPacket]);
        // OK
        this.buffer.writeU8(this.constant.Client.OK_PACKET);
        // affected rows
        this.buffer.writeLenEncode(AffectedRows);
        // last insert id
        this.buffer.writeLenEncode(LastInsertID);
        // status
        this.buffer.writeU16(StatusFlags);
        // warnings
        this.buffer.writeU16(Warnings);

        return this.buffer.data();
    }

    public unpack(data: Array<any>) {
        this.buffer.from(data);
    }

}