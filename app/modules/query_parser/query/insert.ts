import Query, { ExtTable, ExtTableField, ExtTableRelation } from "./query";

export default class Insert extends Query {
    constructor(query: string, ext_table: ExtTable, ext_table_relation: ExtTableRelation, ext_table_field: ExtTableField) {
        super(query, ext_table, ext_table_relation, ext_table_field, "INSERT");
    }

    protected async insert() {
        try {
            let resultquery = "";

            for (let [alias_table, table] of Object.entries(this.table)) {
                let tmp_table = table[0];

                // Generate Fields, Filtered, Primary Key
                let fields: (string)[];
                fields = [];
                let filtered_field = Object.keys(this.table_filtered_field[tmp_table]);
                let primary_key = await this.getPrimaryKey(this.table_selected);
                for (const [key, field] of Object.entries(this.table_field[tmp_table])) {
                    if (!filtered_field.includes(field)) {
                        fields.push(field);
                    }
                }

                let group_filtered_field = this.groupObj(this.table_filtered_field[tmp_table]);

                // Generate Insert
                resultquery += "START TRANSACTION;\n"
                for (let i = 0; i < this.column_value[fields[0]].length; i++) {
                    let values_query: (string)[] = [];
                    let values_tmp: (string)[] = [];
                    resultquery += `INSERT INTO ${this.table_selected} (${"`" + fields.join("`,`") + "`"}) VALUES `;
                    fields.forEach(field => {
                        values_tmp.push(this.column_value[field][i]);
                    });
                    values_query.push(`(${values_tmp.join()})`);
                    resultquery += values_query.join() + ";\n" + "SET @last_id_in_table1 = LAST_INSERT_ID();\n";

                    for (let [ext_table, ext_fields] of Object.entries(group_filtered_field)) {
                        ext_fields = ext_fields.concat(primary_key);
                        let tmp_query = `INSERT INTO ${ext_table} (${"`" + ext_fields.join("`,`") + "`"}) VALUES `;
                        let ext_values_query: (string)[] = [];
                        let ext_values_tmp: (string)[] = [];
                        ext_fields.forEach(field => {
                            if (this.column_value.hasOwnProperty(field)) {
                                ext_values_tmp.push(this.column_value[field][i]);
                            } else {
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
        } catch (error) {

        }
    }

    async process(): Promise<string> {
        this.getColumn();
        await this.insert();
        this.log();
        return this.resultquery;
    }
}