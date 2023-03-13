import mysql from "mysql";

export interface results {
    fields: any,
    rows: any
}

export const queryAsync = async (query: string, config: Object): Promise<results> => {
    return new Promise((resolve, reject) => {
        const datasource = mysql.createConnection(config);
        datasource.query(query, (err, row, field) => {
            return err ? reject(err) : resolve({ fields: field, rows: row });
        }
        );
        datasource.end(function (err) {
            if (err) {
                console.log("🚀 ~ err", err);
                reject(err);
            }
        });
    });
}
