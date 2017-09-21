package com.tznin;

import org.apache.commons.lang3.StringUtils;
import sun.tools.jar.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

/**
 * Created by zxmoa on 14-9-5.
 */
public class OraSql extends   BaseSql {

    //转换数据
    public void sql2data()  {
        try {
            if(this.getFile() != null) {
                BufferedReader reader = new BufferedReader(new FileReader(this.getFile()) );
                String line = "";
                Boolean start = false;
                SqlData data = new SqlData();
                while ( (line = reader.readLine())  !=null ) {
                    //System.out.println(line + line.contains("CREATE") );
                    if(line.contains("CREATE TABLE") ) {
                           start = true;
                   //        String tableName = StringUtils.substringBetween(line,".\"","\"");

                        String tableName = StringUtils.substringAfterLast(line,".").trim();

                           //System.out.println(line);
                        data = new SqlData();
                        data.setTableName(tableName.toLowerCase());
                        System.out.println("******表开始*****"+ tableName);
                    }
                    else if(start && line.equalsIgnoreCase(")") ) {
                        start = false;
                        System.out.println("*******结束表**************");
                        this.addData(data);

                    } else

                    if(start) {
                       // String filed = StringUtils.substringBetween(line,"\"","\"");
                        String[] lines = StringUtils.split(line," ");

                        String filed = lines[0].trim();

                        data.addFiled(filed.toLowerCase() );
                        System.out.println("========"+filed.toLowerCase());

                    }


                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static  void main(String[] na) {
        OraSql ora = new OraSql();
        ora.load("wwww.sql");
        ora.sql2data();
        System.out.println( ora.getDatas() );

    }

}
