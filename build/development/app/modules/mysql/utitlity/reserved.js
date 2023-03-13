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
const ubuffer_1 = __importDefault(require("./ubuffer"));
const ok_1 = __importDefault(require("../packet/ok"));
const okdev_1 = __importDefault(require("../packet/okdev"));
class Reserved {
    constructor() {
        this.okPacket = new ok_1.default();
        this.okPacketDev = new okdev_1.default();
        this.fixedCommand = [
            {
                "pattern": "(?<=USE )([A-Za-z0-9_`]+)",
                "call": "useDB (db)"
            },
            {
                "pattern": "^SET .+",
                "call": "setGlobalVariable"
            },
            {
                "pattern": "^SET .+",
                "call": "setGlobalVariable"
            },
            {
                "pattern": "select 1 as `one` from dual",
                "call": "dualOne"
            },
            {
                "pattern": "SHOW WARNINGS",
                "call": "showWarnings"
            },
            {
                "pattern": "SELECT  @@session.auto_increment_increment AS auto_increment_increment, @@character_set_client AS character_set_client, @@character_set_connection AS character_set_connection, @@character_set_results AS character_set_results, @@character_set_server AS character_set_server, @@collation_server AS collation_server, @@init_connect AS init_connect, @@interactive_timeout AS interactive_timeout, @@license AS license, @@lower_case_table_names AS lower_case_table_names, @@max_allowed_packet AS max_allowed_packet, @@net_buffer_length AS net_buffer_length, @@net_write_timeout AS net_write_timeout, @@sql_mode AS sql_mode, @@system_time_zone AS system_time_zone, @@time_zone AS time_zone, @@transaction_isolation AS transaction_isolation, @@wait_timeout AS wait_timeout",
                "call": "initialization"
            },
            {
                "pattern": "select `information_schema`.`SCHEMATA`.`SCHEMA_NAME` from `information_schema`.`SCHEMATA`",
                "call": "getDB"
            },
            {
                "pattern": "select `information_schema`\\.`TABLES`\\.`TABLE_SCHEMA`, `information_schema`\\.`TABLES`\\.`TABLE_NAME`, `information_schema`\\.`TABLES`\\.`TABLE_COMMENT` from `information_schema`\\.`TABLES` where \\(`information_schema`\\.`TABLES`\\.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\) or `information_schema`\\.`TABLES`\\.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\)\\) order by `information_schema`\\.`TABLES`\\.`TABLE_SCHEMA`, `information_schema`\\.`TABLES`\\.`TABLE_NAME`",
                "call": "getTable (db)"
            },
            {
                "pattern": "select `information_schema`\\.`COLUMNS`\\.`TABLE_SCHEMA`, `information_schema`\\.`COLUMNS`\\.`COLUMN_COMMENT`, `information_schema`\\.`COLUMNS`\\.`TABLE_NAME`, `information_schema`\\.`COLUMNS`\\.`COLUMN_NAME`, `information_schema`\\.`COLUMNS`\\.`COLUMN_TYPE` from `information_schema`\\.`COLUMNS` where \\(`information_schema`\\.`COLUMNS`\\.`COLUMN_TYPE` like 'enum\\(\\%\\)' and \\(`information_schema`\\.`COLUMNS`\\.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\) or `information_schema`\\.`COLUMNS`\\.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\)\\)\\) order by `information_schema`\\.`COLUMNS`\\.`TABLE_SCHEMA` asc, `information_schema`\\.`COLUMNS`\\.`TABLE_NAME` asc, `information_schema`\\.`COLUMNS`\\.`COLUMN_NAME` asc",
                "call": "getTableEmpty"
            },
            {
                "pattern": "SELECT `Information_schema`\\.`STATISTICS`\\.`TABLE_SCHEMA`, `information_schema`\\.`STATISTICS`\\.`TABLE_NAME`, `information_schema`\\.`STATISTICS`\\.`INDEX_NAME`, `information_schema`\\.`STATISTICS`\\.`NON_UNIQUE`, `information_schema`\\.`STATISTICS`\\.`COLUMN_NAME`, `information_schema`\\.`STATISTICS`\\.`SEQ_IN_INDEX` FROM `information_schema`\\.`STATISTICS` WHERE \\(`information_schema`\\.`STATISTICS`\\.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\) or `information_schema`\\.`STATISTICS`\\.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\)\\) ORDER BY `information_schema`\\.`STATISTICS`\\.`TABLE_SCHEMA`, `information_schema`\\.`STATISTICS`\\.`TABLE_NAME`, `information_schema`\\.`STATISTICS`\\.`INDEX_NAME`, `information_schema`\\.`STATISTICS`\\.`SEQ_IN_INDEX`",
                "call": "getStatisticIndex"
            },
            {
                "pattern": "SELECT \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_SCHEMA\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_NAME\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`COLUMN_NAME\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`INDEX_NAME\\` FROM \\`information_schema\\`\\.\\`STATISTICS\\` WHERE \\(\\(\\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_SCHEMA\\` in \\('+([A-Za-z0-9_]+)+'\\) or \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_SCHEMA\\` in \\('+([A-Za-z0-9_]+)+'\\)\\) AND \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`INDEX_NAME\\` = 'PRIMARY'\\) ORDER BY \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_SCHEMA\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_NAME\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`INDEX_NAME\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`SEQ_IN_INDEX\\`",
                "call": "getPrimaryIndex"
            },
            {
                // "pattern": "SELECT \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_SCHEMA\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_NAME\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`COLUMN_NAME\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`INDEX_NAME\\` FROM \\`information_schema\\`\\.\\`STATISTICS\\` WHERE \\(\\(\\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_SCHEMA\\` in \\(\\'+([A-Za-z0-9_]+)+\\'\\) or \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_SCHEMA\\` in \\(\\'+([A-Za-z0-9_]+)+\\'\\)\\) AND \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`INDEX_NAME\\` \\<\\> \\'PRIMARY\\' and \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`NON_UNIQUE\\` \\= \\'0\\'\\) ORDER BY \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_SCHEMA\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`TABLE_NAME\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`INDEX_NAME\\`, \\`information_schema\\`\\.\\`STATISTICS\\`\\.\\`SEQ_IN_INDEX\\``",
                "pattern": "select `information_schema`.`STATISTICS`.`TABLE_SCHEMA`, `information_schema`.`STATISTICS`.`TABLE_NAME`, `information_schema`.`STATISTICS`.`COLUMN_NAME`, `information_schema`.`STATISTICS`.`INDEX_NAME` from `information_schema`.`STATISTICS` where \\(\\(`information_schema`.`STATISTICS`.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\) or `information_schema`.`STATISTICS`.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\)\\) and `information_schema`.`STATISTICS`.`INDEX_NAME` <> 'PRIMARY' and `information_schema`.`STATISTICS`.`NON_UNIQUE` = '0'\\) order by `information_schema`.`STATISTICS`.`TABLE_SCHEMA`, `information_schema`.`STATISTICS`.`TABLE_NAME`, `information_schema`.`STATISTICS`.`INDEX_NAME`, `information_schema`.`STATISTICS`.`SEQ_IN_INDEX`",
                "call": "getNonPrimaryIndex"
            },
            {
                "pattern": "SELECT `Information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`CONSTRAINT_SCHEMA`, `information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`CONSTRAINT_NAME`, `information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`TABLE_NAME`, `information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`REFERENCED_TABLE_NAME`, `information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`UNIQUE_CONSTRAINT_NAME`, `information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`UNIQUE_CONSTRAINT_SCHEMA`, `information_schema`\\.`KEY_COLUMN_USAGE`\\.`COLUMN_NAME` FROM `information_schema`\\.`REFERENTIAL_CONSTRAINTS` JOIN `information_schema`\\.`KEY_COLUMN_USAGE` on \\(`information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`CONSTRAINT_SCHEMA` = `information_schema`\\.`KEY_COLUMN_USAGE`\\.`CONSTRAINT_SCHEMA` AND `information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`CONSTRAINT_NAME` = `information_schema`\\.`KEY_COLUMN_USAGE`\\.`CONSTRAINT_NAME`\\) WHERE \\(`information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`CONSTRAINT_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\) or `information_schema`\\.`REFERENTIAL_CONSTRAINTS`\\.`CONSTRAINT_SCHEMA` in \\('+([A-Za-z0-9_]+)+'\\)\\) ORDER BY `information_schema`\\.`KEY_COLUMN_USAGE`\\.`CONSTRAINT_SCHEMA` ASC, `information_schema`\\.`KEY_COLUMN_USAGE`\\.`CONSTRAINT_NAME` asc, `information_schema`\\.`KEY_COLUMN_USAGE`\\.`ORDINAL_POSITION` asc",
                "call": "getReferentialConstraint"
            },
            {
                "pattern": "SELECT `information_schema`\\.`COLUMNS`\\.`ORDINAL_POSITION`, `information_schema`\\.`COLUMNS`\\.`COLUMN_NAME`, `information_schema`\\.`COLUMNS`\\.`COLUMN_COMMENT`, `information_schema`\\.`COLUMNS`\\.`COLUMN_TYPE`, `information_schema`\\.`COLUMNS`\\.`DATA_TYPE`, `information_schema`\\.`COLUMNS`\\.`IS_NULLABLE`, `information_schema`\\.`COLUMNS`\\.`COLUMN_DEFAULT`, `information_schema`\\.`COLUMNS`\\.`CHARACTER_MAXIMUM_LENGTH`, `information_schema`\\.`COLUMNS`\\.`NUMERIC_PRECISION`, `information_schema`\\.`COLUMNS`\\.`NUMERIC_SCALE`, `information_schema`\\.`COLUMNS`\\.`EXTRA` FROM `information_schema`\\.`COLUMNS` WHERE \\(`information_schema`\\.`COLUMNS`\\.`TABLE_SCHEMA` in \\('+([A-Za-z0-9_]+)+', '+([A-Za-z0-9_]+)+'\\) AND `information_schema`\\.`COLUMNS`\\.`TABLE_NAME` = '+([A-Za-z0-9_]+)+'\\) ORDER BY `information_schema`\\.`COLUMNS`\\.`ORDINAL_POSITION`",
                "call": "getColumn (db) (table)"
            }
        ];
    }
    process(query) {
        return __awaiter(this, void 0, void 0, function* () {
            let results = { "data": "", "action": "", "status": false };
            this.fixedCommand.forEach(el => {
                let exp = new RegExp(el.pattern, 'gmi');
                let tmp = exp.exec(query);
                if (tmp) {
                    let param;
                    // if (tmp[1]) {
                    //     param = tmp[1];
                    // }
                    tmp.shift();
                    param = tmp.slice(-3);
                    console.log("Reserved Command");
                    console.log(param);
                    let func = el.call.split(' ')[0];
                    console.log(func);
                    switch (func) {
                        case "useDB":
                            results = this.useDB(param[0]);
                            break;
                        case "getDB":
                            results = this.getDB();
                            break;
                        case "getTable":
                            results = this.getTable();
                            break;
                        case "setGlobalVariable":
                            results = this.setGlobalVariable();
                            break;
                        case "getTableEmpty":
                            results = this.getTableEmpty();
                            break;
                        case "initialization":
                            results = this.initialization();
                            break;
                        case "getReferentialConstraint":
                            results = this.getReferentialConstraint();
                            break;
                        case "dualOne":
                            results = this.dualOne();
                            break;
                        case "showWarnings":
                            results = this.showWarnings();
                            break;
                        case "getColumn":
                            results = this.getColumns(param[0], param[param.length - 1]);
                            break;
                        case "getPrimaryIndex":
                            results = this.getPrimaryIndex();
                            break;
                        case "getNonPrimaryIndex":
                            results = this.getNonPrimaryIndex();
                            break;
                        case "getStatisticIndex":
                            results = this.getStatisticIndex();
                            break;
                    }
                    return;
                }
            });
            return results;
        });
    }
    useDB(args) {
        console.log("Use DB");
        let okPacket = new ubuffer_1.default();
        okPacket.from([0x07, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x02, 0x00, 0x00, 0x00]);
        let result = { "status": true, "action": "write", "data": okPacket.data() };
        return result;
    }
    setGlobalVariable() {
        console.log("Set Global Variable");
        let okPacket = new ubuffer_1.default();
        okPacket.from([0x07, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x02, 0x00, 0x00, 0x00]);
        let result = { "status": true, "action": "write", "data": okPacket.data() };
        return result;
    }
    getDB() {
        console.log("Get DB");
        let result = { "status": true, "action": "query", "data": "SELECT `datasource_physicalname` as 'SCHEMA_NAME' FROM datasource GROUP BY datasource_physicalname" };
        return result;
    }
    getTable() {
        console.log("Get Table");
        let result = { "status": true, "action": "query", "data": "SELECT d.`datasource_physicalname` AS 'TABLE_SCHEMA', m.`metadata_model` AS 'TABLE_NAME', '' AS 'TABLE_COMMENT' FROM datasource d INNER JOIN metadata m ON d.`datasource_id` = m.`metadata_datasource` WHERE d.datasource_id = 2 AND m.`metadata_model` NOT REGEXP '[A-Za-z]+_ext[0-9]+' AND m.`metadata_deleted` = 0" };
        return result;
    }
    getTableEmpty() {
        console.log("Get Table Empty");
        let result = { "status": true, "action": "query", "data": "select `information_schema`.`COLUMNS`.`TABLE_SCHEMA`, `information_schema`.`COLUMNS`.`COLUMN_COMMENT`, `information_schema`.`COLUMNS`.`TABLE_NAME`, `information_schema`.`COLUMNS`.`COLUMN_NAME`, `information_schema`.`COLUMNS`.`COLUMN_TYPE` from `information_schema`.`COLUMNS` where (`information_schema`.`COLUMNS`.`COLUMN_TYPE` like 'enum(%)' and (`information_schema`.`COLUMNS`.`TABLE_SCHEMA` in ('query_regex') or `information_schema`.`COLUMNS`.`TABLE_SCHEMA` in ('query_regex'))) order by `information_schema`.`COLUMNS`.`TABLE_SCHEMA` asc, `information_schema`.`COLUMNS`.`TABLE_NAME` asc, `information_schema`.`COLUMNS`.`COLUMN_NAME` asc" };
        return result;
    }
    getStatisticIndex() {
        console.log("Get Statistic Index");
        let result = { "status": true, "action": "query", "data": "SELECT d.`datasource_physicalname` AS 'TABLE_SCHEMA', m.`metadata_model` AS 'TABLE_NAME', mi.metadataindex_name AS 'INDEX_NAME', mi.`metadataindex_unique`AS 'NON_UNIQUE', mf.`metadatafield_field` AS 'COLUMN_NAME', mi.`metadataindex_order` AS 'SEQ_IN_INDEX' FROM metadata_index mi INNER JOIN metadata m ON m.metadata_id = mi.metadataindex_metadata  INNER JOIN datasource d ON m.metadata_datasource = d.datasource_id  INNER JOIN metadata_field mf ON mi.`metadataindex_metadatafield` = mf.`metadatafield_id`  WHERE d.datasource_id = 2 AND mi.`metadataindex_metadatafield` IS NOT NULL" };
        return result;
    }
    getPrimaryIndex() {
        console.log("Get Primary Index");
        // let result = { "status": true, "action": "query", "data": "SELECT d.`datasource_physicalname` AS 'TABLE_SCHEMA', m.`metadata_model` AS 'TABLE_NAME', mi.metadataindex_name AS 'INDEX_NAME', mi.`metadataindex_unique`AS 'NON_UNIQUE', mf.`metadatafield_field` AS 'COLUMN_NAME', mi.`metadataindex_order` AS 'SEQ_IN_INDEX' FROM metadata_index mi INNER JOIN metadata m ON m.metadata_id = mi.metadataindex_metadata  INNER JOIN datasource d ON m.metadata_datasource = d.datasource_id  INNER JOIN metadata_field mf ON mi.`metadataindex_metadatafield` = mf.`metadatafield_id`  WHERE d.datasource_id = 2 AND mi.`metadataindex_metadatafield` IS NOT NULL AND mi.metadataindex_name = 'PRIMARY'" }
        let result = { "status": true, "action": "query", "data": "SELECT d.`datasource_physicalname` AS 'TABLE_SCHEMA', m.`metadata_model` AS 'TABLE_NAME', mf.`metadatafield_field` AS 'COLUMN_NAME', mi.`metadataindex_name` AS 'INDEX_NAME' FROM metadata_index mi INNER JOIN metadata m ON m.metadata_id = mi.metadataindex_metadata INNER JOIN datasource d ON m.metadata_datasource = d.datasource_id INNER JOIN metadata_field mf ON mi.`metadataindex_order` = mf.`metadatafield_order` AND mi.metadataindex_metadata = mf.`metadatafield_metadata` WHERE d.datasource_id = 2 AND mi.metadataindex_name = 'PRIMARY' AND mi.`metadataindex_deleted` = 0 ORDER BY d.`datasource_physicalname`, m.`metadata_model`, mf.`metadatafield_field`, mi.`metadataindex_name`" };
        return result;
    }
    getNonPrimaryIndex() {
        console.log("Get Non Primary Index");
        // let result = { "status": true, "action": "query", "data": "SELECT d.`datasource_physicalname` AS 'TABLE_SCHEMA', m.`metadata_model` AS 'TABLE_NAME', mi.metadataindex_name AS 'INDEX_NAME', mi.`metadataindex_unique`AS 'NON_UNIQUE', mf.`metadatafield_field` AS 'COLUMN_NAME', mi.`metadataindex_order` AS 'SEQ_IN_INDEX' FROM metadata_index mi INNER JOIN metadata m ON m.metadata_id = mi.metadataindex_metadata  INNER JOIN datasource d ON m.metadata_datasource = d.datasource_id  INNER JOIN metadata_field mf ON mi.`metadataindex_metadatafield` = mf.`metadatafield_id`  WHERE d.datasource_id = 2 AND mi.`metadataindex_metadatafield` IS NOT NULL AND mi.metadataindex_name != 'PRIMARY'" }
        let result = { "status": true, "action": "query", "data": "SELECT d.`datasource_physicalname` AS 'TABLE_SCHEMA', m.`metadata_model` AS 'TABLE_NAME', mf.`metadatafield_field` AS 'COLUMN_NAME', mi.`metadataindex_name` AS 'INDEX_NAME' FROM metadata_index mi INNER JOIN metadata m ON m.metadata_id = mi.metadataindex_metadata INNER JOIN datasource d ON m.metadata_datasource = d.datasource_id INNER JOIN metadata_field mf ON mi.`metadataindex_order` = mf.`metadatafield_order` AND mi.metadataindex_metadata = mf.`metadatafield_metadata` WHERE d.datasource_id = 2 AND mi.metadataindex_name != 'PRIMARY' AND mi.`metadataindex_deleted` = 0 AND mi.`metadataindex_unique` = 1 ORDER BY d.`datasource_physicalname`, m.`metadata_model`, mf.`metadatafield_field`, mi.`metadataindex_name`" };
        return result;
    }
    initialization() {
        console.log("Initialization");
        let data = new ubuffer_1.default();
        data.from([0x01, 0x00, 0x00, 0x01, 0x12, 0x2e, 0x00, 0x00, 0x02, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x18, 0x61, 0x75, 0x74, 0x6f, 0x5f, 0x69, 0x6e, 0x63, 0x72, 0x65, 0x6d, 0x65, 0x6e, 0x74, 0x5f, 0x69, 0x6e, 0x63, 0x72, 0x65, 0x6d, 0x65, 0x6e, 0x74, 0x00, 0x0c, 0x3f, 0x00, 0x15, 0x00, 0x00, 0x00, 0x08, 0xa0, 0x00, 0x00, 0x00, 0x00, 0x2a, 0x00, 0x00, 0x03, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x14, 0x63, 0x68, 0x61, 0x72, 0x61, 0x63, 0x74, 0x65, 0x72, 0x5f, 0x73, 0x65, 0x74, 0x5f, 0x63, 0x6c, 0x69, 0x65, 0x6e, 0x74, 0x00, 0x0c, 0x21, 0x00, 0xff, 0xff, 0x00, 0x00, 0xfd, 0x00, 0x00, 0x1f, 0x00, 0x00, 0x2e, 0x00, 0x00, 0x04, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x18, 0x63, 0x68, 0x61, 0x72, 0x61, 0x63, 0x74, 0x65, 0x72, 0x5f, 0x73, 0x65, 0x74, 0x5f, 0x63, 0x6f, 0x6e, 0x6e, 0x65, 0x63, 0x74, 0x69, 0x6f, 0x6e, 0x00, 0x0c, 0x21, 0x00, 0xff, 0xff, 0x00, 0x00, 0xfd, 0x00, 0x00, 0x1f, 0x00, 0x00, 0x2b, 0x00, 0x00, 0x05, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x15, 0x63, 0x68, 0x61, 0x72, 0x61, 0x63, 0x74, 0x65, 0x72, 0x5f, 0x73, 0x65, 0x74, 0x5f, 0x72, 0x65, 0x73, 0x75, 0x6c, 0x74, 0x73, 0x00, 0x0c, 0x21, 0x00, 0xff, 0xff, 0x00, 0x00, 0xfd, 0x00, 0x00, 0x1f, 0x00, 0x00, 0x2a, 0x00, 0x00, 0x06, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x14, 0x63, 0x68, 0x61, 0x72, 0x61, 0x63, 0x74, 0x65, 0x72, 0x5f, 0x73, 0x65, 0x74, 0x5f, 0x73, 0x65, 0x72, 0x76, 0x65, 0x72, 0x00, 0x0c, 0x21, 0x00, 0xff, 0xff, 0x00, 0x00, 0xfd, 0x00, 0x00, 0x1f, 0x00, 0x00, 0x26, 0x00, 0x00, 0x07, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x10, 0x63, 0x6f, 0x6c, 0x6c, 0x61, 0x74, 0x69, 0x6f, 0x6e, 0x5f, 0x73, 0x65, 0x72, 0x76, 0x65, 0x72, 0x00, 0x0c, 0x21, 0x00, 0xff, 0xff, 0x00, 0x00, 0xfd, 0x00, 0x00, 0x1f, 0x00, 0x00, 0x22, 0x00, 0x00, 0x08, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x0c, 0x69, 0x6e, 0x69, 0x74, 0x5f, 0x63, 0x6f, 0x6e, 0x6e, 0x65, 0x63, 0x74, 0x00, 0x0c, 0x21, 0x00, 0xff, 0xff, 0x00, 0x00, 0xfd, 0x00, 0x00, 0x1f, 0x00, 0x00, 0x29, 0x00, 0x00, 0x09, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x13, 0x69, 0x6e, 0x74, 0x65, 0x72, 0x61, 0x63, 0x74, 0x69, 0x76, 0x65, 0x5f, 0x74, 0x69, 0x6d, 0x65, 0x6f, 0x75, 0x74, 0x00, 0x0c, 0x3f, 0x00, 0x15, 0x00, 0x00, 0x00, 0x08, 0xa0, 0x00, 0x00, 0x00, 0x00, 0x1d, 0x00, 0x00, 0x0a, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x07, 0x6c, 0x69, 0x63, 0x65, 0x6e, 0x73, 0x65, 0x00, 0x0c, 0x21, 0x00, 0xff, 0xff, 0x00, 0x00, 0xfd, 0x00, 0x00, 0x1f, 0x00, 0x00, 0x2c, 0x00, 0x00, 0x0b, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x16, 0x6c, 0x6f, 0x77, 0x65, 0x72, 0x5f, 0x63, 0x61, 0x73, 0x65, 0x5f, 0x74, 0x61, 0x62, 0x6c, 0x65, 0x5f, 0x6e, 0x61, 0x6d, 0x65, 0x73, 0x00, 0x0c, 0x3f, 0x00, 0x15, 0x00, 0x00, 0x00, 0x08, 0xa0, 0x00, 0x00, 0x00, 0x00, 0x28, 0x00, 0x00, 0x0c, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x12, 0x6d, 0x61, 0x78, 0x5f, 0x61, 0x6c, 0x6c, 0x6f, 0x77, 0x65, 0x64, 0x5f, 0x70, 0x61, 0x63, 0x6b, 0x65, 0x74, 0x00, 0x0c, 0x3f, 0x00, 0x15, 0x00, 0x00, 0x00, 0x08, 0xa0, 0x00, 0x00, 0x00, 0x00, 0x27, 0x00, 0x00, 0x0d, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x11, 0x6e, 0x65, 0x74, 0x5f, 0x62, 0x75, 0x66, 0x66, 0x65, 0x72, 0x5f, 0x6c, 0x65, 0x6e, 0x67, 0x74, 0x68, 0x00, 0x0c, 0x3f, 0x00, 0x15, 0x00, 0x00, 0x00, 0x08, 0xa0, 0x00, 0x00, 0x00, 0x00, 0x27, 0x00, 0x00, 0x0e, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x11, 0x6e, 0x65, 0x74, 0x5f, 0x77, 0x72, 0x69, 0x74, 0x65, 0x5f, 0x74, 0x69, 0x6d, 0x65, 0x6f, 0x75, 0x74, 0x00, 0x0c, 0x3f, 0x00, 0x15, 0x00, 0x00, 0x00, 0x08, 0xa0, 0x00, 0x00, 0x00, 0x00, 0x1e, 0x00, 0x00, 0x0f, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x08, 0x73, 0x71, 0x6c, 0x5f, 0x6d, 0x6f, 0x64, 0x65, 0x00, 0x0c, 0x21, 0x00, 0xff, 0xff, 0x00, 0x00, 0xfd, 0x00, 0x00, 0x1f, 0x00, 0x00, 0x26, 0x00, 0x00, 0x10, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x10, 0x73, 0x79, 0x73, 0x74, 0x65, 0x6d, 0x5f, 0x74, 0x69, 0x6d, 0x65, 0x5f, 0x7a, 0x6f, 0x6e, 0x65, 0x00, 0x0c, 0x21, 0x00, 0xff, 0xff, 0x00, 0x00, 0xfd, 0x00, 0x00, 0x1f, 0x00, 0x00, 0x1f, 0x00, 0x00, 0x11, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x09, 0x74, 0x69, 0x6d, 0x65, 0x5f, 0x7a, 0x6f, 0x6e, 0x65, 0x00, 0x0c, 0x21, 0x00, 0xff, 0xff, 0x00, 0x00, 0xfd, 0x00, 0x00, 0x1f, 0x00, 0x00, 0x2b, 0x00, 0x00, 0x12, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x15, 0x74, 0x72, 0x61, 0x6e, 0x73, 0x61, 0x63, 0x74, 0x69, 0x6f, 0x6e, 0x5f, 0x69, 0x73, 0x6f, 0x6c, 0x61, 0x74, 0x69, 0x6f, 0x6e, 0x00, 0x0c, 0x21, 0x00, 0xff, 0xff, 0x00, 0x00, 0xfd, 0x00, 0x00, 0x1f, 0x00, 0x00, 0x22, 0x00, 0x00, 0x13, 0x03, 0x64, 0x65, 0x66, 0x00, 0x00, 0x00, 0x0c, 0x77, 0x61, 0x69, 0x74, 0x5f, 0x74, 0x69, 0x6d, 0x65, 0x6f, 0x75, 0x74, 0x00, 0x0c, 0x3f, 0x00, 0x15, 0x00, 0x00, 0x00, 0x08, 0xa0, 0x00, 0x00, 0x00, 0x00, 0xeb, 0x00, 0x00, 0x14, 0x01, 0x31, 0x07, 0x75, 0x74, 0x66, 0x38, 0x6d, 0x62, 0x33, 0x07, 0x75, 0x74, 0x66, 0x38, 0x6d, 0x62, 0x33, 0x07, 0x75, 0x74, 0x66, 0x38, 0x6d, 0x62, 0x33, 0x07, 0x75, 0x74, 0x66, 0x38, 0x6d, 0x62, 0x34, 0x12, 0x75, 0x74, 0x66, 0x38, 0x6d, 0x62, 0x34, 0x5f, 0x30, 0x39, 0x30, 0x30, 0x5f, 0x61, 0x69, 0x5f, 0x63, 0x69, 0x00, 0x05, 0x32, 0x38, 0x38, 0x30, 0x30, 0x03, 0x47, 0x50, 0x4c, 0x01, 0x32, 0x08, 0x36, 0x37, 0x31, 0x30, 0x38, 0x38, 0x36, 0x34, 0x05, 0x31, 0x36, 0x33, 0x38, 0x34, 0x02, 0x36, 0x30, 0x75, 0x4f, 0x4e, 0x4c, 0x59, 0x5f, 0x46, 0x55, 0x4c, 0x4c, 0x5f, 0x47, 0x52, 0x4f, 0x55, 0x50, 0x5f, 0x42, 0x59, 0x2c, 0x53, 0x54, 0x52, 0x49, 0x43, 0x54, 0x5f, 0x54, 0x52, 0x41, 0x4e, 0x53, 0x5f, 0x54, 0x41, 0x42, 0x4c, 0x45, 0x53, 0x2c, 0x4e, 0x4f, 0x5f, 0x5a, 0x45, 0x52, 0x4f, 0x5f, 0x49, 0x4e, 0x5f, 0x44, 0x41, 0x54, 0x45, 0x2c, 0x4e, 0x4f, 0x5f, 0x5a, 0x45, 0x52, 0x4f, 0x5f, 0x44, 0x41, 0x54, 0x45, 0x2c, 0x45, 0x52, 0x52, 0x4f, 0x52, 0x5f, 0x46, 0x4f, 0x52, 0x5f, 0x44, 0x49, 0x56, 0x49, 0x53, 0x49, 0x4f, 0x4e, 0x5f, 0x42, 0x59, 0x5f, 0x5a, 0x45, 0x52, 0x4f, 0x2c, 0x4e, 0x4f, 0x5f, 0x45, 0x4e, 0x47, 0x49, 0x4e, 0x45, 0x5f, 0x53, 0x55, 0x42, 0x53, 0x54, 0x49, 0x54, 0x55, 0x54, 0x49, 0x4f, 0x4e, 0x03, 0x57, 0x49, 0x42, 0x06, 0x53, 0x59, 0x53, 0x54, 0x45, 0x4d, 0x0f, 0x52, 0x45, 0x50, 0x45, 0x41, 0x54, 0x41, 0x42, 0x4c, 0x45, 0x2d, 0x52, 0x45, 0x41, 0x44, 0x05, 0x32, 0x38, 0x38, 0x30, 0x30, 0x07, 0x00, 0x00, 0x15, 0xfe, 0x00, 0x00, 0x02, 0x00, 0x00, 0x00]);
        let result = { "status": true, "action": "write", "data": data.data() };
        return result;
    }
    getReferentialConstraint() {
        console.log("Get Referential Constraint");
        let result = { "status": true, "action": "query", "data": "SELECT `information_schema`.`REFERENTIAL_CONSTRAINTS`.`CONSTRAINT_SCHEMA`, `information_schema`.`REFERENTIAL_CONSTRAINTS`.`CONSTRAINT_NAME`, `information_schema`.`REFERENTIAL_CONSTRAINTS`.`TABLE_NAME`, `information_schema`.`REFERENTIAL_CONSTRAINTS`.`REFERENCED_TABLE_NAME`, `information_schema`.`REFERENTIAL_CONSTRAINTS`.`UNIQUE_CONSTRAINT_NAME`, `information_schema`.`REFERENTIAL_CONSTRAINTS`.`UNIQUE_CONSTRAINT_SCHEMA`, `information_schema`.`KEY_COLUMN_USAGE`.`COLUMN_NAME` FROM `information_schema`.`REFERENTIAL_CONSTRAINTS` JOIN `information_schema`.`KEY_COLUMN_USAGE` on (`information_schema`.`REFERENTIAL_CONSTRAINTS`.`CONSTRAINT_SCHEMA` = `information_schema`.`KEY_COLUMN_USAGE`.`CONSTRAINT_SCHEMA` AND `information_schema`.`REFERENTIAL_CONSTRAINTS`.`CONSTRAINT_NAME` = `information_schema`.`KEY_COLUMN_USAGE`.`CONSTRAINT_NAME`) WHERE (`information_schema`.`REFERENTIAL_CONSTRAINTS`.`CONSTRAINT_SCHEMA` in ('query_regex') or `information_schema`.`REFERENTIAL_CONSTRAINTS`.`CONSTRAINT_SCHEMA` in ('query_regex')) ORDER BY `information_schema`.`KEY_COLUMN_USAGE`.`CONSTRAINT_SCHEMA` ASC, `information_schema`.`KEY_COLUMN_USAGE`.`CONSTRAINT_NAME` asc, `information_schema`.`KEY_COLUMN_USAGE`.`ORDINAL_POSITION` asc" };
        return result;
    }
    getColumns(db, table) {
        console.log("Get Columns");
        // let result = { "status": true, "action": "query", "data": "SELECT ROW_NUMBER() OVER (ORDER BY m.`metadata_model`,mf.`metadatafield_order` ASC) AS 'ORDINAL_POSITION', mf.`metadatafield_field` AS 'COLUMN_NAME', '' AS 'COLUMN_COMMENT', LOWER(mf.`metadatafield_type`) AS 'COLUMN_TYPE', LOWER(mf.`metadatafield_type`) AS 'DATA_TYPE', IF(mf.`metadatafield_nullable`, 'YES', 'NO') AS 'IS_NULLABLE', NULL AS 'COLUMN_DEFAULT', mf.`metadatafield_typelength` AS 'CHARACTER_MAXIMUM_LENGTH', NULL AS 'NUMERIC_PRECISION', NULL AS 'NUMERIC_SCALE', NULL AS 'EXTRA' FROM metadata_field mf INNER JOIN metadata m ON mf.`metadatafield_metadata` = m.`metadata_id` WHERE m.`metadata_model` REGEXP '" + table + "_ext[0-9]+' OR m.`metadata_model` = '" + table + "' AND m.`metadata_datasource` = 2 GROUP BY mf.`metadatafield_field` ORDER BY m.`metadata_model`,mf.`metadatafield_order` ASC" }
        // let result = { "status": true, "action": "query", "data": "SELECT ROW_NUMBER() OVER ( ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC ) AS 'ORDINAL_POSITION', mf.`metadatafield_field` AS 'COLUMN_NAME', '' AS 'COLUMN_COMMENT', IF( LOWER(mf.`metadatafield_type`) = 'bigint', 'bigint unsigned', IF( LOWER(mf.`metadatafield_type`) = 'int', IF( mf.`metadatafield_platformtype` = 'UTCTIME', 'int unsigned', IF( mf.`metadatafield_key` = 'PK', 'int unsigned', 'int' ) ), IF( mf.`metadatafield_typelength` IS NOT NULL, CONCAT( LOWER(mf.`metadatafield_type`), '(', mf.`metadatafield_typelength`, ')' ), LOWER(mf.`metadatafield_type`) ) ) ) AS 'COLUMN_TYPE', LOWER(mf.`metadatafield_type`) AS 'DATA_TYPE', IF(mf.`metadatafield_nullable`, 'YES', 'NO') AS 'IS_NULLABLE', NULL AS 'COLUMN_DEFAULT', mf.`metadatafield_typelength` AS 'CHARACTER_MAXIMUM_LENGTH', NULL AS 'NUMERIC_PRECISION', NULL AS 'NUMERIC_SCALE', NULL AS 'EXTRA' FROM metadata_field mf INNER JOIN metadata m ON mf.`metadatafield_metadata` = m.`metadata_id` WHERE m.`metadata_model` REGEXP '" + table + "_ext[0-9]+' OR m.`metadata_model` = '" + table + "' AND m.`metadata_datasource` = 2 AND mf.`metadatafield_deleted` = 0 GROUP BY mf.`metadatafield_field` ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC" }
        // let result = { "status": true, "action": "query", "data": "SELECT ROW_NUMBER() OVER ( ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC ) AS 'ORDINAL_POSITION', mf.`metadatafield_field` AS 'COLUMN_NAME', '' AS 'COLUMN_COMMENT', IF( mf.`metadatafield_typelength` IS NOT NULL, CONCAT( LOWER(mf.`metadatafield_type`), '(', mf.`metadatafield_typelength`, ')' ), IF( mf.`metadatafield_unsigned` = 1, CONCAT( LOWER(mf.`metadatafield_type`), ' unsigned' ), LOWER(mf.`metadatafield_type`) ) ) AS 'COLUMN_TYPE', LOWER(mf.`metadatafield_type`) AS 'DATA_TYPE', IF(mf.`metadatafield_nullable`, 'YES', 'NO') AS 'IS_NULLABLE', NULL AS 'COLUMN_DEFAULT', mf.`metadatafield_typelength` AS 'CHARACTER_MAXIMUM_LENGTH', NULL AS 'NUMERIC_PRECISION', NULL AS 'NUMERIC_SCALE', NULL AS 'EXTRA' FROM metadata_field mf INNER JOIN metadata m ON mf.`metadatafield_metadata` = m.`metadata_id` WHERE m.`metadata_model` REGEXP '" + table + "_ext[0-9]+' OR m.`metadata_model` = '" + table + "' AND m.`metadata_datasource` = 2 AND mf.`metadatafield_deleted` = 0 GROUP BY mf.`metadatafield_field` ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC" }
        // let result = { "status": true, "action": "query", "data": "SELECT ROW_NUMBER() OVER ( ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC ) AS 'ORDINAL_POSITION', mf.`metadatafield_field` AS 'COLUMN_NAME', '' AS 'COLUMN_COMMENT', IF( mf.`metadatafield_unsigned` = 1, CONCAT(LOWER(mf.`metadatafield_platformtype`), ' unsigned'), LOWER(mf.`metadatafield_platformtype`) ) AS 'COLUMN_TYPE', LOWER(mf.`metadatafield_platformtype`) AS 'DATA_TYPE', IF(mf.`metadatafield_nullable`, 'YES', 'NO') AS 'IS_NULLABLE', NULL AS 'COLUMN_DEFAULT', mf.`metadatafield_typelength` AS 'CHARACTER_MAXIMUM_LENGTH', NULL AS 'NUMERIC_PRECISION', NULL AS 'NUMERIC_SCALE', NULL AS 'EXTRA' FROM metadata_field mf INNER JOIN metadata m ON mf.`metadatafield_metadata` = m.`metadata_id` WHERE m.`metadata_model` REGEXP '" + table + "_ext[0-9]+' OR m.`metadata_model` = '" + table + "' AND m.`metadata_datasource` = 2 AND mf.`metadatafield_deleted` = 0 GROUP BY mf.`metadatafield_field` ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC" };
        //  FIX
        // let result = { "status": true, "action": "query", "data": "SELECT ROW_NUMBER() OVER ( ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC ) AS 'ORDINAL_POSITION', mf.`metadatafield_field` AS 'COLUMN_NAME', '' AS 'COLUMN_COMMENT', IF( mf.`metadatafield_typelength` IS NOT NULL, CONCAT( LOWER(mf.`metadatafield_type`), '(', mf.`metadatafield_typelength`, ')' ), IF( mf.`metadatafield_unsigned` = 1, CONCAT(LOWER(mf.`metadatafield_type`), ' unsigned'), LOWER(mf.`metadatafield_type`) ) ) AS 'COLUMN_TYPE', LOWER(mf.`metadatafield_type`) AS 'DATA_TYPE', IF(mf.`metadatafield_nullable`, 'YES', 'NO') AS 'IS_NULLABLE', NULL AS 'COLUMN_DEFAULT', mf.`metadatafield_typelength` AS 'CHARACTER_MAXIMUM_LENGTH', NULL AS 'NUMERIC_PRECISION', NULL AS 'NUMERIC_SCALE', NULL AS 'EXTRA' FROM metadata_field mf INNER JOIN metadata m ON mf.`metadatafield_metadata` = m.`metadata_id` WHERE m.`metadata_model` REGEXP '" + table + "_ext[0-9]+' OR m.`metadata_model` = '" + table + "' AND m.`metadata_datasource` = 2 AND mf.`metadatafield_deleted` = 0 GROUP BY mf.`metadatafield_field` ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC" };
        // let result = { "status": true, "action": "query", "data": "SELECT ROW_NUMBER() OVER ( ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC ) AS 'ORDINAL_POSITION', mf.`metadatafield_field` AS 'COLUMN_NAME', '' AS 'COLUMN_COMMENT', IF( mf.`metadatafield_typelength` IS NOT NULL, CONCAT( LOWER(mf.`metadatafield_platformtype`), '(', mf.`metadatafield_typelength`, ')' ), IF( mf.`metadatafield_unsigned` = 1, CONCAT(LOWER(mf.`metadatafield_platformtype`), ' unsigned'), LOWER(mf.`metadatafield_platformtype`) ) ) AS 'COLUMN_TYPE', LOWER(mf.`metadatafield_platformtype`) AS 'DATA_TYPE', IF(mf.`metadatafield_nullable`, 'YES', 'NO') AS 'IS_NULLABLE', NULL AS 'COLUMN_DEFAULT', mf.`metadatafield_typelength` AS 'CHARACTER_MAXIMUM_LENGTH', NULL AS 'NUMERIC_PRECISION', NULL AS 'NUMERIC_SCALE', NULL AS 'EXTRA' FROM metadata_field mf INNER JOIN metadata m ON mf.`metadatafield_metadata` = m.`metadata_id` WHERE m.`metadata_model` REGEXP '" + table + "_ext[0-9]+' OR m.`metadata_model` = '" + table + "' AND m.`metadata_datasource` = 2 AND mf.`metadatafield_deleted` = 0 GROUP BY mf.`metadatafield_field` ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC" };
        // Da Real Fix 1.0
        // let result = { "status": true, "action": "query", "data": "SELECT ROW_NUMBER() OVER ( ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC ) AS 'ORDINAL_POSITION', mf.`metadatafield_field` AS 'COLUMN_NAME', '' AS 'COLUMN_COMMENT', IF( mf.`metadatafield_typelength` IS NOT NULL, CONCAT( LOWER(mf.`metadatafield_origintype`), '(', mf.`metadatafield_typelength`, ')' ), IF( mf.`metadatafield_unsigned` = 1, CONCAT(LOWER(mf.`metadatafield_origintype`), ' unsigned'), LOWER(mf.`metadatafield_origintype`) ) ) AS 'COLUMN_TYPE', LOWER(mf.`metadatafield_origintype`) AS 'DATA_TYPE', IF(mf.`metadatafield_nullable`, 'YES', 'NO') AS 'IS_NULLABLE', NULL AS 'COLUMN_DEFAULT', mf.`metadatafield_typelength` AS 'CHARACTER_MAXIMUM_LENGTH', NULL AS 'NUMERIC_PRECISION', NULL AS 'NUMERIC_SCALE', NULL AS 'EXTRA' FROM metadata_field mf INNER JOIN metadata m ON mf.`metadatafield_metadata` = m.`metadata_id` WHERE m.`metadata_model` REGEXP '" + table + "_ext[0-9]+' OR m.`metadata_model` = '" + table + "' AND m.`metadata_datasource` = 2 AND mf.`metadatafield_deleted` = 0 GROUP BY mf.`metadatafield_field` ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC" };
        //
        // Semoga Da Real Fix 2.0
        let result = { "status": true, "action": "query", "data": "SELECT ROW_NUMBER() OVER ( ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC ) AS 'ORDINAL_POSITION', mf.`metadatafield_field` AS 'COLUMN_NAME', '' AS 'COLUMN_COMMENT', IF( mf.`metadatafield_typelength` IS NOT NULL, CONCAT( LOWER(mf.`metadatafield_origintype`), '(', mf.`metadatafield_typelength`, ')' ), IF( mf.`metadatafield_unsigned` = 1, CONCAT(LOWER(mf.`metadatafield_origintype`), ' unsigned'), LOWER(mf.`metadatafield_origintype`) ) ) AS 'COLUMN_TYPE', LOWER(mf.`metadatafield_origintype`) AS 'DATA_TYPE', IF(mf.`metadatafield_nullable`, 'YES', 'NO') AS 'IS_NULLABLE', NULL AS 'COLUMN_DEFAULT', mf.`metadatafield_typelength` AS 'CHARACTER_MAXIMUM_LENGTH', NULL AS 'NUMERIC_PRECISION', NULL AS 'NUMERIC_SCALE', NULL AS 'EXTRA' FROM metadata_field mf INNER JOIN metadata m ON mf.`metadatafield_metadata` = m.`metadata_id` WHERE ( m.`metadata_model` REGEXP '" + table + "_ext[0-9]+' OR m.`metadata_model` = '" + table + "' ) AND m.`metadata_datasource` = 2 AND mf.`metadatafield_deleted` = 0 AND mf.`metadatafield_origintype` IS NOT NULL GROUP BY mf.`metadatafield_field` ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC" };
        //////
        // let result = { "status": true, "action": "query", "data": "SELECT ROW_NUMBER() OVER ( ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC ) AS 'ORDINAL_POSITION', mf.`metadatafield_field` AS 'COLUMN_NAME', '' AS 'COLUMN_COMMENT', IF( mf.`metadatafield_typelength` IS NOT NULL, CONCAT( LOWER(mf.`metadatafield_origintype`), '(', mf.`metadatafield_typelength`, ')' ), IF( mf.`metadatafield_unsigned` = 1, CONCAT(LOWER(mf.`metadatafield_origintype`), ' unsigned'), LOWER(mf.`metadatafield_origintype`) ) ) AS 'COLUMN_TYPE', LOWER(mf.`metadatafield_origintype`) AS 'DATA_TYPE', IF(mf.`metadatafield_nullable`, 'YES', 'NO') AS 'IS_NULLABLE', NULL AS 'COLUMN_DEFAULT', mf.`metadatafield_typelength` AS 'CHARACTER_MAXIMUM_LENGTH', NULL AS 'NUMERIC_PRECISION', NULL AS 'NUMERIC_SCALE', NULL AS 'EXTRA' FROM metadata_field mf INNER JOIN metadata m ON mf.`metadatafield_metadata` = m.`metadata_id` WHERE m.`metadata_model` = '" + table + "' AND m.`metadata_datasource` = 2 AND mf.`metadatafield_deleted` = 0 GROUP BY mf.`metadatafield_field` ORDER BY m.`metadata_model`, mf.`metadatafield_order` ASC" };
        return result;
    }
    dualOne() {
        let result = { "status": true, "action": "query", "data": "select 1 as `one` from dual" };
        return result;
    }
    showWarnings() {
        let result = { "status": true, "action": "query", "data": "SHOW WARNINGS" };
        return result;
    }
}
exports.default = Reserved;
