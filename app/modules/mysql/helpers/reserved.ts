import Packets from "../interface/packets";
import UBuffer from "./ubuffer";

export interface resultReserved {
    data: string,
    action: string,
    status: boolean,
    is_eof: boolean
}

interface command {
    pattern: string,
    call: string,
    method: "regex" | "equal",
    value: string,
    is_eof: boolean
}

export default class Reserved {

    protected fixedCommand: Array<command>;

    public constructor() {

        this.fixedCommand = [
            {
                "pattern": "^SET .+",
                "call": "setGlobalVariable",
                "method": "regex",
                "value": "",
                "is_eof": false
            },
            {
                "pattern": "(?<=USE )([A-Za-z0-9_`]+)",
                "call": "useDB (db)",
                "method": "regex",
                "value": "",
                "is_eof": false
            },
            {
                "pattern": "SELECT  @@session.auto_increment_increment AS auto_increment_increment, @@character_set_client AS character_set_client, @@character_set_connection AS character_set_connection, @@character_set_results AS character_set_results, @@character_set_server AS character_set_server, @@collation_server AS collation_server, @@init_connect AS init_connect, @@interactive_timeout AS interactive_timeout, @@license AS license, @@lower_case_table_names AS lower_case_table_names, @@max_allowed_packet AS max_allowed_packet, @@net_buffer_length AS net_buffer_length, @@net_write_timeout AS net_write_timeout, @@sql_mode AS sql_mode, @@system_time_zone AS system_time_zone, @@time_zone AS time_zone, @@transaction_isolation AS transaction_isolation, @@wait_timeout AS wait_timeout",
                "call": "query",
                "method": "regex",
                "value": "SELECT  @@session.auto_increment_increment AS auto_increment_increment, @@character_set_client AS character_set_client, @@character_set_connection AS character_set_connection, @@character_set_results AS character_set_results, @@character_set_server AS character_set_server, @@collation_server AS collation_server, @@init_connect AS init_connect, @@interactive_timeout AS interactive_timeout, @@license AS license, @@lower_case_table_names AS lower_case_table_names, @@max_allowed_packet AS max_allowed_packet, @@net_buffer_length AS net_buffer_length, @@net_write_timeout AS net_write_timeout, @@sql_mode AS sql_mode, @@system_time_zone AS system_time_zone, @@time_zone AS time_zone, @@transaction_isolation AS transaction_isolation, @@wait_timeout AS wait_timeout",
                "is_eof": false
            },
            {
                "pattern": "SHOW DATABASES",
                "call": "query",
                "method": "regex",
                "value": "SHOW DATABASES",
                "is_eof": true
            },
            {
                "pattern": "SELECT @@global.max_allowed_packet",
                "call": "query",
                "method": "equal",
                "value": "SELECT @@global.max_allowed_packet",
                "is_eof": true
            },
            {
                "pattern": "SHOW VARIABLES LIKE 'max_allowed_packet'",
                "call": "query",
                "method": "equal",
                "value": "SHOW VARIABLES LIKE 'max_allowed_packet'",
                "is_eof": true
            },
            {
                "pattern": "SHOW VARIABLES",
                "call": "query",
                "method": "equal",
                "value": "SHOW VARIABLES",
                "is_eof": true
            },
            {
                "pattern": "SHOW /*!50002 FULL*/ TABLES",
                "call": "query",
                "method": "equal",
                "value": "SHOW FULL TABLES",
                "is_eof": true
            },
            {
                "pattern": "select 1 as `one` from dual",
                "call": "query",
                "method": "regex",
                "value": "select 1 as `one` from dual",
                "is_eof": false
            },
            {
                "pattern": "SHOW WARNINGS",
                "call": "query",
                "method": "regex",
                "value": "SHOW WARNINGS",
                "is_eof": false
            },
            {
                "pattern": "select `information_schema`.`SCHEMATA`.`SCHEMA_NAME` from `information_schema`.`SCHEMATA`",
                "call": "query",
                "method": "regex",
                "value": "SELECT `datasource_physicalname` as 'SCHEMA_NAME' FROM datasource GROUP BY datasource_physicalname",
                "is_eof": false
            },
            {
                "pattern": "select `information_schema`\\.`TABLES`\\.`TABLE_SCHEMA`, `information_schema`\\.`TABLES`\\.`TABLE_NAME`, `information_schema`\\.`TABLES`\\.`TABLE_COMMENT` from `information_schema`\\.`TABLES` where \\(`information_schema`\\.`TABLES`\\.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\) or `information_schema`\\.`TABLES`\\.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\)\\) order by `information_schema`\\.`TABLES`\\.`TABLE_SCHEMA`, `information_schema`\\.`TABLES`\\.`TABLE_NAME`",
                "call": "query",
                "method": "regex",
                "value": "SELECT d.`datasource_physicalname` AS 'TABLE_SCHEMA', m.`metadata_model` AS 'TABLE_NAME', '' AS 'TABLE_COMMENT' FROM datasource d INNER JOIN metadata m ON d.`datasource_id` = m.`metadata_datasource` WHERE d.datasource_id = 2 AND m.`metadata_model` NOT REGEXP '[A-Za-z]+_ext[0-9]+' AND m.`metadata_deleted` = 0",
                "is_eof": false
            },
            {
                "pattern": "select `information_schema`\\.`COLUMNS`\\.`TABLE_SCHEMA`, `information_schema`\\.`COLUMNS`\\.`COLUMN_COMMENT`, `information_schema`\\.`COLUMNS`\\.`TABLE_NAME`, `information_schema`\\.`COLUMNS`\\.`COLUMN_NAME`, `information_schema`\\.`COLUMNS`\\.`COLUMN_TYPE` from `information_schema`\\.`COLUMNS` where \\(`information_schema`\\.`COLUMNS`\\.`COLUMN_TYPE` like 'enum\\(\\%\\)' and \\(`information_schema`\\.`COLUMNS`\\.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\) or `information_schema`\\.`COLUMNS`\\.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\)\\)\\) order by `information_schema`\\.`COLUMNS`\\.`TABLE_SCHEMA` asc, `information_schema`\\.`COLUMNS`\\.`TABLE_NAME` asc, `information_schema`\\.`COLUMNS`\\.`COLUMN_NAME` asc",
                "call": "query",
                "method": "regex",
                "value": "select `information_schema`.`COLUMNS`.`TABLE_SCHEMA`, `information_schema`.`COLUMNS`.`COLUMN_COMMENT`, `information_schema`.`COLUMNS`.`TABLE_NAME`, `information_schema`.`COLUMNS`.`COLUMN_NAME`, `information_schema`.`COLUMNS`.`COLUMN_TYPE` from `information_schema`.`COLUMNS` where (`information_schema`.`COLUMNS`.`COLUMN_TYPE` like 'enum(%)' and (`information_schema`.`COLUMNS`.`TABLE_SCHEMA` in ('query_regex') or `information_schema`.`COLUMNS`.`TABLE_SCHEMA` in ('query_regex'))) order by `information_schema`.`COLUMNS`.`TABLE_SCHEMA` asc, `information_schema`.`COLUMNS`.`TABLE_NAME` asc, `information_schema`.`COLUMNS`.`COLUMN_NAME` asc",
                "is_eof": false
            },
            {
                "pattern": "SELECT `Information_schema`\\.`STATISTICS`\\.`TABLE_SCHEMA`, `information_schema`\\.`STATISTICS`\\.`TABLE_NAME`, `information_schema`\\.`STATISTICS`\\.`INDEX_NAME`, `information_schema`\\.`STATISTICS`\\.`NON_UNIQUE`, `information_schema`\\.`STATISTICS`\\.`COLUMN_NAME`, `information_schema`\\.`STATISTICS`\\.`SEQ_IN_INDEX` FROM `information_schema`\\.`STATISTICS` WHERE \\(`information_schema`\\.`STATISTICS`\\.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\) or `information_schema`\\.`STATISTICS`\\.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\)\\) ORDER BY `information_schema`\\.`STATISTICS`\\.`TABLE_SCHEMA`, `information_schema`\\.`STATISTICS`\\.`TABLE_NAME`, `information_schema`\\.`STATISTICS`\\.`INDEX_NAME`, `information_schema`\\.`STATISTICS`\\.`SEQ_IN_INDEX`",
                "call": "query",
                "method": "regex",
                "value": "SELECT d.`datasource_physicalname` AS 'TABLE_SCHEMA', m.`metadata_model` AS 'TABLE_NAME', mi.metadataindex_name AS 'INDEX_NAME', mi.`metadataindex_unique`AS 'NON_UNIQUE', mf.`metadatafield_field` AS 'COLUMN_NAME', mi.`metadataindex_order` AS 'SEQ_IN_INDEX' FROM metadata_index mi INNER JOIN metadata m ON m.metadata_id = mi.metadataindex_metadata  INNER JOIN datasource d ON m.metadata_datasource = d.datasource_id  INNER JOIN metadata_field mf ON mi.`metadataindex_metadatafield` = mf.`metadatafield_id`  WHERE d.datasource_id = 2 AND mi.`metadataindex_metadatafield` IS NOT NULL",
                "is_eof": false

            },
            {
                "pattern": "SELECT \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_SCHEMA\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_NAME\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`COLUMN_NAME\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`INDEX_NAME\\` FROM \\`information_schema\\`\\.\\`STATISTICS\\` WHERE \\(\\(\\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_SCHEMA\\` in \\('+([A-Za-z0-9_]+)+'\\) or \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_SCHEMA\\` in \\('+([A-Za-z0-9_]+)+'\\)\\) AND \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`INDEX_NAME\\` = 'PRIMARY'\\) ORDER BY \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_SCHEMA\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_NAME\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`INDEX_NAME\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`SEQ_IN_INDEX\\`",
                "call": "query",
                "method": "regex",
                "value": "SELECT d.`datasource_physicalname` AS 'TABLE_SCHEMA', m.`metadata_model` AS 'TABLE_NAME', mf.`metadatafield_field` AS 'COLUMN_NAME', mi.`metadataindex_name` AS 'INDEX_NAME' FROM metadata_index mi INNER JOIN metadata m ON m.metadata_id = mi.metadataindex_metadata INNER JOIN datasource d ON m.metadata_datasource = d.datasource_id INNER JOIN metadata_field mf ON mi.`metadataindex_order` = mf.`metadatafield_order` AND mi.metadataindex_metadata = mf.`metadatafield_metadata` WHERE d.datasource_id = 2 AND mi.metadataindex_name = 'PRIMARY' AND mi.`metadataindex_deleted` = 0 ORDER BY d.`datasource_physicalname`, m.`metadata_model`, mf.`metadatafield_field`, mi.`metadataindex_name`",
                "is_eof": false
            },
            {
                "pattern": "select `information_schema`.`STATISTICS`.`TABLE_SCHEMA`, `information_schema`.`STATISTICS`.`TABLE_NAME`, `information_schema`.`STATISTICS`.`COLUMN_NAME`, `information_schema`.`STATISTICS`.`INDEX_NAME` from `information_schema`.`STATISTICS` where \\(\\(`information_schema`.`STATISTICS`.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\) or `information_schema`.`STATISTICS`.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\)\\) and `information_schema`.`STATISTICS`.`INDEX_NAME` <> 'PRIMARY' and `information_schema`.`STATISTICS`.`NON_UNIQUE` = '0'\\) order by `information_schema`.`STATISTICS`.`TABLE_SCHEMA`, `information_schema`.`STATISTICS`.`TABLE_NAME`, `information_schema`.`STATISTICS`.`INDEX_NAME`, `information_schema`.`STATISTICS`.`SEQ_IN_INDEX`",
                "call": "query",
                "method": "regex",
                "value": "SELECT d.`datasource_physicalname` AS 'TABLE_SCHEMA', m.`metadata_model` AS 'TABLE_NAME', mf.`metadatafield_field` AS 'COLUMN_NAME', mi.`metadataindex_name` AS 'INDEX_NAME' FROM metadata_index mi INNER JOIN metadata m ON m.metadata_id = mi.metadataindex_metadata INNER JOIN datasource d ON m.metadata_datasource = d.datasource_id INNER JOIN metadata_field mf ON mi.`metadataindex_order` = mf.`metadatafield_order` AND mi.metadataindex_metadata = mf.`metadatafield_metadata` WHERE d.datasource_id = 2 AND mi.metadataindex_name != 'PRIMARY' AND mi.`metadataindex_deleted` = 0 AND mi.`metadataindex_unique` = 1 ORDER BY d.`datasource_physicalname`, m.`metadata_model`, mf.`metadatafield_field`, mi.`metadataindex_name`",
                "is_eof": false
            },
            {
                "pattern": "SELECT `Information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`CONSTRAINT_SCHEMA`, `information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`CONSTRAINT_NAME`, `information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`TABLE_NAME`, `information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`REFERENCED_TABLE_NAME`, `information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`UNIQUE_CONSTRAINT_NAME`, `information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`UNIQUE_CONSTRAINT_SCHEMA`, `information_schema`\\.`KEY_COLUMN_USAGE`\\.`COLUMN_NAME` FROM `information_schema`\\.`REFERENTIAL_CONSTRAINTS` JOIN `information_schema`\\.`KEY_COLUMN_USAGE` on \\(`information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`CONSTRAINT_SCHEMA` = `information_schema`\\.`KEY_COLUMN_USAGE`\\.`CONSTRAINT_SCHEMA` AND `information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`CONSTRAINT_NAME` = `information_schema`\\.`KEY_COLUMN_USAGE`\\.`CONSTRAINT_NAME`\\) WHERE \\(`information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`CONSTRAINT_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\) or `information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`CONSTRAINT_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\)\\) ORDER BY `information_schema`\\.`KEY_COLUMN_USAGE`\\.`CONSTRAINT_SCHEMA` ASC, `information_schema`\\.`KEY_COLUMN_USAGE`\\.`CONSTRAINT_NAME` asc, `information_schema`\\.`KEY_COLUMN_USAGE`\\.`ORDINAL_POSITION` asc",
                "call": "query",
                "method": "regex",
                "value": "SELECT `information_schema`.`REFERENTIAL_CONSTRAINTS`.`CONSTRAINT_SCHEMA`, `information_schema`.`REFERENTIAL_CONSTRAINTS`.`CONSTRAINT_NAME`, `information_schema`.`REFERENTIAL_CONSTRAINTS`.`TABLE_NAME`, `information_schema`.`REFERENTIAL_CONSTRAINTS`.`REFERENCED_TABLE_NAME`, `information_schema`.`REFERENTIAL_CONSTRAINTS`.`UNIQUE_CONSTRAINT_NAME`, `information_schema`.`REFERENTIAL_CONSTRAINTS`.`UNIQUE_CONSTRAINT_SCHEMA`, `information_schema`.`KEY_COLUMN_USAGE`.`COLUMN_NAME` FROM `information_schema`.`REFERENTIAL_CONSTRAINTS` JOIN `information_schema`.`KEY_COLUMN_USAGE` on (`information_schema`.`REFERENTIAL_CONSTRAINTS`.`CONSTRAINT_SCHEMA` = `information_schema`.`KEY_COLUMN_USAGE`.`CONSTRAINT_SCHEMA` AND `information_schema`.`REFERENTIAL_CONSTRAINTS`.`CONSTRAINT_NAME` = `information_schema`.`KEY_COLUMN_USAGE`.`CONSTRAINT_NAME`) WHERE (`information_schema`.`REFERENTIAL_CONSTRAINTS`.`CONSTRAINT_SCHEMA` in ('query_regex') or `information_schema`.`REFERENTIAL_CONSTRAINTS`.`CONSTRAINT_SCHEMA` in ('query_regex')) ORDER BY `information_schema`.`KEY_COLUMN_USAGE`.`CONSTRAINT_SCHEMA` ASC, `information_schema`.`KEY_COLUMN_USAGE`.`CONSTRAINT_NAME` asc, `information_schema`.`KEY_COLUMN_USAGE`.`ORDINAL_POSITION` asc",
                "is_eof": false
            },
            {
                "pattern": "SELECT `information_schema`\\.`COLUMNS`\\.`ORDINAL_POSITION`, `information_schema`\\.`COLUMNS`\\.`COLUMN_NAME`, `information_schema`\\.`COLUMNS`\\.`COLUMN_COMMENT`, `information_schema`\\.`COLUMNS`\\.`COLUMN_TYPE`, `information_schema`\\.`COLUMNS`\\.`DATA_TYPE`, `information_schema`\\.`COLUMNS`\\.`IS_NULLABLE`, `information_schema`\\.`COLUMNS`\\.`COLUMN_DEFAULT`, `information_schema`\\.`COLUMNS`\\.`CHARACTER_MAXIMUM_LENGTH`, `information_schema`\\.`COLUMNS`\\.`NUMERIC_PRECISION`, `information_schema`\\.`COLUMNS`\\.`NUMERIC_SCALE`, `information_schema`\\.`COLUMNS`\\.`EXTRA` FROM `information_schema`\\.`COLUMNS` WHERE \\(`information_schema`\\.`COLUMNS`\\.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+', '+([A-Za-z0-9_]+)+'\\) AND `information_schema`\\.`COLUMNS`\\.`TABLE_NAME` = '+([A-Za-z0-9_]+)+'\\) ORDER BY `information_schema`\\.`COLUMNS`\\.`ORDINAL_POSITION`",
                "call": "query",
                "method": "regex",
                "value": "SELECT ROW_NUMBER() OVER ( ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC ) AS 'ORDINAL_POSITION', mf.`metadatafield_field` AS 'COLUMN_NAME', '' AS 'COLUMN_COMMENT', IF( mf.`metadatafield_typelength` IS NOT NULL, CONCAT( LOWER(mf.`metadatafield_origintype`), '(', mf.`metadatafield_typelength`, ')' ), IF( mf.`metadatafield_unsigned` = 1, CONCAT(LOWER(mf.`metadatafield_origintype`), ' unsigned'), LOWER(mf.`metadatafield_origintype`) ) ) AS 'COLUMN_TYPE', LOWER(mf.`metadatafield_origintype`) AS 'DATA_TYPE', IF(mf.`metadatafield_nullable`, 'YES', 'NO') AS 'IS_NULLABLE', NULL AS 'COLUMN_DEFAULT', mf.`metadatafield_typelength` AS 'CHARACTER_MAXIMUM_LENGTH', NULL AS 'NUMERIC_PRECISION', NULL AS 'NUMERIC_SCALE', NULL AS 'EXTRA' FROM metadata_field mf INNER JOIN metadata m ON mf.`metadatafield_metadata` = m.`metadata_id` WHERE ( m.`metadata_model` REGEXP '#3#_ext[0-9]+' OR m.`metadata_model` = '#3#' ) AND m.`metadata_datasource` = 2 AND mf.`metadatafield_deleted` = 0 AND mf.`metadatafield_origintype` IS NOT NULL GROUP BY mf.`metadatafield_field` ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC",
                "is_eof": false
            }
        ];

    }

    public async process(query: string, packets: Packets): Promise<resultReserved> {
        let results: resultReserved = { "data": "", "action": "", "status": false, "is_eof": true };
        this.fixedCommand.forEach(el => {
            if (el.method == "regex") {
                let exp = new RegExp(el.pattern, 'gmi');
                let tmp = exp.exec(query);
                if (tmp) {
                    let param: Array<any>;
                    tmp.shift();
                    param = tmp.slice(-3);
                    let func = el.call.split(' ')[0];
                    switch (func) {
                        case "useDB":
                            results = this.useDB(param[0], el.is_eof);
                            break;
                        case "setGlobalVariable":
                            results = this.setGlobalVariable(el.is_eof);
                            break;
                        case "query":
                            results = this.query(query, el, param, el.is_eof);
                    }
                    return;
                }
            } else if (el.method == "equal") {
                if (el.pattern == query) {
                    results = this.query(query, el, [], el.is_eof);
                }
                return;
            }
        });
        return results;
    }

    protected useDB(args: string, is_eof: boolean): resultReserved {
        let okPacket = new UBuffer();
        okPacket.from([0x07, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x02, 0x00, 0x00, 0x00]);
        let result = { "status": true, "action": "write", "data": okPacket.data(), "is_eof": is_eof }
        return result;
    }

    protected setGlobalVariable(is_eof: boolean): resultReserved {
        console.log("Set Global Variable");
        let okPacket = new UBuffer();
        okPacket.from([0x07, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x02, 0x00, 0x00, 0x00]);
        let result = { "status": true, "action": "write", "data": okPacket.data(), "is_eof": is_eof }
        return result;
    }

    protected query(query: string, command: command, param: Array<string>, is_eof: boolean): resultReserved {
        let okPacket = new UBuffer();
        okPacket.from([0x07, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x02, 0x00, 0x00, 0x00]);
        let result: resultReserved = { "status": true, "action": "query", "data": okPacket.data(), "is_eof": is_eof };
        result.data = command.value;
        for (let index = 0; index < param.length; index++) {
            let tmp_replace = param[index];
            let exp = new RegExp(`#${index + 1}#`, 'gmi');
            result.data = result.data.replace(exp, tmp_replace);
        }
        return result;
    }

}