"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.configDBInfoSchema = exports.configDB = void 0;
const dotenv_1 = __importDefault(require("dotenv"));
// Parsing the env file.
// dotenv.config({ path: path.resolve(__dirname, ".env") });
dotenv_1.default.config();
// Loading process.env as ENV interface
const getConfig = () => {
    return {
        HOST_SERVER: process.env.HOST_SERVER ? process.env.HOST_SERVER : '127.0.0.1',
        PORT_SERVER: process.env.PORT_SERVER ? Number(process.env.PORT_SERVER) : 3306,
        HOST_DB: process.env.HOST_DB ? process.env.HOST_DB : '127.0.0.1',
        PORT_DB: process.env.PORT_DB ? Number(process.env.PORT_DB) : 41004,
        USER_DB: process.env.USER_DB ? process.env.USER_DB : 'root',
        PASS_DB: process.env.PASS_DB ? process.env.PASS_DB : 'mitra',
        DB: process.env.DB ? process.env.DB : '',
        DB_INFO_SCHEMA: process.env.DB_INFO_SCHEMA ? process.env.DB_INFO_SCHEMA : '',
    };
};
// Throwing an Error if any field was undefined we don't 
// want our app to run if it can't connect to DB and ensure 
// that these fields are accessible. If all is good return
// it as Config which just removes the undefined from our type 
// definition.
const getSanitzedConfig = (config) => {
    for (const [key, value] of Object.entries(config)) {
        if (value === undefined) {
            throw new Error(`Missing key ${key} in config.env`);
        }
    }
    return config;
};
const config = getConfig();
const sanitizedConfig = getSanitzedConfig(config);
exports.default = sanitizedConfig;
exports.configDB = {
    "host": sanitizedConfig.HOST_DB,
    "port": sanitizedConfig.PORT_DB,
    "user": sanitizedConfig.USER_DB,
    "password": sanitizedConfig.PASS_DB,
    "database": sanitizedConfig.DB,
    "multipleStatements": true
};
exports.configDBInfoSchema = {
    "host": sanitizedConfig.HOST_DB,
    "port": sanitizedConfig.PORT_DB,
    "user": sanitizedConfig.USER_DB,
    "password": sanitizedConfig.PASS_DB,
    "database": sanitizedConfig.DB_INFO_SCHEMA,
    "multipleStatements": true
};
