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
const lodash_1 = __importDefault(require("lodash"));
const knex_1 = __importDefault(require("knex"));
const global_1 = __importDefault(require("../../../config/global"));
class Adapter {
    constructor() {
        let config = {
            "client": "mysql",
            "connection": {
                "host": global_1.default.HOST_DB,
                "port": global_1.default.PORT_DB,
                "user": global_1.default.USER_DB,
                "password": global_1.default.PASS_DB,
                "database": global_1.default.DB_INFO_SCHEMA
            }
        };
        this.datasource = 2;
        this.ext_table = {};
        this.ext_table_relation = {};
        this.ext_table_field = {};
        this.DB = knex_1.default(config);
    }
    generateMetadata() {
        return __awaiter(this, void 0, void 0, function* () {
            const DB = this.DB;
            let ext_table = this.ext_table;
            let ext_table_relation = this.ext_table_relation;
            let datasource = this.datasource;
            let metadata_relation = yield DB.raw(`

        SELECT
            FLOOR(RAND() *(25 -10 + 1)) + 10 AS 'mr_id',
            sm.metadata_id AS 'mr_sm_id',
            sm.metadata_model AS 'mr_sm_name',
            mf_sm.metadatafield_id AS 'mr_sf_id',
            mf_sm.metadatafield_field AS 'mr_sf_name',
            tm.metadata_id AS 'mr_tm_id',
            tm.metadata_model AS 'mr_tm_name',
            mf_tm.metadatafield_id AS 'mr_tf_id',
            mf_tm.metadatafield_field AS 'mr_tf_name',
            NULL AS 'logical_join'
        FROM
            metadata tm
            #INNER JOIN metadata sm ON sm.metadata_model = REGEXP_SUBSTR(tm.metadata_model, '[A-Za-z]+', 1)
            INNER JOIN metadata sm ON sm.metadata_model = REGEXP_REPLACE(tm.metadata_model, '_ext[0-9]+', "") AND sm.metadata_model != tm.metadata_model 
            INNER JOIN metadata_field mf_sm ON mf_sm.metadatafield_metadata = sm.metadata_id
            INNER JOIN metadata_field mf_tm ON mf_tm.metadatafield_metadata = tm.metadata_id
        WHERE
            tm.metadata_model REGEXP '[A-Za-z]+_ext[0-9]+'
            AND mf_sm.metadatafield_key = "PK"
            AND mf_tm.metadatafield_key = "PK"
            AND mf_sm.metadatafield_deleted = 0
            AND mf_tm.metadatafield_deleted = 0
            AND mf_sm.metadatafield_field = mf_tm.metadatafield_field

        `);
            metadata_relation = metadata_relation[0];
            let metadata_field = yield DB.raw("select `metadata_id` as `id`, `metadata_model` as `table`, `metadata_field`.`metadatafield_id` as `id_field`, `metadata_field`.`metadatafield_field` as `field`" +
                "from `metadata` inner join `metadata_field` on `metadata_field`.`metadatafield_metadata` = `metadata`.`metadata_id`" +
                "where `metadata`.`metadata_datasource` = " + datasource + " AND `metadata_field`.`metadatafield_deleted` = 0 ORDER BY `metadata_model` ASC, `metadatafield_order` ASC");
            metadata_field = metadata_field[0];
            let metadata_field_arr = lodash_1.default.chain(metadata_field)
                .groupBy('table')
                .mapValues(n => lodash_1.default.map(n, "field"))
                .value();
            let metadata_relation_source = lodash_1.default.chain(metadata_relation)
                .groupBy('mr_sm_name')
                .mapValues(n => lodash_1.default.map(n, "mr_tm_name"))
                .value();
            // Create Ext Table
            Object.entries(metadata_relation_source).forEach((entry) => {
                const [tmp_table_main, tmp_table_relation] = entry;
                let result_fields = {};
                tmp_table_relation.forEach(el_table => {
                    let fields = metadata_field_arr[el_table];
                    if (fields) {
                        fields.forEach(el_field => {
                            result_fields[el_field] = el_table;
                        });
                    }
                });
                ext_table[tmp_table_main] = result_fields;
            });
            //Create Ext Table Relations
            Object.entries(metadata_relation).forEach((entry) => {
                let key;
                let value;
                [key, value] = entry;
                let mr_sm_name = value['mr_sm_name'];
                let mr_tm_name = value['mr_tm_name'];
                let mr_tf_name = value['mr_tf_name'];
                let mr_sf_name = value['mr_sf_name'];
                let logicaljoin = value['logicaljoin'];
                if (!ext_table_relation.hasOwnProperty(mr_sm_name)) {
                    ext_table_relation[mr_sm_name] = {};
                }
                if (!ext_table_relation[mr_sm_name].hasOwnProperty(mr_tm_name)) {
                    ext_table_relation[mr_sm_name][mr_tm_name] = [];
                }
                ext_table_relation[mr_sm_name][mr_tm_name].push(mr_sf_name);
                ext_table_relation[mr_sm_name][mr_tm_name].push(mr_tf_name);
                ext_table_relation[mr_sm_name][mr_tm_name].push(logicaljoin);
            });
            this.ext_table = ext_table;
            this.ext_table_relation = ext_table_relation;
            this.ext_table_field = metadata_field_arr;
        });
    }
}
exports.default = Adapter;
