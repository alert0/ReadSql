package com.tznin;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zxmoa on 14-9-5.
 */

class  FiledComparator implements Comparator {

    @Override
    public int compare(Object o, Object o2) {
        String d1 = (String)o;
        String d2 = (String)o2;

        return  d1.compareTo(d2);
    }
}

public class SqlData {

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String tableName) {
        TableName = tableName;
    }

    private  String TableName;

    public List<String> getFileds() {
        return fileds;
    }

    public void setFileds(List<String> fileds) {
        this.fileds = fileds;
    }

    public void addFiled(String filed) {
        this.fileds.add(filed);
    }

    @Override
    public boolean equals(Object obj) {
       if(obj instanceof SqlData) {
          return  this.toString().equalsIgnoreCase( ((SqlData) obj).toString()) ;
       }
       return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    private List<String> fileds = new ArrayList<String>();



    @Override
    public String toString() {

        //sort filed data
        FiledComparator filedComparator = new FiledComparator();
        Collections.sort(this.fileds ,filedComparator);

        return "SqlData{" +
                "TableName='" + TableName + '\'' +
                ", fileds=" + fileds +
                '}' + "\r\n";
    }

}
