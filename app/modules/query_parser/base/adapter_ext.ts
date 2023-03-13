import _ from 'lodash';
import knex, { Knex } from 'knex';
import sanitizedConfig from '../../../config/global';

export default class AdapterExt {

    DB: Knex;
    datasource: number;
    ext_table: Object;
    ext_table_field: Object;
    ext_table_relation: Object;

    constructor() {
        let config = {
            "client": "mysql",
            "connection": {
                "host": sanitizedConfig.HOST_DB,
                "port": sanitizedConfig.PORT_DB,
                "user": sanitizedConfig.USER_DB,
                "password": sanitizedConfig.PASS_DB,
                "database": sanitizedConfig.DB
            }
        };
        this.datasource = 2
        this.ext_table = {}
        this.ext_table_relation = {}
        this.ext_table_field = {}
        this.DB = knex(config);
    }

    async generateMetadata() {

        const DB = this.DB
        let ext_table = this.ext_table;
        let ext_table_relation = this.ext_table_relation;
        let datasource = this.datasource

        let metadata_relation = await DB.raw(`SELECT mr.metadatarelation_id mr_id, 
    
        mr.metadatarelation_sourcemetadata AS mr_sm_id,
        mf_mr_sm.metadata_model AS mr_sm_name, 
            
        mr.metadatarelation_sourcefield AS mr_sf_id ,
        mf_mr_sf.metadatafield_field AS mr_sf_name,
        
        mr.metadatarelation_targetmetadata AS mr_tm_id, 
        mf_mr_tm.metadata_model AS mr_tm_name, 
        
        mr.metadatarelation_targetfield AS mr_tf_id,
        mf_mr_tf.metadatafield_field AS mr_tf_name,

        mr.metadatarelation_logicaljoin as logicaljoin
        
        FROM metadata_relation AS mr
        
        INNER JOIN metadata AS mf_mr_tm ON mf_mr_tm.metadata_id = mr.metadatarelation_targetmetadata
        INNER JOIN metadata_field AS mf_mr_tf ON mf_mr_tf.metadatafield_id = mr.metadatarelation_targetfield
        INNER JOIN metadata AS mf_mr_sm ON mf_mr_sm.metadata_id = mr.metadatarelation_sourcemetadata
        INNER JOIN metadata_field AS mf_mr_sf ON mf_mr_sf.metadatafield_id = mr.metadatarelation_sourcefield
        
        WHERE mf_mr_tm.metadata_datasource = ${datasource} AND
        mf_mr_sm.metadata_datasource = ${datasource}

        GROUP BY mr.metadatarelation_id	`)
        metadata_relation = metadata_relation[0]

        let metadata_field = await DB.raw("select `metadata_id` as `id`, `metadata_model` as `table`, `metadata_field`.`metadatafield_id` as `id_field`, `metadata_field`.`metadatafield_field` as `field`" +
            "from `metadata` inner join `metadata_field` on `metadata_field`.`metadatafield_metadata` = `metadata`.`metadata_id`" +
            "where `metadata`.`metadata_datasource` = " + datasource
        );
        metadata_field = metadata_field[0];

        let metadata_field_arr = _.chain(metadata_field)
            .groupBy('table')
            .mapValues(n => _.map(n, "field"))
            .value();

        let metadata_relation_source = _.chain(metadata_relation)
            .groupBy('mr_sm_name')
            .mapValues(n => _.map(n, "mr_tm_name"))
            .value();

        // Create Ext Table
        Object.entries(metadata_relation_source).forEach((entry) => {
            const [tmp_table_main, tmp_table_relation] = entry;
            let result_fields = {}
            tmp_table_relation.forEach(el_table => {
                let fields = metadata_field_arr[el_table];
                if (fields) {
                    fields.forEach(el_field => {
                        result_fields[el_field] = el_table
                    });
                }
            });
            ext_table[tmp_table_main] = result_fields
        });

        //Create Ext Table Relations
        Object.entries(metadata_relation).forEach((entry) => {
            let key: string;
            let value: any;
            [key, value] = entry;

            let mr_sm_name = value['mr_sm_name']
            let mr_tm_name = value['mr_tm_name']
            let mr_tf_name = value['mr_tf_name']
            let mr_sf_name = value['mr_sf_name']
            let logicaljoin = value['logicaljoin']

            if (!ext_table_relation.hasOwnProperty(mr_sm_name)) {
                ext_table_relation[mr_sm_name] = {}
            }
            if (!ext_table_relation[mr_sm_name].hasOwnProperty(mr_tm_name)) {
                ext_table_relation[mr_sm_name][mr_tm_name] = []
            }
            ext_table_relation[mr_sm_name][mr_tm_name].push(mr_sf_name)
            ext_table_relation[mr_sm_name][mr_tm_name].push(mr_tf_name)
            ext_table_relation[mr_sm_name][mr_tm_name].push(logicaljoin)
        })

        this.ext_table = ext_table
        this.ext_table_relation = ext_table_relation
        this.ext_table_field = metadata_field_arr

    }

}