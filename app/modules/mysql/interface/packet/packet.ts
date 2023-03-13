import Constant from "../constants";
import UBuffer from "../../helpers/ubuffer";

export default abstract class Packet {

    protected buffer: UBuffer;
    protected constant: Constant;

    protected constructor(version: number) {
        this.buffer = new UBuffer();
        this.constant = new Constant(version);
    }

}