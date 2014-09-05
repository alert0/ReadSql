package com.tznin;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zxmoa on 14-9-5.
 */
public class BaseSql implements  SqltoSql {

    public File getFile() {
        return file;
    }

    private File file ;

    public List<SqlData> getDatas() {

        Comparatordate comparatordate = new Comparatordate();
        Collections.sort(this.datas ,comparatordate);
        return datas;
    }

    public void setDatas(List<SqlData> datas) {
        this.datas = datas;
    }

    private List<SqlData> datas = new ArrayList<SqlData>();


   public void addData(SqlData data){
       datas.add(data);
   }



    //载入数据
    public void load(String filename) {
        file = new File(filename);
    }

    //转换数据
    public void sql2data(){

    }

    //保存数据ßß
    public void save(){

    }

    class  Comparatordate implements Comparator {

        @Override
        public int compare(Object o, Object o2) {
            SqlData d1 = (SqlData)o;
            SqlData d2 = (SqlData)o2;

            return  d1.getTableName().compareTo(d2.getTableName() );
        }
    }

}
