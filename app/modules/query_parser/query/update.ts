import _ from "lodash";
import Query, { ExtTable, ExtTableField, ExtTableRelation } from "./query";

export default class Update extends Query {
    public constructor(query: string, ext_table: ExtTable, ext_table_relation: ExtTableRelation, ext_table_field: ExtTableField) {
        super(query, ext_table, ext_table_relation, ext_table_field, "UPDATE");
    }

    protected async updateArr() {
        try {
            let tmp_table = this.table_selected;
            // Generate Fields, Filtered, Primary Key
            let fields: (string)[] = [];
            let filtered_field = Object.keys(this.table_filtered_field[tmp_table]);
            let primary_key = await this.getPrimaryKey(this.table_selected);
            for (const [key, field] of Object.entries(this.table_field[tmp_table])) {
                if (!filtered_field.includes(field)) {
                    fields.push(field);
                    console.log("🚀 ~ Update ~ updateArr ~ fields", fields);
                }
            }
            let group_filtered_field = this.groupObj(this.table_filtered_field[tmp_table]);
            let list_id = await this.getPrimaryKeyFromWhere();
            console.log("🚀 ~ Update ~ updateArr ~ list_id", list_id);

            list_id.forEach(pk_id => {
                console.log("🚀 ~ Update ~ updateArr ~ this.column_value", this.column_value);
                // Generate Update
                for (let i = 0; i < this.column_value[fields[0]].length; i++) {
                    let tmp_query = "";
                    let values_query: (string)[] = [];
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
                        let values_query: (string)[] = [];
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
        } catch (error) {
            console.log("🚀 ~ Update ~ updateArr ~ error", error);
        }

    }

    protected async updateStr() {
        let result_query = "";
        let tmp_table = this.table_selected;

        // Generate Fields, Filtered, Primary Key
        let fields: (string)[] = [];
        let filtered_field = Object.keys(this.table_filtered_field[tmp_table]);
        let primary_key = await this.getPrimaryKey(this.table_selected);
        for (const [key, field] of Object.entries(this.table_field[tmp_table])) {
            if (!filtered_field.includes(field)) {
                fields.push(field);
            }
        }

        let group_filtered_field = this.groupObj(this.table_filtered_field[tmp_table]);

        // Generate Update
        result_query += "START TRANSACTION;\n"
        for (let i = 0; i < this.column_value[fields[0]].length; i++) {

            let values_query: (string)[] = [];
            result_query += `UPDATE \`${this.table_selected}\` SET `;
            fields.forEach(field => {
                let value = this.column_value[field][i];
                values_query.push("`" + field + "` = " + value);
            });
            result_query += values_query.join() + " WHERE `" + primary_key + "` IN (" + this.where + ");\n";
            for (let [ext_table, ext_fields] of Object.entries(group_filtered_field)) {
                let values_query: (string)[] = [];
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
    }

    public async process() {
        this.getColumn();
        await this.generateWhere();
        await this.updateArr();
        // await this.updateStr();
        this.log();
        return this.resultquery;
    }
}