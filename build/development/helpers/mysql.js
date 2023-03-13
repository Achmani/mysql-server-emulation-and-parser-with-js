"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.queryAsync = void 0;
const mysql_1 = __importDefault(require("mysql"));
exports.queryAsync = (query, config) => __awaiter(void 0, void 0, void 0, function* () {
    return new Promise((resolve, reject) => {
        const datasource = mysql_1.default.createConnection(config);
        datasource.query(query, (err, row, field) => {
            return err ? reject(err) : resolve({ fields: field, rows: row });
        });
        datasource.end(function (err) {
            if (err) {
                console.log("🚀 ~ err", err);
                reject(err);
            }
        });
    });
});
