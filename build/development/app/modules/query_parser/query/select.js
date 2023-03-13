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
const lodash_1 = __importDefault(require("lodash"));
const util_1 = require("../../mysql/helpers/util");
const query_1 = __importDefault(require("./query"));
class Select extends query_1.default {
    constructor(query, ext_table, ext_table_relation, ext_table_field) {
        super(query, ext_table, ext_table_relation, ext_table_field, "SELECT");
    }
    isSelectAll() {
        if (this.is_select_all) {
            let tables = Object.keys(this.table);
            let res_field = [];
            tables.forEach(table => {
                let table_field = this.ext_table_field[table];
                let is_ext = this.ext_table_relation[table];
                if (is_ext) {
                    let table_ext = Object.keys(is_ext);
                    let ext_field = [];
                    let key = table;
                    this.table_filtered_field[key] = {};
                    table_ext.forEach(table => {
                        let intersection = lodash_1.default.intersection(this.ext_table_field[table], table_field);
                        let list_field = this.ext_table_field[table];
                        if (list_field) {
                            list_field.forEach(field => {
                                if (!lodash_1.default.includes(intersection, field)) {
                                    ext_field.push(field);
                                    this.table_filtered_field[key][field] = table;
                                }
                            });
                        }
                    });
                    table_field = table_field.concat(ext_field).filter(util_1.onlyUnique);
                }
                let table_field_query = [];
                table_field.forEach(function callback(value, index) {
                    table_field_query[index] = '`' + table + '`.`' + value + '`';
                });
                res_field.push(table_field_query.join(", "));
            });
            let selectallexp = new RegExp("SELECT \\*", 'gmi');
            this.resultquery = this.resultquery.replace(selectallexp, "SELECT " + res_field.join(", "));
        }
    }
    replaceColumnDefinition(list, table_name, table_alias, table_name_column) {
        // console.log("\n");
        // console.log("replaceColumnDefinition");
        // console.log("🚀 ~ Select ~ replaceColumnDefinition ~ table_name_column", table_name_column);
        // console.log("🚀 ~ Select ~ replaceColumnDefinition ~ table_alias", table_alias);
        // console.log("🚀 ~ Select ~ replaceColumnDefinition ~ table_name", table_name);
        // console.log("🚀 ~ Select ~ replaceColumnDefinition ~ list", list);
        list.forEach(field => {
            let columnreplaceexp = new RegExp("`" + table_name + "`.(`" + field + "`)", 'gmi');
            this.resultquery = this.resultquery.replace(columnreplaceexp, "`" + table_name + "`.`" + field + "`");
            if (table_alias != "-") {
                columnreplaceexp = new RegExp("`" + table_name + "`.(`" + field + "`)", 'gmi');
                // console.log("🚀 ~ Select ~ replaceColumnDefinition ~ columnreplaceexp", columnreplaceexp);
            }
            else {
                columnreplaceexp = new RegExp("(`" + field + "`)", 'gmi');
                // console.log("🚀 ~ Select ~ replaceColumnDefinition ~ columnreplaceexp", columnreplaceexp);
            }
            this.resultquery = this.resultquery.replace(columnreplaceexp, "`" + table_name_column + "`.`" + field + "`");
        });
    }
    addJoin() {
        let result_query = "";
        try {
            this.isSelectAll();
            for (const [key, value] of Object.entries(this.table_filtered_field)) {
                let temp = this.table_alias[key];
                let tmp_table = (temp ? temp : key);
                let tmp_alias = (tmp_table ? key : tmp_table);
                let tmp_alias_abs = (tmp_alias != "-" ? tmp_alias : tmp_table);
                let relation = this.ext_table_relation[tmp_table];
                if (relation) {
                    let tmp_relation = this.table_filtered_field[tmp_alias];
                    let tmp_group_relation = this.groupObj(tmp_relation);
                    let tmp_uniq_relation = lodash_1.default.uniq(lodash_1.default.map(tmp_relation));
                    for (const [key2, value2] of Object.entries(tmp_uniq_relation)) {
                        let tmp_relation_table = value2;
                        let tmp_relation_pk = this.ext_table_relation[tmp_table][tmp_relation_table][1];
                        let tmp_relation_fk = this.ext_table_relation[tmp_table][tmp_relation_table][0];
                        let tmp_ext_table_alias = tmp_relation_table + "_" + tmp_table;
                        result_query += " LEFT JOIN `" + tmp_relation_table + "` `" + tmp_ext_table_alias + "` ON `" + tmp_alias_abs + "`.`" + tmp_relation_fk + "` = `" + tmp_ext_table_alias + "`.`" + tmp_relation_pk + "`";
                        if (this.ext_table_relation[tmp_table][tmp_relation_table].length > 3) {
                            let tmp_logical = "AND";
                            let tmp_operator = "=";
                            for (let index = 3; index < this.ext_table_relation[tmp_table][tmp_relation_table].length; index = index + 3) {
                                let model_identifier = this.ext_table_relation[tmp_table][tmp_relation_table][index];
                                let model_identifier_ext = this.ext_table_relation[tmp_table][tmp_relation_table][index + 1];
                                result_query += " " + tmp_logical + " `" + tmp_alias_abs + "`.`" + model_identifier + "` " + tmp_operator + " `" + tmp_ext_table_alias + "`.`" + model_identifier_ext + "`";
                            }
                        }
                        //Replace Table Ext Alias Column
                        this.replaceColumnDefinition(tmp_group_relation[tmp_relation_table], tmp_table, tmp_alias_abs, tmp_ext_table_alias);
                    }
                }
                //Replace Table Relation
                this.replaceColumnDefinition(this.ext_table_field[tmp_table], tmp_table, tmp_alias, tmp_alias_abs);
            }
            let query_split = "";
            let queryexp = new RegExp(" (.*)(?= WHERE)", 'gmi');
            let temp_query_split = this.resultquery.match(queryexp);
            query_split = temp_query_split ? temp_query_split[0] : "";
            if (!query_split) {
                let queryexp = new RegExp("(?<=SELECT )(.*)(?= GROUP)", 'gmi');
                let temp_query_split = this.resultquery.match(queryexp);
                query_split = temp_query_split ? temp_query_split[0] : "";
            }
            if (!query_split) {
                let queryexp = new RegExp("(?<=SELECT )(.*)(?= ORDER)", 'gmi');
                let temp_query_split = this.resultquery.match(queryexp);
                query_split = temp_query_split ? temp_query_split[0] : "";
            }
            if (!query_split) {
                query_split = this.resultquery;
            }
            this.resultquery = this.resultquery.replace(query_split, query_split + result_query);
        }
        catch (error) {
            console.log("🚀 ~ Select ~ addJoin ~ error", error);
        }
    }
    process() {
        return __awaiter(this, void 0, void 0, function* () {
            this.getColumn();
            this.log();
            this.addJoin();
            return this.resultquery;
        });
    }
}
exports.default = Select;
