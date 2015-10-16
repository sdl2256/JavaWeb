package com.landsea.berkeleydb;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.db.*;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by SDL on 2015/9/16.
 */
public class MainTest {
    private Database aisdb;
    private Database aisClassDb;

    protected StoredClassCatalog classCatalog;
    protected Transaction tx;

    private Environment myDbEnvironment;
    protected EntryBinding dataBindingAIS;

    public MainTest() {
        init();
        try {
            classCatalog = new StoredClassCatalog(this.aisClassDb);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        //   Create the binding
        dataBindingAIS = new SerialBinding(classCatalog, Student.class);
    }

    public static void main(String[] args) {

        MainTest mainTest = new MainTest();

//        for (int i = 0; i < 10000; i++) {
//
//            Student student = new Student();
//            student.setId(i);
//            student.setName("奥迪" + i);
//            student.setAge(100 + i);
//            student.setBirthday(new Date());
//            mainTest.doPut(student);
//        }

        Student 奥迪 = (Student) mainTest.doGet("奥迪1");
        Student 奥迪99 = (Student) mainTest.doGet("奥迪99");

        System.out.println(奥迪);
        System.out.println(奥迪99);


    }

    public void init() {

        String dir = "F:/tempdir";

        try

        {
            File outfile = new File(dir);

            //如果文件夹不存在，则创建一个新文件夹
            if (!outfile.exists()) {
                outfile.mkdir();
            } else {
                File[] files = outfile.listFiles();
                for (File file : files) {
//                    file.delete();
                }
            }

            System.out.println("数据库环境 " + dir);

            EnvironmentConfig envConfig = new EnvironmentConfig();
            envConfig.setAllowCreate(true);
            envConfig.setTransactional(true);

            myDbEnvironment = new Environment(outfile, envConfig);
            if (myDbEnvironment != null) {
//                myDbEnvironment.cleanLog();
            }

            //   txn = myDbEnvironment.beginTransaction(null, null);
            DatabaseConfig dbConfig = new DatabaseConfig();
            dbConfig.setAllowCreate(true);
            dbConfig.setCacheSize(256000);
            dbConfig.setType(DatabaseType.BTREE);
//            dbConfig.setTransactional(false);
            aisdb = new Database(dir + "/" + "aisDb" + ".db", "aisDb" + ".db", dbConfig);

            aisClassDb = new Database(dir + "/" + "aisClassDb" + ".db", "aisClassDb" + ".db", dbConfig);
//            deletedRecords(aisdb);
//            deletedRecords(aisClassDb);


        } catch (
                Exception e
                )

        {
            e.printStackTrace();
        }
    }

    public void closeDbEnvironment() {
        try {
            if (myDbEnvironment != null) {
                myDbEnvironment.close();
            }
        } catch (DatabaseException dbe) {
            // Exception handling goes here
        }
    }


    public void deletedRecords(Database db) {
        Cursor cursor = null;
        try {
            cursor = db.openCursor(null, null);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        DatabaseEntry tkey = new DatabaseEntry();
        DatabaseEntry tdata = new DatabaseEntry();
        tdata.setPartial(true);
        tdata.setPartialLength(0);

        try {
            while (cursor.getNext(tkey, tdata, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
                db.delete(null, tkey);
            }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

//        myDbEnvironment.cleanLog();

        System.out.println("deleted records!");
    }

    public void doPut(Object dd) {

        Student student = (Student) dd;
        DatabaseEntry tkey = null;
        try {
            tkey = new DatabaseEntry(String.valueOf(student.getName()).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        DatabaseEntry tdata = new DatabaseEntry();
        dataBindingAIS.objectToEntry(student, tdata);
        try {
            aisdb.put(null, tkey, tdata);
//                tx.commit();

        } catch (Exception e) {
//               if (tx != null) {
//                   tx.abort();
//                }
        }
    }

    public Object doGet(String key) {

        DatabaseEntry tkey = null;
        try {
            tkey = new DatabaseEntry(key.getBytes("UTF-8"));
        } catch (Exception e) {

        }

        DatabaseEntry tdata = new DatabaseEntry();
        //   try
        try {
            if (aisdb.get(null, tkey, tdata, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
                Student student = (Student) dataBindingAIS.entryToObject(tdata);
                return student;
            }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
