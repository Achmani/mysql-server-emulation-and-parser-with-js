package id.mit.chrono.server.main;

import id.mit.chrono.server.base.BaseMain;
import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrdatasourceRecord;
import id.mit.chrono.server.obj.DownloadGroup;
import id.mit.chrono.server.util.SystemUtils;
import org.apache.commons.lang3.StringUtils;
import org.jooq.Result;
import org.jooq.SelectConditionStep;

import static id.mit.chrono.server.model.Tables.CRDATASOURCE;

/**
 * chrono-collector
 * Copyright (c) 2021 - Mitra Informatika, PT
 * Created by chrono-collector Team (wildan) on 04/11/21 10.12
 * Surabaya, Indonesia
 */

public class AntennaMapper extends BaseMain {

 public static void main(String[] args) {
  new AntennaMapper(args);
 }

 public AntennaMapper(String[] args){

  logger.info("new instance initiated with param: " + StringUtils.join(args, " "));

  db = DatabaseHelper.connectDB();

  SystemUtils.logSystemInfo(logger);

  doMapping();
 }

 private void doMapping(){

  // routine
  // A. Update antenna_sectornumber
  // A.1. select where sector number is null?
  // A.2. select other antenna at same site, order by sectornumber ascending


  // B. Map rancell -> antenna

  SelectConditionStep select = db.selectFrom(CRDATASOURCE)
          .where(CRDATASOURCE.DATASOURCE_DATAGROUP.equal(context.getDATAGROUP_ID()))
          .and(CRDATASOURCE.DATASOURCE_ENABLED.isTrue());

  if(dataSources != null && dataSources.length > 0){
   select.and(CRDATASOURCE.DATASOURCE_NAME.in(dataSources));
  }

  Result<CrdatasourceRecord> result = select.fetch();


 }




}
