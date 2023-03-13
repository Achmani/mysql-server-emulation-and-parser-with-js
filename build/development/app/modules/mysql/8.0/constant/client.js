"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
class Client {
    constructor() {
        this.ERR_PACKET = 0xFF;
        this.OK_PACKET = 0;
        this.SERVER_STATUS_AUTOCOMMIT = 2;
        this.COM_SLEEP = 0x00;
        this.COM_QUIT = 0x01;
        this.COM_INIT_DB = 0x02;
        this.COM_QUERY = 0x03;
        this.COM_FIELD_LIST = 0x04;
        this.COM_CREATE_DB = 0x05;
        this.COM_DROP_DB = 0x06;
        this.COM_REFRESH = 0x07;
        this.COM_SHUTDOWN = 0x08;
        this.COM_STATISTICS = 0x09;
        this.COM_PROCESS_INFO = 0x0a;
        this.COM_CONNECT = 0x0b;
        this.COM_PROCESS_KILL = 0x0c;
        this.COM_DEBUG = 0x0d;
        this.COM_PING = 0x0e;
        this.COM_TIME = 0x0f;
        this.COM_DELAYED_INSERT = 0x10;
        this.COM_CHANGE_USER = 0x11;
        this.COM_BINLOG_DUMP = 0x12;
        this.COM_TABLE_DUMP = 0x13;
        this.COM_CONNECT_OUT = 0x14;
        this.COM_REGISTER_SLAVE = 0x15;
        this.COM_STMT_PREPARE = 0x16;
        this.COM_STMT_EXECUTE = 0x17;
        this.COM_STMT_SEND_LONG_DATA = 0x18;
        this.COM_STMT_CLOSE = 0x19;
        this.COM_STMT_RESET = 0x1a;
        this.COM_SET_OPTION = 0x1b;
        this.COM_STMT_FETCH = 0x1c;
        this.COM_DAEMON = 0x1d;
        this.COM_BINLOG_DUMP_GTID = 0x1e;
        this.COM_RESET_CONNECTION = 0x1f;
        // new more secure password
        this.CLIENT_LONG_PASSWORD = 1;
        // Found instead of affected rows
        this.CLIENT_FOUND_ROWS = 1 << 1;
        // Get all column flags
        this.CLIENT_LONG_FLAG = 1 << 2;
        // One can specify db on connect
        this.CLIENT_CONNECT_WITH_DB = 1 << 3;
        // Don't allow database.table.column
        this.CLIENT_NO_SCHEMA = 1 << 4;
        // Can use compression protocol
        this.CLIENT_COMPRESS = 1 << 5;
        // Odbc client      
        this.CLIENT_ODBC = 1 << 6;
        // Can use LOAD DATA LOCAL
        this.CLIENT_LOCAL_FILES = 1 << 7;
        // Ignore spaces before '('
        this.CLIENT_IGNORE_SPACE = 1 << 8;
        // New 4.1 protocol
        this.CLIENT_PROTOCOL_41 = 1 << 9;
        // This is an interactive client
        this.CLIENT_INTERACTIVE = 1 << 10;
        // Switch to SSL after handshake
        this.CLIENT_SSL = 1 << 11;
        // IGNORE sigpipes
        this.CLIENT_IGNORE_SIGPIPE = 1 << 12;
        // Client knows about transactions
        this.CLIENT_TRANSACTIONS = 1 << 13;
        // Old flag for 4.1 protocol
        this.CLIENT_RESERVED = 1 << 14;
        // Old flag for 4.1 authentication
        this.CLIENT_SECURE_CONNECTION = 1 << 15;
        // Enable/disable multi-stmt support
        this.CLIENT_MULTI_STATEMENTS = 1 << 16;
        // Enable/disable multi-results
        this.CLIENT_MULTI_RESULTS = 1 << 17;
        // Multi-results in PS-protocol
        this.CLIENT_PS_MULTI_RESULTS = 1 << 18;
        // Client supports plugin authentication
        this.CLIENT_PLUGIN_AUTH = 1 << 19;
        // Client supports connection attributes
        this.CLIENT_CONNECT_ATTRS = 1 << 20;
        //  Enable authentication response packet to be larger than 255 bytes
        this.CLIENT_PLUGIN_AUTH_LENENC_CLIENT_DATA = 1 << 21;
        // Don't close the connection for a connection with expired password
        this.CLIENT_CAN_HANDLE_EXPIRED_PASSWORDS = 1 << 22;
        // Capable of handling server state change information. Its a hint to the
        // server to include the state change information in Ok packet.
        this.CLIENT_SESSION_TRACK = 1 << 23;
        //Client no longer needs EOF packet
        this.CLIENT_DEPRECATE_EOF = 1 << 24;
        // CharacterSetUtf8 is for UTF8. We use this by default.
        this.CharacterSetUtf8 = 33;
        // CharacterSetBinary is for binary. Use by integer fields for instance.
        this.CharacterSetBinary = 63;
        // this.ER_ERROR_FIRST enum.
        this.ER_ERROR_FIRST = 1000;
        // this.ER_CON_COUNT_ERROR enum.
        this.ER_CON_COUNT_ERROR = 1040;
        // this.ER_DBACCESS_DENIED_ERROR enum.
        this.ER_DBACCESS_DENIED_ERROR = 1044;
        // this.ER_ACCESS_DENIED_ERROR enum.
        this.ER_ACCESS_DENIED_ERROR = 1045;
        // this.ER_NO_DB_ERROR enum.
        this.ER_NO_DB_ERROR = 1046;
        // this.ER_BAD_DB_ERROR enum.
        this.ER_BAD_DB_ERROR = 1049;
        // this.ER_BAD_DB_ERROR enum.
        this.ER_TABLE_EXISTS_ERROR = 1050;
        // this.ER_TOO_LONG_IDENT enum
        this.ER_TOO_LONG_IDENT = 1059;
        // this.ER_KILL_DENIED_ERROR enum
        this.ER_KILL_DENIED_ERROR = 1095;
        // this.ER_UNKNOWN_ERROR enum.
        this.ER_UNKNOWN_ERROR = 1105;
        // this.ER_HOST_NOT_PRIVILEGED enum.
        this.ER_HOST_NOT_PRIVILEGED = 1130;
        // this.ER_NO_SUCH_TABLE enum.
        this.ER_NO_SUCH_TABLE = 1146;
        // this.ER_SYNTAX_ERROR enum.
        this.ER_SYNTAX_ERROR = 1149;
        // this.ER_SPECIFIC_ACCESS_DENIED_ERROR enum.
        this.ER_SPECIFIC_ACCESS_DENIED_ERROR = 1227;
        // this.ER_UNKNOWN_STORAGE_ENGINE enum.
        this.ER_UNKNOWN_STORAGE_ENGINE = 1286;
        // this.ER_OPTION_PREVENTS_STATEMENT enum.
        this.ER_OPTION_PREVENTS_STATEMENT = 1290;
        // this.ER_MALFORMED_PACKET enum.
        this.ER_MALFORMED_PACKET = 1835;
        // CR_SERVthis.ER_LOST enum.
        this.CR_SERVER_LOST = 2013;
        // CR_VERSION_ERROR enum.
        // This is returned if the server versions don't match what we support.
        this.CR_VERSION_ERROR = 2007;
    }
}
exports.default = Client;
