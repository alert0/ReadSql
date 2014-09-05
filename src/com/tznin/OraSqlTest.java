package com.tznin;


import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class OraSqlTest {

    public static  void main(String[] na) {
        OraSql ora = new OraSql();
        ora.load("/Users/zxmoa/Documents/workspace/TSTEST.sql");
        ora.sql2data();
        //System.out.println( ora.getDatas() );

        MSSql ms = new MSSql();
        ms.load("/Users/zxmoa/Documents/workspace/mssql.sql");
        ms.sql2data();
        //System.out.println( ms.getDatas() );

//        ora.getDatas().removeAll(ms.getDatas() );
//
//
//        System.out.println(ora.getDatas());


        ms.getDatas().removeAll(ora.getDatas() );


        System.out.println(ms.getDatas());

    }

//    ﻿[SqlData{TableName='cs_directory', fileds=[approved, approvedfield, colindex, createviewid, deleted, editviewid, extclass, extclass1, formid, id, logged, moduleid, objdesc, objname, objorder, pid, postscript, prescript, readviewid, replyed, reportid, rightextend, rightlist, rightset, rolelevel, saveandnew, titlefield, workflowid]}
//    , SqlData{TableName='cs_document', fileds=[content, createdate, createdatetime, createdept, createtime, createuserid, creator, deleted, directoryid, docabstract, docattach, docstatus, doctype, dowid, finished, gxdept, gxhuman, id, modifier, modifydate, modifydatetime, modifytime, modifyuserid, nodeid, objno, pid, processid, rowindex, subject, wdzz, xxly]}
//    , SqlData{TableName='cs_human', fileds=[account, bankaccounts, banknames, birthday, biyexuexiao, biyeyuanxiao, biyeyx, bodystatus, born, both, chushengdi, createdatetime, createuserid, dangan, daqu, degree, deleted, dianhua, dowid, duty, email, enddate, enname, entrydate, familyaddress, fax, fenbu, finished, gender, gradudate, hkszd, hrstatus, huji, hukou, hunfou, hystatus, id, identitys, jiangc, jiguan, jinsuotime, kaihuxing, khwd, language, lianxfs, lianxidz, lianxifs, lizhiriqi, lxrdh, lxrname, manager, mingz, minzu, modifydatetime, modifyuserid, msn, nianling, nodeid, oabh, objdesc, objname, objno, objorder, officeaddr, orgid, orgids, otherorg, otherpost, pdtime, photo, positivedate, postid, postids, posttype, processid, qitashuom, qq, quanrizhi, quyu, rowindex, rtxno, rudangtime, rzdate, school, seclevel, self, sfzh, shuxiang, source, specialty, specialty1, startdate, sumtxdays, tel1, tel2, tel3, tuixiuriqi, usetxdays, workaddr, worktime, worktype, xianzhuzhi, xingzuo, xueli, xuewei, ygstatus, youbian, yuandanwei, zaizhijy, zhaidian, zhanghao, zhengli, zhiji, zhuanyezc, zsldszdq, zsldzw, zyjs1, zyjs2]}
//    , SqlData{TableName='cs_topic', fileds=[attachs, canyuren, content, createdate, createdatetime, createtime, createuserid, creator, deleted, dowid, finished, gkfs, id, modifier, modifydate, modifydatetime, modifytime, modifyuserid, nodeid, processid, rowindex, stopreply, topic, types]}


}