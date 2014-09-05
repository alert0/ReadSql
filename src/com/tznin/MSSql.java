package com.tznin;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.apache.commons.lang3.StringUtils.contains;

/**
 * Created by zxmoa on 14-9-5.
 */
public class MSSql extends   BaseSql {

    //转换数据
    public void sql2data()  {
        try {
            if(this.getFile() != null) {
                BufferedReader reader = new BufferedReader(new FileReader(this.getFile()) );
                String line = "";
                Boolean start = false;
                SqlData data = new SqlData();
                while ( (line = reader.readLine())  !=null ) {
                    //System.out.println(line + contains(line, "CREATE") );
                    if(line.contains("CREATE TABLE")) {
                        start = true;
                        String tableName = StringUtils.substringBetween(line,".[","]");
                        System.out.println(line);
                        data = new SqlData();
                        data.setTableName(tableName.toLowerCase());
                        System.out.println("******表开始*****"+ tableName);
                    }
                    else if(start && line.contains(") ON") ) {
                        start = false;
                        System.out.println(line);
                        System.out.println("*******结束表**************");
                        this.addData(data);

                    } else

                    if(start) {
                        String filed = StringUtils.substringBetween(line,"[","]");
                        data.addFiled(filed.toLowerCase());
                        System.out.println("========"+filed);

                    }


                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static  void main(String[] na) {
        MSSql ms = new MSSql();
        ms.load("/Users/zxmoa/Documents/workspace/mssql.sql");
        ms.sql2data();
        System.out.println( ms.getDatas() );
    }
}
