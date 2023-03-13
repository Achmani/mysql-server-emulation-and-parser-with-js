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
class Update extends query_1.default {
    constructor(query, ext_table, ext_table_relation, ext_table_field) {
        super(query, ext_table, ext_table_relation, ext_table_field, "UPDATE");
    }
    updateArr() {
        return __awaiter(this, void 0, void 0, function* () {
            try {
                let tmp_table = this.table_selected;
                // Generate Fields, Filtered, Primary Key
                let fields = [];
                let filtered_field = Object.keys(this.table_filtered_field[tmp_table]);
                let primary_key = yield this.getPrimaryKey(this.table_selected);
                for (const [key, field] of Object.entries(this.table_field[tmp_table])) {
                    if (!filtered_field.includes(field)) {
                        fields.push(field);
                        console.log("🚀 ~ Update ~ updateArr ~ fields", fields);
                    }
                }
                let group_filtered_field = this.groupObj(this.table_filtered_field[tmp_table]);
                let list_id = yield this.getPrimaryKeyFromWhere();
                console.log("🚀 ~ Update ~ updateArr ~ list_id", list_id);
                list_id.forEach(pk_id => {
                    console.log("🚀 ~ Update ~ updateArr ~ this.column_value", this.column_value);
                    // Generate Update
                    for (let i = 0; i < this.column_value[fields[0]].length; i++) {
                        let tmp_query = "";
                        let values_query = [];
                        tmp_query += `UPDATE \`${this.table_selected}\` SET `;
                        fields.forEach(field => {
                            let value = this.column_value[field][i];
                            values_query.push("`" + field + "` = " + value);
                        });
                        tmp_query += values_query.join() + " WHERE `" + primary_key + "` = " + pk_id + ";";
                        this.arrayquery.push(tmp_query);
                        console.log("🚀 ~ Update ~ updateArr ~ group_filtered_field", group_filtered_field);
                        for (let [ext_table, ext_fields] of Object.entries(group_filtered_field)) {
                            console.log("🚀 ~ Update ~ updateArr ~ ext_fields", ext_fields);
                            console.log("🚀 ~ Update ~ updateArr ~ ext_table", ext_table);
                            let values_query = [];
                            let ext_query = `UPDATE \`${ext_table}\` SET `;
                            ext_fields.forEach(field => {
                                let value = this.column_value[field][i];
                                values_query.push("`" + field + "` = " + value);
                            });
                            ext_query += values_query.join() + " WHERE `" + primary_key + "` = " + pk_id + ";";
                            this.arrayquery.push(ext_query);
                        }
                    }
                });
                this.resultquery = "START TRANSACTION;\n" + this.arrayquery.join("\n") + "\nCOMMIT;";
                console.log("🚀 ~ Update ~ updateArr ~ this.resultquery", this.resultquery);
            }
            catch (error) {
                console.log("🚀 ~ Update ~ updateArr ~ error", error);
            }
        });
    }
    updateStr() {
        return __awaiter(this, void 0, void 0, function* () {
            let result_query = "";
            let tmp_table = this.table_selected;
            // Generate Fields, Filtered, Primary Key
            let fields = [];
            let filtered_field = Object.keys(this.table_filtered_field[tmp_table]);
            let primary_key = yield this.getPrimaryKey(this.table_selected);
            for (const [key, field] of Object.entries(this.table_field[tmp_table])) {
                if (!filtered_field.includes(field)) {
                    fields.push(field);
                }
            }
            let group_filtered_field = this.groupObj(this.table_filtered_field[tmp_table]);
            // Generate Update
            result_query += "START TRANSACTION;\n";
            for (let i = 0; i < this.column_value[fields[0]].length; i++) {
                let values_query = [];
                result_query += `UPDATE \`${this.table_selected}\` SET `;
                fields.forEach(field => {
                    let value = this.column_value[field][i];
                    values_query.push("`" + field + "` = " + value);
                });
                result_query += values_query.join() + " WHERE `" + primary_key + "` IN (" + this.where + ");\n";
                for (let [ext_table, ext_fields] of Object.entries(group_filtered_field)) {
                    let values_query = [];
                    let ext_query = `UPDATE \`${ext_table}\` SET `;
                    ext_fields.forEach(field => {
                        let value = this.column_value[field][i];
                        values_query.push("`" + field + "` = " + value);
                    });
                    ext_query += values_query.join() + " WHERE `" + primary_key + "` IN (" + this.where + ");\n";
                    result_query += "\n" + ext_query;
                }
            }
            result_query += "COMMIT;";
            this.resultquery = result_query;
        });
    }
    process() {
        return __awaiter(this, void 0, void 0, function* () {
            this.getColumn();
            yield this.generateWhere();
            yield this.updateArr();
            // await this.updateStr();
            this.log();
            return this.resultquery;
        });
    }
}
exports.default = Update;
