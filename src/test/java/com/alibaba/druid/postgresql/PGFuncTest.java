package com.alibaba.druid.postgresql;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.postgresql.parser.PGSQLStatementParser;
import junit.framework.TestCase;

public class PGFuncTest extends TestCase  {

//  public void testUnion(){
//    String sql = "(select id,name from t1) union (select id,name from t2)";
//    String targetSql = "(SELECT id, name\n"
//        + "FROM t1)\n"
//        + "UNION\n"
//        + "(SELECT id, name\n"
//        + "FROM t2)";
//
//    PGSQLStatementParser pgparser=new PGSQLStatementParser(sql);
//    SQLStatement pgstatement = pgparser.parseStatement();
//    Assert.assertEquals(targetSql, pgstatement.toString());
//    System.out.println(pgstatement.toString());
//  }

  public void test1(){
    String sql = "SELECT DISTINCT A.fmaterialid \"materialid\", A.fstockid \"stockid\", A.fspid \"spid\", A.fauxpropid \"auxpropid\", A.fbatchno \"batchno\", A.fkfdate \"kfdate\", A.fkfperiod \"kfperiod\", A.fkftype \"kftype\", A.fvaliddate \"validdate\", CASE WHEN A.fvaliddate <> ' ' THEN (to_timestamp(A.fvaliddate,'YYYY-MM-DD') + '1 day') ELSE NULL END \"warndate\", CASE WHEN C.furl <> ' ' THEN C.furl ELSE B.furl END \"material_pic\", B.falarmday \"alarmday\", D.FBasedataId \"mullabel\"\n"
        + "FROM t_inv_inventory A\n"
        + "LEFT JOIN t_bd_materialaux C ON C.fentryid=A.fauxpropid\n"
        + "LEFT JOIN t_bd_material B ON B.FId=A.fmaterialid\n"
        + "LEFT JOIN t_bd_materiallabel D ON D.FId=B.FId\n"
        + "WHERE (A.fkftype in ('1','2','3') AND B.fenable = '1');";

    PGSQLStatementParser pgparser=new PGSQLStatementParser(sql);
    SQLStatement pgstatement = pgparser.parseStatement();
//    Assert.assertEquals(targetSql, pgstatement.toString());
    System.out.println(pgstatement.toString());
  }

}
