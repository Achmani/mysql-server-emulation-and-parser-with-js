import QueryParser from "../query_parser";

import Select from "../query/select";
import Insert from "../query/insert";
import Update from "../query/update";
import Delete from "../query/delete";
import { SqlBaseListener } from "../../antlr4/SqlBaseListener";
import { NumericLiteralContext, StringLiteralContext, TableNameContext, InsertIntoContext, UpdateContext, DeleteContext, SortItemContext, QuerySpecificationContext, GroupByContext, JoinCriteriaContext, ColumnAliasesContext, WhereExpressionContext, UpdateExpressionContext, TableNameWithAliasesContext } from "../../antlr4/SqlBaseParser";

export default class Listener implements SqlBaseListener {

    protected Res: QueryParser;
    protected joinexp: RegExp;
    protected backtickexp: RegExp;
    protected equalexp: RegExp;
    protected tickexp: RegExp;
    protected fromexp: RegExp;
    protected index_column_value: number;
    protected field: Array<string>;

    public constructor(res: QueryParser) {
        this.Res = res;
        this.joinexp = new RegExp("(`\\w+`.`\\w+`)", 'gmi')
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

    protected getFirstGroup(regexp, str) {
        let data: (string)[] = []
        try {
            data = [...str.match(regexp)];
            data = data[0].split(".");
            data.forEach((value, index, self) => {
                data[index] = value.replace(/`/g, "");
            });
        } catch (error: any) {
        }
        return data;
    }

    protected getFirstGroupExp(regexp, str) {
        let match = regexp.exec(str);
        if (match) {
            return (match.hasOwnProperty(1)) ? match[1] : null;
        }
        return null;
    }

    protected addFrom(query: string) {
        let from = this.getFirstGroupExp(this.fromexp, this.Res.query);
        let table = from.replace(/`/g, "");
        this.Res.querypart.table_selected = table;
        this.Res.table.push(table);
    }

    protected addTableField(field) {
        let arr = field.split(",");
        arr.forEach(ctx => {
            let tmp = this.getFirstGroup(this.backtickexp, ctx)
            if (tmp.length > 0) {
                let table = (tmp.length > 1) ? tmp[0] : "-";
                let column = (tmp.length > 1) ? tmp[1] : tmp[0];
                if (!this.Res.querypart.table_field.hasOwnProperty(table)) {
                    this.Res.querypart.table_field[table] = [];
                }
                this.Res.querypart.table_field[table].push(column);

                let value_tmp = this.getFirstGroupExp(this.equalexp, ctx)
                if (value_tmp) {
                    this.addColumnValue(value_tmp, column);
                }
            }
        });
    }

    protected addWhereField(where: string) {
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

    protected addGroupField(field: string) {
        this.Res.querypart.where_field.push(field);
    }

    protected addSortField(field: string) {
        this.Res.querypart.orderby_field.push(field);
    }

    protected addTable(ctx) {
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
                } else {
                    //Tidak ada alias
                    this.Res.querypart.table[tmp[0]] = [];
                    this.Res.querypart.table[tmp[0]].push(tmp[1]);
                    this.Res.table.push(tmp[1]);
                }
            } else {
                //Table Without Alias
                if (!this.Res.querypart.table_selected) {
                    this.Res.querypart.table_selected = tmp[0]
                }
                this.Res.querypart.table_alias["-"] = tmp[0];
                if (this.Res.querypart.table.hasOwnProperty(tmp[0])) {
                    this.Res.querypart.table[tmp[0]].push("-");
                    this.Res.table.push(tmp[0]);
                } else {
                    this.Res.querypart.table[tmp[0]] = [];
                    this.Res.querypart.table[tmp[0]].push("-");
                    this.Res.table.push(tmp[0]);
                }
            }
        }
    }

    protected addColumnValueWithIndex(val: any) {
        this.addColumnValue(val, this.field[this.index_column_value++])
        if (this.index_column_value >= this.field.length) {
            this.index_column_value = 0;
        }
    }

    protected addColumnValue(val, column) {
        val = val.replace(/`/g, "");
        if (!this.Res.querypart.column_value.hasOwnProperty(column)) {
            this.Res.querypart.column_value[column] = [];
        }
        this.Res.querypart.column_value[column].push(val);
    }

    protected addWhereExpression(val: string) {
        let exp = new RegExp("=");
        this.Res.querypart.where = val.replace(exp," = ");
    }

    //DML : Data Manipulation Language

    // Select Statement
    public enterQuerySpecification(ctx: QuerySpecificationContext) {
        if (this.Res.querytype == "DEFAULT") {
            this.Res.querytype = "SELECT";
        }
        if (this.Res.querypart) {
            // this.Res.resultquery = await this.Res.querypart.process();
        }
        this.Res.querypart = new Select(this.Res.resultquery, this.Res.ext_table, this.Res.ext_table_relation, this.Res.ext_table_field);
        // this.Res.queryspec = ctx.text;
    }

    // Update Statement
    public enterUpdate(ctx: UpdateContext) {
        if (this.Res.querytype == "DEFAULT") {
            this.Res.querytype = "UPDATE";
        }
        if (this.Res.querypart) {
            // this.Res.resultquery = await this.Res.querypart.process();
        }
        this.Res.querypart = new Update(this.Res.resultquery, this.Res.ext_table, this.Res.ext_table_relation, this.Res.ext_table_field);
    }

    // Delete Statement
    public async enterDelete(ctx: DeleteContext) {
        if (this.Res.querytype == "DEFAULT") {
            this.Res.querytype = "DELETE";
        }
        if (this.Res.querypart) {
            // this.Res.resultquery = await this.Res.querypart.process();
        }
        this.Res.querypart = new Delete(this.Res.resultquery, this.Res.ext_table, this.Res.ext_table_relation, this.Res.ext_table_field);
        this.addFrom(ctx.text);
    }

    // Insert Statmenet
    public async enterInsertInto(ctx: InsertIntoContext) {
        if (this.Res.querytype == "DEFAULT") {
            this.Res.querytype = "INSERT";
        }
        if (this.Res.querypart) {
            // this.Res.resultquery = await this.Res.querypart.process();
        }
        this.Res.querypart = new Insert(this.Res.resultquery, this.Res.ext_table, this.Res.ext_table_relation, this.Res.ext_table_field);
    }

    // Select Attribute
    ///////////////////////////////////////////////////////-///////////////////////////////////////////////////////-///////////////////////////////////////////////////////

    public enterSelectAll(ctx) {
        this.Res.querypart.is_select_all = true;
    }

    public enterSelect(ctx) {
        this.addTableField(ctx.text);
    }

    // Update Attribute
    ///////////////////////////////////////////////////////-///////////////////////////////////////////////////////-///////////////////////////////////////////////////////

    public enterUpdateExpression(ctx: UpdateExpressionContext) {
        this.addTableField(ctx.text);
    }

    public enterTableName(ctx: TableNameContext) {
        this.addTable(ctx)
    }

    public enterJoinCriteria(ctx: JoinCriteriaContext) {
        let tmp = this.getFirstGroup(this.joinexp, ctx.text)
        tmp.forEach(el => {
            this.addTableField(el)
        });
    }

    public enterWhereExpression(ctx: WhereExpressionContext) {
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

    public enterGroupBy(ctx: GroupByContext) {
        this.addTableField(ctx.text);
        this.addGroupField(ctx.text);
    }

    public enterSortItem(ctx: SortItemContext) {
        this.addTableField(ctx.text);
        this.addSortField(ctx.text);
    }

    public enterTableNameWithAliases(ctx: TableNameWithAliasesContext) {
        this.addTable(ctx);
    }

    public enterColumnAliases(ctx: ColumnAliasesContext) {
        this.addTableField(ctx.text.substring(1, ctx.text.length - 1));
        let table_selected = this.Res.querypart.table_selected;
        let table_alias = this.Res.querypart.table[table_selected];
        table_alias = (table_alias) ? table_alias[0] : '-';
        this.field = this.Res.querypart.table_field[table_alias];
    }

    public enterStringLiteral(ctx: StringLiteralContext) {
        if (this.Res.querypart.type == "INSERT") {
            this.addColumnValueWithIndex(ctx.text.replace(/`/g, "'"));
        }
    }

    public enterNumericLiteral(ctx: NumericLiteralContext) {
        if (this.Res.querypart.type == "INSERT") {
            this.addColumnValueWithIndex(ctx.text.replace(/`/g, "'"));
        }
    }

}