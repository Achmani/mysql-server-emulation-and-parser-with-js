import _ from "lodash";
import { onlyUnique } from "../../mysql/helpers/util";
import Query, { ExtTable, ExtTableField, ExtTableRelation } from "./query";

export default class Select extends Query {

    public constructor(query: string, ext_table: ExtTable, ext_table_relation: ExtTableRelation, ext_table_field: ExtTableField) {
        super(query, ext_table, ext_table_relation, ext_table_field, "SELECT");
    }

    protected isSelectAll() {
        if (this.is_select_all) {
            let tables = Object.keys(this.table);
            let res_field: (string)[] = [];
            tables.forEach(table => {
                let table_field = this.ext_table_field[table];

                let is_ext = this.ext_table_relation[table];
                if (is_ext) {
                    let table_ext = Object.keys(is_ext);
                    let ext_field: Array<string> = [];
                    let key = table;
                    this.table_filtered_field[key] = {}
                    table_ext.forEach(table => {
                        let intersection = _.intersection(this.ext_table_field[table], table_field);
                        let list_field: (string)[] = this.ext_table_field[table];
                        if (list_field) {
                            list_field.forEach(field => {
                                if (!_.includes(intersection, field)) {
                                    ext_field.push(field);
                                    this.table_filtered_field[key][field] = table;
                                }
                            });
                        }
                    });
                    table_field = table_field.concat(ext_field).filter(onlyUnique);
                }
                let table_field_query: (string)[] = [];
                table_field.forEach(function callback(value, index) {
                    table_field_query[index] = '`' + table + '`.`' + value + '`';
                });
                res_field.push(table_field_query.join(", "));
            });
            let selectallexp = new RegExp("SELECT \\*", 'gmi');
            this.resultquery = this.resultquery.replace(selectallexp, "SELECT " + res_field.join(", "));
        }
    }

    protected replaceColumnDefinition(list: Array<any>, table_name: string, table_alias: string, table_name_column: string) {
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
            } else {
                columnreplaceexp = new RegExp("(`" + field + "`)", 'gmi');
                // console.log("🚀 ~ Select ~ replaceColumnDefinition ~ columnreplaceexp", columnreplaceexp);
            }
            this.resultquery = this.resultquery.replace(columnreplaceexp, "`" + table_name_column + "`.`" + field + "`");
        });
    }

    protected addJoin() {
        let result_query = "";

        try {

            this.isSelectAll();

            for (const [key, value] of Object.entries(this.table_filtered_field)) {
                let temp = this.table_alias[key]
                let tmp_table = (temp ? temp : key)
                let tmp_alias = (tmp_table ? key : tmp_table)
                let tmp_alias_abs = (tmp_alias != "-" ? tmp_alias : tmp_table)
                let relation = this.ext_table_relation[tmp_table];
                if (relation) {
                    let tmp_relation = this.table_filtered_field[tmp_alias]
                    let tmp_group_relation = this.groupObj(tmp_relation)
                    let tmp_uniq_relation = _.uniq(_.map(tmp_relation));
                    for (const [key2, value2] of Object.entries(tmp_uniq_relation)) {
                        let tmp_relation_table: any = value2;
                        let tmp_relation_pk = this.ext_table_relation[tmp_table][tmp_relation_table][1]
                        let tmp_relation_fk = this.ext_table_relation[tmp_table][tmp_relation_table][0]
                        let tmp_ext_table_alias = tmp_relation_table + "_" + tmp_table
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
        catch (error: any) {
            console.log("🚀 ~ Select ~ addJoin ~ error", error);
        }
    }

    public async process() {
        this.getColumn();
        this.log();
        this.addJoin();
        return this.resultquery;
    }

}