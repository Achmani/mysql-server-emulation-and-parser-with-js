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
const query_1 = __importDefault(require("./query"));
class Delete extends query_1.default {
    constructor(query, ext_table, ext_table_relation, ext_table_field) {
        super(query, ext_table, ext_table_relation, ext_table_field, "DELETE");
    }
    deleteArr() {
        return __awaiter(this, void 0, void 0, function* () {
            try {
                let table_selected = this.table_selected;
                let table_ext = Object.keys(this.ext_table_relation[table_selected]);
                let primary_key = yield this.getPrimaryKey(this.table_selected);
                table_ext.unshift(table_selected);
                let list_id = yield this.getPrimaryKeyFromWhere();
                table_ext.forEach(table => {
                    list_id.forEach(el => {
                        this.arrayquery.push("DELETE FROM `" + table + "` WHERE `" + primary_key + "` = " + el + ";");
                    });
                });
                this.resultquery = "START TRANSACTION;\n" + this.arrayquery.join("\n") + "\nCOMMIT;";
            }
            catch (error) {
            }
        });
    }
    deleteStr() {
        return __awaiter(this, void 0, void 0, function* () {
            let resultquery = "";
            let table_selected = this.table_selected;
            let table_ext = Object.keys(this.ext_table_relation[table_selected]);
            let primary_key = yield this.getPrimaryKey(this.table_selected);
            table_ext.unshift(table_selected);
            // Generate Delete
            resultquery += "START TRANSACTION;\n";
            table_ext.forEach(table => {
                resultquery += "DELETE FROM `" + table + "` WHERE `" + primary_key + "` IN (" + this.where + ");\n";
            });
            resultquery += "COMMIT;\n";
            this.resultquery = resultquery;
        });
    }
    process() {
        return __awaiter(this, void 0, void 0, function* () {
            this.getColumn();
            yield this.generateWhere();
            // await this.deleteStr();
            yield this.deleteArr();
            return this.resultquery;
        });
    }
}
exports.default = Delete;
