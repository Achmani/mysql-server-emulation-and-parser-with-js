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
const antlr4ts_1 = require("antlr4ts");
const adapter_1 = __importDefault(require("./base/adapter"));
const preprocessing_1 = __importDefault(require("./base/preprocessing"));
const default_1 = __importDefault(require("./query/default"));
const listener_1 = __importDefault(require("./base/listener"));
const SqlBaseLexer_1 = require("../antlr4/SqlBaseLexer");
const SqlBaseParser_1 = require("../antlr4/SqlBaseParser");
const ParseTreeWalker_1 = require("antlr4ts/tree/ParseTreeWalker");
const util_1 = require("../mysql/helpers/util");
class QueryParser {
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
        };
        //Example Ext Field
        this.ext_table_field = {
            "hwbts_ext1": [
                "EXTPROP1",
                "EXTPROP2"
            ]
        };
        this.querypart = new default_1.default("", this.ext_table, this.ext_table_relation, this.ext_table_field, "DEFAULT");
    }
    _init() {
        return __awaiter(this, void 0, void 0, function* () {
            const adapter = new adapter_1.default();
            yield adapter.generateMetadata();
            this.ext_table = adapter.ext_table;
            this.ext_table_relation = adapter.ext_table_relation;
            this.ext_table_field = adapter.ext_table_field;
        });
    }
    process(query) {
        return __awaiter(this, void 0, void 0, function* () {
            yield this._init();
            this.querypart = new default_1.default(query, this.ext_table, this.ext_table_relation, this.ext_table_field, "DEFAULT");
            let preprocessor = new preprocessing_1.default();
            this.query = preprocessor.process(query);
            this.resultquery = this.query;
            // Create the lexer and parser
            let inputStream = new antlr4ts_1.ANTLRInputStream(this.resultquery);
            let lexer = new SqlBaseLexer_1.SqlBaseLexer(inputStream);
            let tokenStream = new antlr4ts_1.CommonTokenStream(lexer);
            let parser = new SqlBaseParser_1.SqlBaseParser(tokenStream);
            let tree = parser.statement();
            var listener = new listener_1.default(this);
            ParseTreeWalker_1.ParseTreeWalker.DEFAULT.walk(listener, tree);
            this.resultquery = yield this.querypart.process();
            console.log("🚀 ~ QueryParser ~ process ~ this.resultquery", this.resultquery);
            this.table = this.table.filter(util_1.onlyUnique);
            return this.resultquery;
        });
    }
}
exports.default = QueryParser;
