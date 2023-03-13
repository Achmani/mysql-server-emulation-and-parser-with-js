"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    Object.defineProperty(o, k2, { enumerable: true, get: function() { return m[k]; } });
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
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
const mysql_1 = __importDefault(require("mysql"));
const query_parser_1 = __importDefault(require("../query_parser"));
const mysql_2 = require("../../../../helpers/mysql");
const global_1 = __importStar(require("../../../config/global"));
class Query {
    constructor(query, ext_table, ext_table_relation, ext_table_field, type) {
        this.config = {
            "host": global_1.default.HOST_DB,
            "port": global_1.default.PORT_DB,
            "user": global_1.default.USER_DB,
            "password": global_1.default.PASS_DB,
            "database": global_1.default.DB_INFO_SCHEMA
        };
        this.mysql_conn = mysql_1.default.createConnection(this.config);
        this.type = type;
        this.query = query;
        this.queryspec = query;
        this.resultquery = query;
        this.arrayquery = [];
        this.where = "";
        this.where_table = [];
        this.where_field = [];
        this.where_value = [];
        this.where_is_query = false;
        this.orderby = [];
        this.orderby_table = [];
        this.orderby_field = [];
        this.groupby = [];
        this.groupby_table = [];
        this.groupby_field = [];
        this.is_select_all = false;
        this.table = [];
        this.table_alias = [];
        this.table_field = {};
        this.table_selected = "";
        this.table_filtered_field = {};
        this.column_value = {};
        this.ext_table = ext_table;
        this.ext_table_relation = ext_table_relation;
        this.ext_table_field = ext_table_field;
        this.operator = {
            "EQUAL": "="
        };
    }
    getPrimaryKey(model) {
        return __awaiter(this, void 0, void 0, function* () {
            const query = `SELECT mf.metadatafield_field AS metadatafield_field FROM metadata m LEFT JOIN metadata_field mf ON m.metadata_id = mf.metadatafield_metadata WHERE m.metadata_model = "${model}" AND mf.metadatafield_key = "PK" ORDER BY mf.metadatafield_order ASC`;
            const results = yield mysql_2.queryAsync(query, this.config);
            const arr = this.toArray(results.rows, "metadatafield_field");
            return arr;
        });
    }
    getColumn() {
        try {
            Object.keys(this.table_field).forEach(key => {
                let tmp_table = this.table_alias[key];
                tmp_table = (tmp_table ? tmp_table : key);
                if (this.ext_table[tmp_table]) {
                    let tmpfield = this.table_field[key];
                    tmpfield.forEach(el_field => {
                        let is_exist_self = this.ext_table_field[tmp_table].includes(el_field);
                        if (!is_exist_self) {
                            let is_exist_in_relationship = this.ext_table[tmp_table][el_field];
                            if (is_exist_in_relationship) {
                                let tmp_field = el_field;
                                let tmp_table = is_exist_in_relationship;
                                if (!this.table_filtered_field.hasOwnProperty(key)) {
                                    this.table_filtered_field[key] = {};
                                }
                                this.table_filtered_field[key][tmp_field] = tmp_table;
                            }
                            else {
                            }
                        }
                    });
                }
            });
        }
        catch (error) {
            console.log("🚀 ~ Query ~ getColumn ~ error", error);
        }
    }
    toArray(obj, field) {
        let results;
        results = [];
        for (const [key, value] of Object.entries(obj)) {
            results.push(value[field]);
        }
        return results;
    }
    groupObj(obj) {
        let results = {};
        for (const [key, value] of Object.entries(obj)) {
            if (!results.hasOwnProperty(value)) {
                results[value] = [];
            }
            results[value].push(key);
        }
        ;
        return results;
    }
    generateWhere() {
        return __awaiter(this, void 0, void 0, function* () {
            let table = this.table_selected;
            let primary_key = yield this.getPrimaryKey(table);
            try {
                if (primary_key.length > 0) {
                    let pk = primary_key[0];
                    let select_query = "SELECT `" + table + "`.`" + pk + "` AS `" + pk + "` FROM `" + this.table_selected + "` WHERE " + this.where;
                    let selectParser = new query_parser_1.default();
                    select_query = yield selectParser.process(select_query);
                    console.log("🚀 ~ Query ~ generateWhere ~ select_query", select_query);
                    this.where = select_query;
                    console.log("🚀 ~ Query ~ generateWhere ~ this.where", this.where);
                }
            }
            catch (error) {
                console.log("🚀 ~ Query ~ generateWhere ~ error", error);
            }
        });
    }
    getPrimaryKeyFromWhere() {
        return __awaiter(this, void 0, void 0, function* () {
            let table_selected = this.table_selected;
            let table_ext = Object.keys(this.ext_table_relation[table_selected]);
            let primary_key = yield this.getPrimaryKey(this.table_selected);
            table_ext.unshift(table_selected);
            let selectQuery = this.where;
            let results = yield mysql_2.queryAsync(selectQuery, global_1.configDB);
            let list_id = [];
            Object.entries(results.rows).forEach((entry) => {
                list_id.push(entry[1].id);
            });
            return list_id;
        });
    }
    log() {
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ column_value", this.column_value);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ table_filtered_field", this.table_filtered_field);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ table_selected", this.table_selected);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ table_field", this.table_field);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ table_alias", this.table_alias);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ table", this.table);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ is_select_all", this.is_select_all);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ groupby_field", this.groupby_field);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ groupby_table", this.groupby_table);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ groupby", this.groupby);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ orderby_field", this.orderby_field);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ orderby_table", this.orderby_table);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ orderby", this.orderby);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ where_is_query", this.where_is_query);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ where_value", this.where_value);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ where_field", this.where_field);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ where_table", this.where_table);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ where", this.where);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ resultquery", this.resultquery);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ queryspec", this.queryspec);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ query", this.query);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ type", this.type);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ config", this.config);
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ constructor ~ arrayquery", this.arrayquery);
    }
}
exports.default = Query;
