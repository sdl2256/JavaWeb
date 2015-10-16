package com.landsea.bdb;

import com.landsea.berkeleydb.Student;
import com.sleepycat.db.DatabaseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by SDL on 2015/9/17.
 */
public class TestDBUtil {
    public static void main(String[] args) throws DatabaseException, FileNotFoundException {
        BerkeleyDBUtil dbUtil = null;
        //如果文件夹不存在，则创建一个新文件夹
        String dir = "F:/tmp";
        dbUtil = new BerkeleyDBUtil(dir);
//        for (int i = 0; i < 10; i++) {
        int i = 5;
//        Student student = new Student();
//        student.setId(i);
//        student.setName("奥迪" + i);
//        student.setAge(100 + i);
//        student.setBirthday(new Date());

        String text = "Hello 两三点";
        dbUtil.writeToDatabase(text.substring(5), text, false);
//        }

        Student sdu = new Student();
        System.out.println();
        Student value = (Student) dbUtil.readFromDatabase("奥迪5");

        List item = dbUtil.getEveryItem();
//        System.out.println(item.size());

//        dbUtil.deleteFromDatabase("4");
//
//        item = dbUtil.getEveryItem();
//        System.out.println(item.size());

        dbUtil.closeDB();
    }
}
