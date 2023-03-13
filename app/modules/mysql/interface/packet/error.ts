import Packet from "./packet";

export default abstract class IError extends Packet {

    protected code: number;
    protected errno: number;
    protected sqlMessage: string;
    protected sqlState: string;
    protected index: number;
    protected sql: string;
    protected orderPacket: number;

    protected constructor(version: number) {
        super(version);
        this.code = 0;
        this.errno = 0;
        this.sqlMessage = "";
        this.sqlState = "";
        this.index = 0;
        this.sql = "";
        this.orderPacket = 0.

    }

    protected _log() {
        console.log("🚀 ~ file: error.ts ~ line 23 ~ Errors ~ orderPacket", this.orderPacket)
        console.log("🚀 ~ file: error.ts ~ line 23 ~ Errors ~ sql", this.sql)
        console.log("🚀 ~ file: error.ts ~ line 23 ~ Errors ~ index", this.index)
        console.log("🚀 ~ file: error.ts ~ line 23 ~ Errors ~ sqlState", this.sqlState)
        console.log("🚀 ~ file: error.ts ~ line 23 ~ Errors ~ sqlMessage", this.sqlMessage)
        console.log("🚀 ~ file: error.ts ~ line 23 ~ Errors ~ errno", this.errno)
        console.log("🚀 ~ file: error.ts ~ line 23 ~ Errors ~ code", this.code)
    }

}
