package com.alibaba.druid.postgresql;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.postgresql.parser.PGSQLStatementParser;
import junit.framework.TestCase;
import org.junit.Assert;

public class PGCaseTest extends TestCase  {

  public void testUpsert(){
    String sql = "select fphone, case fgender when '1' then '男' when '2' then '女' else '未知' end 'gender' from t_sec_user;";
    PGSQLStatementParser parser=new PGSQLStatementParser(sql);
    SQLStatement statement = parser.parseStatement();
    System.out.println(statement.toString());
  }

}