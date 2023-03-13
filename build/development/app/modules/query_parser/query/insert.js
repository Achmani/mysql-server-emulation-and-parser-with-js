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
class Insert extends query_1.default {
    constructor(query, ext_table, ext_table_relation, ext_table_field) {
        super(query, ext_table, ext_table_relation, ext_table_field, "INSERT");
    }
    insert() {
        return __awaiter(this, void 0, void 0, function* () {
            try {
                let resultquery = "";
                for (let [alias_table, table] of Object.entries(this.table)) {
                    let tmp_table = table[0];
                    // Generate Fields, Filtered, Primary Key
                    let fields;
                    fields = [];
                    let filtered_field = Object.keys(this.table_filtered_field[tmp_table]);
                    let primary_key = yield this.getPrimaryKey(this.table_selected);
                    for (const [key, field] of Object.entries(this.table_field[tmp_table])) {
                        if (!filtered_field.includes(field)) {
                            fields.push(field);
                        }
                    }
                    let group_filtered_field = this.groupObj(this.table_filtered_field[tmp_table]);
                    // Generate Insert
                    resultquery += "START TRANSACTION;\n";
                    for (let i = 0; i < this.column_value[fields[0]].length; i++) {
                        let values_query = [];
                        let values_tmp = [];
                        resultquery += `INSERT INTO ${this.table_selected} (${"`" + fields.join("`,`") + "`"}) VALUES `;
                        fields.forEach(field => {
                            values_tmp.push(this.column_value[field][i]);
                        });
                        values_query.push(`(${values_tmp.join()})`);
                        resultquery += values_query.join() + ";\n" + "SET @last_id_in_table1 = LAST_INSERT_ID();\n";
                        for (let [ext_table, ext_fields] of Object.entries(group_filtered_field)) {
                            ext_fields = ext_fields.concat(primary_key);
                            let tmp_query = `INSERT INTO ${ext_table} (${"`" + ext_fields.join("`,`") + "`"}) VALUES `;
                            let ext_values_query = [];
                            let ext_values_tmp = [];
                            ext_fields.forEach(field => {
                                if (this.column_value.hasOwnProperty(field)) {
                                    ext_values_tmp.push(this.column_value[field][i]);
                                }
                                else {
                                    ext_values_tmp.push("@last_id_in_table1");
                                }
                            });
                            ext_values_query.push(`(${ext_values_tmp.join()})`);
                            tmp_query += ext_values_query.join();
                            resultquery += tmp_query + ";\n";
                        }
                    }
                }
                resultquery += "COMMIT;";
                this.resultquery = resultquery;
            }
            catch (error) {
            }
        });
    }
    process() {
        return __awaiter(this, void 0, void 0, function* () {
            this.getColumn();
            yield this.insert();
            this.log();
            return this.resultquery;
        });
    }
}
exports.default = Insert;
