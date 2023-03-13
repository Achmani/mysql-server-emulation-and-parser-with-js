import Query, { ExtTable, ExtTableField, ExtTableRelation } from "./query"

export default class Delete extends Query {

    public constructor(query: string, ext_table: ExtTable, ext_table_relation: ExtTableRelation, ext_table_field: ExtTableField) {
        super(query, ext_table, ext_table_relation, ext_table_field, "DELETE");
    }

    protected async deleteArr() {
        try {
            let table_selected = this.table_selected;
            let table_ext = Object.keys(this.ext_table_relation[table_selected]);
            let primary_key = await this.getPrimaryKey(this.table_selected);
            table_ext.unshift(table_selected);

            let list_id = await this.getPrimaryKeyFromWhere();
            table_ext.forEach(table => {
                list_id.forEach(el => {
                    this.arrayquery.push("DELETE FROM `" + table + "` WHERE `" + primary_key + "` = " + el + ";");
                });
            });
            this.resultquery = "START TRANSACTION;\n" + this.arrayquery.join("\n") + "\nCOMMIT;";
        } catch (error) {

        }
    }

    protected async deleteStr() {
        let resultquery = "";
        let table_selected = this.table_selected;
        let table_ext = Object.keys(this.ext_table_relation[table_selected]);
        let primary_key = await this.getPrimaryKey(this.table_selected);
        table_ext.unshift(table_selected);

        // Generate Delete
        resultquery += "START TRANSACTION;\n"
        table_ext.forEach(table => {
            resultquery += "DELETE FROM `" + table + "` WHERE `" + primary_key + "` IN (" + this.where + ");\n";
        });
        resultquery += "COMMIT;\n"
        this.resultquery = resultquery;
    }

    public async process() {
        this.getColumn();
        await this.generateWhere();
        // await this.deleteStr();
        await this.deleteArr();
        return this.resultquery;
    }

}