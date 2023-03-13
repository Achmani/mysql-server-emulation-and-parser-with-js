import IError from "../../interface/packet/error";

export default class ErrorPacket extends IError {

    public constructor(version: number) {
        super(version);
    }

    public pack(code: string, errno: number, sqlMessage: string, sqlState: string, index: number, sql: string, orderPacket: number) {

        try {
            this.buffer.alloc(256);
            const lengths = 0x00 + sqlMessage.length + sqlState.length + 4;
            // Header Packet
            this.buffer.writeBytes([lengths, 0x00, 0x00, orderPacket]);
            // Error Packet
            this.buffer.writeBytes([0xff]);
            // Error Code
            this.buffer.writeU16(this.constant.Error[code]);
            // SQL State Marker
            this.buffer.writeString("#");
            // SQL State
            this.buffer.writeString(String(sqlState));
            // Error Message                                                                                                                                                                                                
            this.buffer.writeString(String(sqlMessage));
            return this.buffer.data();
        } catch (err) {

        }

    }

    public unpack(data: Buffer[]): void {

    }



}