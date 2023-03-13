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
const select_1 = __importDefault(require("../query/select"));
const insert_1 = __importDefault(require("../query/insert"));
const update_1 = __importDefault(require("../query/update"));
const delete_1 = __importDefault(require("../query/delete"));
class Listener {
    constructor(res) {
        this.Res = res;
        this.joinexp = new RegExp("(`\\w+`.`\\w+`)", 'gmi');
        this.backtickexp = new RegExp("(?=\\`\\w+\\`\\.)^\\`(\\w+\\`\\.`\\w+)\\`|^\\`(\\w+\\`\\.\\`\\w+)\\`|^\\`(\\w+\\`\\.\\`\\w+)\\`|^\\`(\\w+)\\`", 'mi');
        // this.equalexp = new RegExp("=([A-Za-z0-9_`'\"]+)");
        this.equalexp = new RegExp("=('[A-Za-z0-9_`\ \"]+'|[0-9]+)");
        // this.tickexp = new RegExp("[A-Za-z0-9_.`'=]+", 'gmi');
        // this.tickexp = new RegExp("`[A-Za-z0-9_.' `]+[= ]+ [0-9]+ |`[A-Za-z0-9_.' `]+[= ]+'[A-Za-z0-9_.`'= ]+'", 'gm');
        this.tickexp = new RegExp("`[A-Za-z0-9_`\ .\"]+`='[A-Za-z0-9_`\ \"]+'|`[A-Za-z0-9_`\ .\"]+`=[0-9]+", 'gm');
        this.fromexp = new RegExp("FROM (`[A-Za-z0-9_`\.\"]+`|[A-Za-z0-9_`\.\"]+)");
        this.index_column_value = 0;
        this.field = [];
    }
    getFirstGroup(regexp, str) {
        let data = [];
        try {
            data = [...str.match(regexp)];
            data = data[0].split(".");
            data.forEach((value, index, self) => {
                data[index] = value.replace(/`/g, "");
            });
        }
        catch (error) {
        }
        return data;
    }
    getFirstGroupExp(regexp, str) {
        let match = regexp.exec(str);
        if (match) {
            return (match.hasOwnProperty(1)) ? match[1] : null;
        }
        return null;
    }
    addFrom(query) {
        let from = this.getFirstGroupExp(this.fromexp, this.Res.query);
        let table = from.replace(/`/g, "");
        this.Res.querypart.table_selected = table;
        this.Res.table.push(table);
    }
    addTableField(field) {
        let arr = field.split(",");
        arr.forEach(ctx => {
            let tmp = this.getFirstGroup(this.backtickexp, ctx);
            if (tmp.length > 0) {
                let table = (tmp.length > 1) ? tmp[0] : "-";
                let column = (tmp.length > 1) ? tmp[1] : tmp[0];
                if (!this.Res.querypart.table_field.hasOwnProperty(table)) {
                    this.Res.querypart.table_field[table] = [];
                }
                this.Res.querypart.table_field[table].push(column);
                let value_tmp = this.getFirstGroupExp(this.equalexp, ctx);
                if (value_tmp) {
                    this.addColumnValue(value_tmp, column);
                }
            }
        });
    }
    addWhereField(where) {
        let tmp = this.getFirstGroup(this.backtickexp, where);
        let tmp_val = this.getFirstGroupExp(this.equalexp, where);
        if (tmp.length > 0 && tmp_val > 0) {
            let table = (tmp.length > 1) ? tmp[0] : "-";
            let column = (tmp.length > 1) ? tmp[1] : tmp[0];
            this.Res.querypart.where_table.push(table);
            this.Res.querypart.where_field.push(column);
            this.Res.querypart.where_value.push(tmp_val);
        }
    }
    addGroupField(field) {
        this.Res.querypart.where_field.push(field);
    }
    addSortField(field) {
        this.Res.querypart.orderby_field.push(field);
    }
    addTable(ctx) {
        let tmp = this.getFirstGroup(this.backtickexp, ctx.text);
        if (tmp.length > 0) {
            if (tmp.length > 1) {
                // Table With Alias
                if (!this.Res.querypart.table_selected) {
                    this.Res.querypart.table_selected = tmp[0];
                }
                this.Res.querypart.table_alias[tmp[1]] = tmp[0];
                if (this.Res.querypart.table.hasOwnProperty(tmp[0])) {
                    this.Res.querypart.table[tmp[0]].push(tmp[1]);
                    this.Res.table.push(tmp[1]);
                }
                else {
                    //Tidak ada alias
                    this.Res.querypart.table[tmp[0]] = [];
                    this.Res.querypart.table[tmp[0]].push(tmp[1]);
                    this.Res.table.push(tmp[1]);
                }
            }
            else {
                //Table Without Alias
                if (!this.Res.querypart.table_selected) {
                    this.Res.querypart.table_selected = tmp[0];
                }
                this.Res.querypart.table_alias["-"] = tmp[0];
                if (this.Res.querypart.table.hasOwnProperty(tmp[0])) {
                    this.Res.querypart.table[tmp[0]].push("-");
                    this.Res.table.push(tmp[0]);
                }
                else {
                    this.Res.querypart.table[tmp[0]] = [];
                    this.Res.querypart.table[tmp[0]].push("-");
                    this.Res.table.push(tmp[0]);
                }
            }
        }
    }
    addColumnValueWithIndex(val) {
        this.addColumnValue(val, this.field[this.index_column_value++]);
        if (this.index_column_value >= this.field.length) {
            this.index_column_value = 0;
        }
    }
    addColumnValue(val, column) {
        val = val.replace(/`/g, "");
        if (!this.Res.querypart.column_value.hasOwnProperty(column)) {
            this.Res.querypart.column_value[column] = [];
        }
        this.Res.querypart.column_value[column].push(val);
    }
    addWhereExpression(val) {
        let exp = new RegExp("=");
        this.Res.querypart.where = val.replace(exp, " = ");
    }
    //DML : Data Manipulation Language
    // Select Statement
    enterQuerySpecification(ctx) {
        if (this.Res.querytype == "DEFAULT") {
            this.Res.querytype = "SELECT";
        }
        if (this.Res.querypart) {
            // this.Res.resultquery = await this.Res.querypart.process();
        }
        this.Res.querypart = new select_1.default(this.Res.resultquery, this.Res.ext_table, this.Res.ext_table_relation, this.Res.ext_table_field);
        // this.Res.queryspec = ctx.text;
    }
    // Update Statement
    enterUpdate(ctx) {
        if (this.Res.querytype == "DEFAULT") {
            this.Res.querytype = "UPDATE";
        }
        if (this.Res.querypart) {
            // this.Res.resultquery = await this.Res.querypart.process();
        }
        this.Res.querypart = new update_1.default(this.Res.resultquery, this.Res.ext_table, this.Res.ext_table_relation, this.Res.ext_table_field);
    }
    // Delete Statement
    enterDelete(ctx) {
        return __awaiter(this, void 0, void 0, function* () {
            if (this.Res.querytype == "DEFAULT") {
                this.Res.querytype = "DELETE";
            }
            if (this.Res.querypart) {
                // this.Res.resultquery = await this.Res.querypart.process();
            }
            this.Res.querypart = new delete_1.default(this.Res.resultquery, this.Res.ext_table, this.Res.ext_table_relation, this.Res.ext_table_field);
            this.addFrom(ctx.text);
        });
    }
    // Insert Statmenet
    enterInsertInto(ctx) {
        return __awaiter(this, void 0, void 0, function* () {
            if (this.Res.querytype == "DEFAULT") {
                this.Res.querytype = "INSERT";
            }
            if (this.Res.querypart) {
                // this.Res.resultquery = await this.Res.querypart.process();
            }
            this.Res.querypart = new insert_1.default(this.Res.resultquery, this.Res.ext_table, this.Res.ext_table_relation, this.Res.ext_table_field);
        });
    }
    // Select Attribute
    ///////////////////////////////////////////////////////-///////////////////////////////////////////////////////-///////////////////////////////////////////////////////
    enterSelectAll(ctx) {
        this.Res.querypart.is_select_all = true;
    }
    enterSelect(ctx) {
        this.addTableField(ctx.text);
    }
    // Update Attribute
    ///////////////////////////////////////////////////////-///////////////////////////////////////////////////////-///////////////////////////////////////////////////////
    enterUpdateExpression(ctx) {
        this.addTableField(ctx.text);
    }
    enterTableName(ctx) {
        this.addTable(ctx);
    }
    enterJoinCriteria(ctx) {
        let tmp = this.getFirstGroup(this.joinexp, ctx.text);
        tmp.forEach(el => {
            this.addTableField(el);
        });
    }
    enterWhereExpression(ctx) {
        let whereExpression = ctx.text.replace(/AND`/gm, ' AND `');
        whereExpression = whereExpression.replace(/OR`/gm, ' OR `');
        whereExpression = whereExpression.replace(/NOT`/gm, ' NOT `');
        this.addWhereExpression(whereExpression);
        const tmp = whereExpression.match(this.tickexp);
        if (tmp) {
            tmp.forEach(el => {
                if (el != "AND" && el != "OR" && el != "NOT") {
                    this.addWhereField(el);
                    if (this.Res.querytype == "SELECT") {
                        this.addTableField(el);
                    }
                }
            });
        }
    }
    enterGroupBy(ctx) {
        this.addTableField(ctx.text);
        this.addGroupField(ctx.text);
    }
    enterSortItem(ctx) {
        this.addTableField(ctx.text);
        this.addSortField(ctx.text);
    }
    enterTableNameWithAliases(ctx) {
        this.addTable(ctx);
    }
    enterColumnAliases(ctx) {
        this.addTableField(ctx.text.substring(1, ctx.text.length - 1));
        let table_selected = this.Res.querypart.table_selected;
        let table_alias = this.Res.querypart.table[table_selected];
        table_alias = (table_alias) ? table_alias[0] : '-';
        this.field = this.Res.querypart.table_field[table_alias];
    }
    enterStringLiteral(ctx) {
        if (this.Res.querypart.type == "INSERT") {
            this.addColumnValueWithIndex(ctx.text.replace(/`/g, "'"));
        }
    }
    enterNumericLiteral(ctx) {
        if (this.Res.querypart.type == "INSERT") {
            this.addColumnValueWithIndex(ctx.text.replace(/`/g, "'"));
        }
    }
}
exports.default = Listener;
