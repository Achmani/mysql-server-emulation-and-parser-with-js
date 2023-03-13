import buffer from 'buffer';
import IAuth from "../../interface/packet/auth";
import { sha1, xor } from '../../helpers/encrypt';
import Constants from '../../interface/constants';

export interface resultConnection {

}

export interface resultAuth {
    success: boolean,
    code: string,
    sql: string,
    index: number,
    sqlState: string,
    sqlMessage: string,
    errno: number
}

export default class AuthPacket extends IAuth {

    public constructor(version: number) {
        super(version);
    }

    public pack(): void {

    }

    public unpack(data: Buffer) {

        let constant = new Constants(8);

        this.buffer.from(data);

        this.buffer.seek = 4;   // Header Packet Auth
        this.clientFlags = this.buffer.readU32();
        
        let isconnectwithdb = constant.Client.CLIENT_CONNECT_WITH_DB & this.clientFlags;
        let ispluginauth = constant.Client.CLIENT_PLUGIN_AUTH & this.clientFlags;
        let isconnectattrs = constant.Client.CLIENT_CONNECT_ATTRS & this.clientFlags;

        this.maxPacketSize = this.buffer.readU32();
        this.charset = this.buffer.readU8();
        this.buffer.readZero(23);
        this.user = this.buffer.readStringNul().toString('utf8');
        this.buffer.readZero(1);
        this.authResponseLen = this.buffer.readU8();
        this.authResponse = this.buffer.readBytes(this.authResponseLen);
        if(isconnectwithdb){
            this.database = this.buffer.readStringNul().toString('utf8');
        }
        if(ispluginauth){
            this.pluginName = this.buffer.readStringNul().toString('utf8');
        }
        if(isconnectattrs){
            
        }
    }

    public authenticate(): resultAuth {

        let result: resultAuth = {
            success: false,
            code: "ER_NO_SUCH_USER",
            sql: "",
            index: 0,
            sqlState: "HY000",
            sqlMessage: "User doesn't exist",
            errno: 1449
        }

        //Check if user exist
        var password = this.user_auth[this.user];
        if (password) {
            password = password.substring(1);
            var auth1 = Buffer.from(this.salt1);
            var auth2 = Buffer.from(this.salt2);
            var auth_data = Buffer.concat([auth1, auth2]);
            const auth_str = auth_data.toString('binary');
            const cipher = buffer.transcode(Buffer.from(password, "hex"), "latin1", "utf8");
            const right = buffer.transcode(Buffer.from(sha1(auth_str + cipher.toString())), "utf8", "latin1");
            const left = xor(right, this.authResponse);
            const pwd = buffer.transcode(Buffer.from(sha1(left)), "utf8", "latin1").toString("hex").toUpperCase();

            if (password === pwd) {
                result.success = true;
            } else {
                result.success = false;
                result.code = "ER_PASSWORD_NO_MATCH";
                result.sqlMessage = "Password not match";
                result.errno = 1133;
            }
        }
        return result;
    }

}
