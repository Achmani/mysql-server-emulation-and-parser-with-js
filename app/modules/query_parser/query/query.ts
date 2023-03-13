import mysql, { Connection } from "mysql";
import QueryParser from "../query_parser";
import { queryAsync, results } from "../../../../helpers/mysql";
import sanitizedConfig, { configDB } from "../../../config/global";

export interface TableValue {
    [key: string]: Array<string>
}

export interface TableField {
    [key: string]: Array<string>
}

export interface ExtTable {
    [key: string]: {
        [key: string]: string
    }
}

export interface ExtTableRelation {
    [key: string]: {
        [key: string]: Array<string>
    }
}

export interface ExtTableField {
    [key: string]: Array<string>
}

export type QueryType = "INSERT" | "UPDATE" | "SELECT" | "DELETE" | "DEFAULT";

export default abstract class Query {

    public config: Object;
    public mysql_conn: Connection;

    public type: QueryType;
    public query: string;
    public queryspec: string;
    public resultquery: string;
    public arrayquery: Array<string>;

    public where: string;
    public where_table: Array<string>;
    public where_field: Array<string>;
    public where_value: Array<string>;
    public where_is_query: boolean;

    public orderby: Array<string>;
    public orderby_table: Array<string>;
    public orderby_field: Array<string>;

    public groupby: Array<string>;
    public groupby_table: Array<string>;
    public groupby_field: Array<string>;

    public is_select_all: boolean;

    public table: Array<Array<string>>;
    public table_alias: Array<string>;
    public table_field: TableField;
    public table_selected: string;
    public table_filtered_field: Object;
    public column_value: TableValue;

    public ext_table: ExtTable;
    public ext_table_relation: ExtTableRelation;
    public ext_table_field: ExtTableField;
    public operator: Object;

    public constructor(query: string, ext_table: ExtTable, ext_table_relation: ExtTableRelation, ext_table_field: ExtTableField, type: QueryType) {
        this.config = {
            "host": sanitizedConfig.HOST_DB,
            "port": sanitizedConfig.PORT_DB,
            "user": sanitizedConfig.USER_DB,
            "password": sanitizedConfig.PASS_DB,
            "database": sanitizedConfig.DB_INFO_SCHEMA
        };
        this.mysql_conn = mysql.createConnection(this.config);

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
        }
    }

    abstract process(): Promise<string>;

    protected async getPrimaryKey(model: string) {
        const query = `SELECT mf.metadatafield_field AS metadatafield_field FROM metadata m LEFT JOIN metadata_field mf ON m.metadata_id = mf.metadatafield_metadata WHERE m.metadata_model = "${model}" AND mf.metadatafield_key = "PK" ORDER BY mf.metadatafield_order ASC`;
        const results: any = await queryAsync(query, this.config);
        const arr = this.toArray(results.rows, "metadatafield_field");
        return arr;
    }

    protected getColumn() {
        try {
            Object.keys(this.table_field).forEach(key => {
                let tmp_table = this.table_alias[key]
                tmp_table = (tmp_table ? tmp_table : key)
                if (this.ext_table[tmp_table]) {
                    let tmpfield = this.table_field[key]
                    tmpfield.forEach(el_field => {
                        let is_exist_self = this.ext_table_field[tmp_table].includes(el_field)
                        if (!is_exist_self) {
                            let is_exist_in_relationship = this.ext_table[tmp_table][el_field]
                            if (is_exist_in_relationship) {
                                let tmp_field = el_field
                                let tmp_table = is_exist_in_relationship
                                if (!this.table_filtered_field.hasOwnProperty(key)) {
                                    this.table_filtered_field[key] = {}
                                }
                                this.table_filtered_field[key][tmp_field] = tmp_table
                            } else {
                            }
                        }
                    });
                }
            });
        } catch (error: any) {
            console.log("🚀 ~ Query ~ getColumn ~ error", error);
        }
    }

    protected toArray(obj: Object, field: string) {
        let results: (string)[];
        results = [];
        for (const [key, value] of Object.entries(obj)) {
            results.push(value[field]);
        }
        return results;
    }

    protected groupObj(obj: Object): Object {
        let results = {}
        for (const [key, value] of Object.entries(obj)) {
            if (!results.hasOwnProperty(value)) {
                results[value] = []
            }
            results[value].push(key)
        };
        return results
    }

    protected async generateWhere() {
        let table = this.table_selected;
        let primary_key = await this.getPrimaryKey(table);
        try {
            if (primary_key.length > 0) {
                let pk = primary_key[0];
                let select_query = "SELECT `" + table + "`.`" + pk + "` AS `" + pk + "` FROM `" + this.table_selected + "` WHERE " + this.where;
                let selectParser = new QueryParser();
                select_query = await selectParser.process(select_query);
                console.log("🚀 ~ Query ~ generateWhere ~ select_query", select_query);
                this.where = select_query;
                console.log("🚀 ~ Query ~ generateWhere ~ this.where", this.where);
            }
        } catch (error) {
            console.log("🚀 ~ Query ~ generateWhere ~ error", error);
        }
    }

    protected async getPrimaryKeyFromWhere(): Promise<Array<any>> {
        let table_selected = this.table_selected;
        let table_ext = Object.keys(this.ext_table_relation[table_selected]);
        let primary_key = await this.getPrimaryKey(this.table_selected);
        table_ext.unshift(table_selected);
        let selectQuery = this.where;
        let results: results = await queryAsync(selectQuery, configDB);

        let list_id: Array<any> = [];
        Object.entries(results.rows).forEach((entry: any) => {
            list_id.push(entry[1].id);
        });
        return list_id
    }

    public log() {
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ column_value", this.column_value)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ table_filtered_field", this.table_filtered_field)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ table_selected", this.table_selected)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ table_field", this.table_field)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ table_alias", this.table_alias)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ table", this.table)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ is_select_all", this.is_select_all)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ groupby_field", this.groupby_field)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ groupby_table", this.groupby_table)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ groupby", this.groupby)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ orderby_field", this.orderby_field)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ orderby_table", this.orderby_table)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ orderby", this.orderby)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ where_is_query", this.where_is_query)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ where_value", this.where_value)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ where_field", this.where_field)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ where_table", this.where_table)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ where", this.where)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ resultquery", this.resultquery)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ queryspec", this.queryspec)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ query", this.query)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ type", this.type)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ config", this.config)
        console.log("🚀 ~ file: query.ts ~ line 184 ~ Query ~ constructor ~ arrayquery", this.arrayquery)
    }

}
