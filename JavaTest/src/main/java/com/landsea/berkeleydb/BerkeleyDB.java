package com.landsea.berkeleydb;

import com.sleepycat.bind.ByteArrayBinding;
import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.db.*;

import java.io.UnsupportedEncodingException;

/**
 * Created by SDL on 2015/9/16.
 */
public class BerkeleyDB {
    private String path;
    protected Database db;
    protected Database classDb;

    protected StoredClassCatalog classCatalog;
    protected Transaction tx;

    private Environment myDbEnvironment;
    private EntryBinding dataBindingAIS;


    public BerkeleyDB(Database db, Database classDb, Transaction tx) {
        this.db = db;
        this.classDb = classDb;
        this.tx = tx;
        try {
            classCatalog = new StoredClassCatalog(this.classDb);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        //   Create the binding
        dataBindingAIS = new SerialBinding(classCatalog, Student.class);
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
            db.put(null, tkey, tdata);
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
        try {
            if (db.get(null, tkey, tdata, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
                Student student = (Student) dataBindingAIS.entryToObject(tdata);
                return student;
            }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        return null;
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
}
