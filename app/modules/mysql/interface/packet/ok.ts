import Packet from "./packet";

export default abstract class IOk extends Packet {

    protected AffectedRows: number;
    protected LastInsertID: number;
    protected StatusFlags: number;
    protected Warnings: number;

    protected constructor(version: number) {
        super(version);
        this.AffectedRows = 1;
        this.LastInsertID = 1;
        this.StatusFlags = 1;
        this.Warnings = 1;
    }

    protected _log() {
        console.log("🚀 ~ file: ok.ts ~ line 23 ~ Ok ~ Warnings", this.Warnings)
        console.log("🚀 ~ file: ok.ts ~ line 23 ~ Ok ~ StatusFlags", this.StatusFlags)
        console.log("🚀 ~ file: ok.ts ~ line 23 ~ Ok ~ LastInsertID", this.LastInsertID)
        console.log("🚀 ~ file: ok.ts ~ line 23 ~ Ok ~ AffectedRows", this.AffectedRows)
    }

}
