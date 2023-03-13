import { getRandomInt } from "../../helpers/util";
import IGreeting from "../../interface/packet/greeting";

export default class GreetingPacket extends IGreeting {

    constructor(version: number) {

        super(version);
        this.buffer.alloc(256);
        // DefaultAuthPluginName is the default plugin name.
        this.DefaultAuthPluginName = "mysql_native_password"
        // DefaultServerCapability is the default server capability.
        this.DefaultServerCapability = this.constant.Client.CLIENT_LONG_PASSWORD |
            this.constant.Client.CLIENT_LONG_FLAG |
            this.constant.Client.CLIENT_CONNECT_WITH_DB |
            this.constant.Client.CLIENT_PROTOCOL_41 |
            this.constant.Client.CLIENT_TRANSACTIONS |
            this.constant.Client.CLIENT_MULTI_STATEMENTS |
            this.constant.Client.CLIENT_PLUGIN_AUTH |
            this.constant.Client.CLIENT_DEPRECATE_EOF |
            this.constant.Client.CLIENT_SECURE_CONNECTION
        // DefaultClientCapability is the default client capability.
        this.DefaultClientCapability = this.constant.Client.CLIENT_LONG_PASSWORD |
            this.constant.Client.CLIENT_LONG_FLAG |
            this.constant.Client.CLIENT_PROTOCOL_41 |
            this.constant.Client.CLIENT_TRANSACTIONS |
            this.constant.Client.CLIENT_MULTI_STATEMENTS |
            this.constant.Client.CLIENT_PLUGIN_AUTH |
            this.constant.Client.CLIENT_DEPRECATE_EOF |
            this.constant.Client.CLIENT_SECURE_CONNECTION
        this.salt = [];
        this.salt1 = [];
        this.salt2 = [];
    }

    public pack(servername: string) {

        this.salt = new Array(20);

        for (let index = 0; index < this.salt.length; index++) {
            this.salt[index] = getRandomInt(1, 123)
        }

        var capLower = this.DefaultServerCapability
        var capUpper = this.DefaultServerCapability >> 16

        // i don't know what it is
        this.buffer.writeBytes([0x4a, 0x00, 0x00, 0x00]);
        // this.buffer.writeBytes([0x44+servername.length, 0x00, 0x00, 0x00]);

        // 1: [0a] protocol version
        this.buffer.writeBytes([0x0a]);

        // string[NUL]: server version
        // this.buffer.writeString(servername);
        this.buffer.writeBytes([0x38, 0x2e, 0x30, 0x2e, 0x32, 0x36]);
        this.buffer.writeZero(1);

        // 4: connection id
        this.buffer.writeU32(1);

        // string[8]: auth-plugin-data-part-1
        this.buffer.writeBytes(this.salt.slice(0, 8));
        this.salt1 = this.salt.slice(0, 8);

        // 1: [00] filler
        this.buffer.writeZero(1);

        // 2: capability flags (lower 2 bytes)
        this.buffer.writeU16(capLower);

        // 1: character set
        // this.buffer.writeU8(this.constant.Client.CharacterSetUtf8);
        this.buffer.writeBytes([0x03f]);

        // 2: status flags
        this.buffer.writeU16(this.constant.Client.SERVER_STATUS_AUTOCOMMIT);

        // 2: capability flags (upper 2 bytes)
        this.buffer.writeU16(capUpper);

        // Length of auth plugin data.
        // Always 21 (8 + 13).
        this.buffer.writeU8(21);

        // string[10]: reserved (all [00])
        this.buffer.writeZero(10);

        // string[$len]: auth-plugin-data-part-2 ($len=MAX(13, length of auth-plugin-data - 8))
        this.buffer.writeBytes(this.salt.slice(-12));
        this.salt2 = this.salt.slice(-12);
        this.buffer.writeZero(1);


        this.buffer.writeString(this.DefaultAuthPluginName);
        this.buffer.writeZero(1);

        return this.buffer.data();

    }

    public unpack() {
    }

    public getSalt1() {
        return this.salt1;
    }

    public getSalt2() {
        return this.salt2;
    }

}
