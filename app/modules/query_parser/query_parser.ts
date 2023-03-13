import _ from 'lodash';
import { ANTLRInputStream, CommonTokenStream } from 'antlr4ts';

import Adapter from './base/adapter';
import Preprocessing from './base/preprocessing';

import Default from './query/default';
import Listener from './base/listener';
import { SqlBaseLexer } from "../antlr4/SqlBaseLexer";
import { SqlBaseParser } from "../antlr4/SqlBaseParser";
import { SqlBaseListener } from "../antlr4/SqlBaseListener";
import { ParseTreeWalker } from 'antlr4ts/tree/ParseTreeWalker'
import Query, { ExtTable, ExtTableField, ExtTableRelation, QueryType } from './query/query';
import { onlyUnique } from '../mysql/helpers/util';

export default class QueryParser {

    public querypart: Query;
    public querytype: QueryType;
    public table: Array<string>;
    public query: string;
    public resultquery: string;
    public ext_table: ExtTable;
    public ext_table_field: ExtTableField;
    public ext_table_relation: ExtTableRelation;

    constructor() {
        this.table = [];
        this.query = "";
        this.resultquery = "";
        this.querytype = "DEFAULT";

        //Example Ext Table
        this.ext_table = {
            "hwbts": {
                "EXTPROP1": "hwbts_ext1",
                "EXTPROP2": "hwbts_ext2"
            }
        };
        //Example Ext Relation
        this.ext_table_relation = {
            "hwbts_ext1": {
                "hwbts": [
                    "_id",
                    "_date"
                ]
            }
        }
        //Example Ext Field
        this.ext_table_field = {
            "hwbts_ext1": [
                "EXTPROP1",
                "EXTPROP2"
            ]
        };

        this.querypart = new Default("", this.ext_table, this.ext_table_relation, this.ext_table_field, "DEFAULT");

    }

    async _init() {
        const adapter = new Adapter(); await adapter.generateMetadata();
        this.ext_table = adapter.ext_table
        this.ext_table_relation = adapter.ext_table_relation
        this.ext_table_field = adapter.ext_table_field
    }

    async process(query: string) {

        await this._init();

        this.querypart = new Default(query, this.ext_table, this.ext_table_relation, this.ext_table_field, "DEFAULT");

        let preprocessor = new Preprocessing();
        this.query = preprocessor.process(query)
        this.resultquery = this.query
        // Create the lexer and parser
        let inputStream = new ANTLRInputStream(this.resultquery);
        let lexer = new SqlBaseLexer(inputStream);
        let tokenStream = new CommonTokenStream(lexer);
        let parser = new SqlBaseParser(tokenStream);
        let tree = parser.statement();
        var listener: SqlBaseListener = new Listener(this);
        ParseTreeWalker.DEFAULT.walk(listener, tree);
        this.resultquery = await this.querypart.process();
        console.log("🚀 ~ QueryParser ~ process ~ this.resultquery", this.resultquery);
        this.table = this.table.filter(onlyUnique);
        return this.resultquery;

    }

}