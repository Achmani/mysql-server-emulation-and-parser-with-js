import OkPacketVer8 from "../8.0/packet/ok";
import AuthPacketVer8 from "../8.0/packet/auth";
import ErrorPacketver8 from "../8.0/packet/error";
import GreetingPacketVer8 from "../8.0/packet/greeting";

export default class Packets {

    public OkPacket: OkPacketVer8;
    public AuthPacket: AuthPacketVer8;
    public ErrorPacket: ErrorPacketver8;
    public GreetingPacket: GreetingPacketVer8;

    constructor(version: number) {

        this.OkPacket = new OkPacketVer8(version);
        this.AuthPacket = new AuthPacketVer8(version);
        this.ErrorPacket = new ErrorPacketver8(version);
        this.GreetingPacket = new GreetingPacketVer8(version);

        //default for the future can use if from version
        if (version == 8) {
            this.OkPacket = new OkPacketVer8(version);
            this.AuthPacket = new AuthPacketVer8(version);
            this.ErrorPacket = new ErrorPacketver8(version);
            this.GreetingPacket = new GreetingPacketVer8(version);
        }
    }

}