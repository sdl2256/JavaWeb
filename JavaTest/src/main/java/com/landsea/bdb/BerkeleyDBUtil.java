package com.landsea.bdb;

import com.landsea.berkeleydb.Student;
import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.db.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDL on 2015/9/17.
 */
public class BerkeleyDBUtil {
    // 数据库环境
    private Environment env = null;

    // 数据库
    private static Database catalogDb = null;

    // 数据库名
    private static String dbName = "frontier_database";

    private StoredClassCatalog javaCatalog;

    protected EntryBinding dataBinding;

    private Transaction txn;

    public BerkeleyDBUtil(String homeDirectory) throws DatabaseException, FileNotFoundException {
        File outfile = new File(homeDirectory);

        //如果文件夹不存在，则创建一个新文件夹
        if (!outfile.exists()) {
            outfile.mkdir();
        } else {
            File[] files = outfile.listFiles();
            for (File file : files) {
                file.delete();
            }
        }
        // 1、创建EnvironmentConfig
        System.out.println("Opening environment in: " + homeDirectory);

        EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setTransactional(true);
        envConfig.setAllowCreate(true);
        envConfig.setInitializeCache(true);
        envConfig.setInitializeLocking(true);

        // 2、使用EnvironmentConfig配置Environment
        env = new Environment(new File(homeDirectory), envConfig);

        // 3、创建DatabaseConfig
        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setTransactional(true);
        dbConfig.setAllowCreate(true);
        dbConfig.setType(DatabaseType.BTREE);

        // 4、使用Environment与DatabaseConfig打开Database
        catalogDb = env.openDatabase(null, null, dbName, dbConfig);
        deletedRecords(catalogDb);


        javaCatalog = new StoredClassCatalog(catalogDb);
    }

    /*
     * 向数据库中写入记录，并判断是否可以有重复数据。 传入key和value
     * 若可以有重复数据，则直接使用put()即可，若不能有重复数据，则使用putNoOverwrite()。
     */
    public boolean writeToDatabase(String key, String obj, boolean isOverwrite) {
        try {
            // 设置key/value,注意DatabaseEntry内使用的是bytes数组
            DatabaseEntry theKey = new DatabaseEntry(key.getBytes("UTF-8"));
            DatabaseEntry theData = new DatabaseEntry(obj.getBytes("UTF-8"));

//            dataBinding = new SerialBinding(javaCatalog, obj.getClass());
//            dataBinding.objectToEntry(obj, theData);
            OperationStatus status = null;
            Transaction txn = null;

            // 1、Transaction配置
            TransactionConfig txConfig = new TransactionConfig();
            //txConfig.setSerializableIsolation(true);
            txn = env.beginTransaction(null, txConfig);
            // 2、写入数据
            if (isOverwrite) {
                status = catalogDb.put(txn, theKey, theData);
            } else {
                status = catalogDb.putNoOverwrite(txn, theKey, theData);
            }
            txn.commit();
            if (status == OperationStatus.SUCCESS) {
                System.out.println("向数据库" + dbName + "中写入:" + key + "," + obj);
                return true;
            } else if (status == OperationStatus.KEYEXIST) {
                System.out.println("向数据库" + dbName + "中写入:" + key + "," + obj + "失败,该值已经存在");
                return false;
            } else {
                System.out.println("向数据库" + dbName + "中写入:" + key + "," + obj + "失败");
                return false;
            }
        } catch (Exception e) {
            // 错误处理
            System.out.println("向数据库" + dbName + "中写入:" + key + "," + obj + "出现错误");

            return false;
        }
    }

    /*
     * 从数据库中读出数据 传入key 返回value
     */
    public Object readFromDatabase(String key) {
        try {
            DatabaseEntry theKey = new DatabaseEntry(key.getBytes("UTF-8"));
            DatabaseEntry theData = new DatabaseEntry();
//            Transaction txn = null;

            // 1、配置 Transaction相关信息
//            TransactionConfig txConfig = new TransactionConfig();
//                txConfig.setSerializableIsolation(true);
//            txn = env.beginTransaction(null, txConfig);
            // 2、读取数据
            OperationStatus status = catalogDb.get(null, theKey,
                    theData, LockMode.DEFAULT);
//            txn.commit();
            if (status == OperationStatus.SUCCESS) {
                String thedata = new String(theData.getData(), "UTF-8");
//
//                dataBinding = new SerialBinding(javaCatalog, Object.class);
//                Object obj = dataBinding.entryToObject(theData);
                System.out.println("从数据库" + dbName + "中读取:" + key + "," + thedata);
                return thedata;
            } else {
                System.out.println("No record found for key '" + key + "'.");
                return null;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        return null;

    }

    /*
     * 遍历数据库中的所有记录，返回list
     */
    public List getEveryItem() {
        // TODO Auto-generated method stub
        System.out.println("===========遍历数据库" + dbName + "中的所有数据==========");
        Cursor myCursor = null;
        List resultList = new ArrayList<>();
//        Transaction txn = null;
        try {
            // 1、Transaction配置
//            TransactionConfig txConfig = new TransactionConfig();
//            txn = this.env.beginTransaction(null, txConfig);
            CursorConfig cc = new CursorConfig();
            cc.setReadCommitted(true);
            myCursor = catalogDb.openCursor(null, null);
            DatabaseEntry foundKey = new DatabaseEntry();
            DatabaseEntry foundData = new DatabaseEntry();
            // 使用cursor.getPrev方法来遍历游标获取数据
//            if (myCursor.getFirst(foundKey, foundData, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
//                String theKey = new String(foundKey.getData(), "UTF-8");
////                dataBinding = new SerialBinding(javaCatalog, Object.class);
////                Object o = dataBinding.entryToObject(foundData);
////                resultList.add(o);
//                System.out.println("Key | Data : " + theKey + " |  + ");
            while (myCursor.getNext(foundKey, foundData, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
                String key = new String(foundKey.getData(), "UTF-8");
//                    resultList.add(obj);
                System.out.println("Key | Data : " + key);
            }
//            }
            myCursor.close();
            txn.commit();
            return resultList;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.out.println("getEveryItem处理出现异常");

            try {
//                txn.abort();
                if (myCursor != null) {
                    myCursor.close();
                }
            } catch (DatabaseException e1) {
                e1.printStackTrace();
            }
            return null;
        }
    }

    /*
     * 根据key值删除数据库中的一条记录
     */
    public boolean deleteFromDatabase(String key) {
        boolean success = false;
        long sleepMillis = 0;
        for (int i = 0; i < 3; i++) {
            if (sleepMillis != 0) {
                try {
                    Thread.sleep(sleepMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sleepMillis = 0;
            }
            Transaction txn = null;
            try {
                // 1、使用cursor.getPrev方法来遍历游标获取数据
                TransactionConfig txConfig = new TransactionConfig();
//                txConfig.setSerializableIsolation(true);
                txn = env.beginTransaction(null, txConfig);
                DatabaseEntry theKey;
                theKey = new DatabaseEntry(key.getBytes("UTF-8"));

                //2、删除数据 并提交
                OperationStatus res = catalogDb.delete(txn, theKey);
                txn.commit();
                if (res == OperationStatus.SUCCESS) {
                    System.out.println("从数据库" + dbName + "中删除:" + key);
                    success = true;
                    return success;
                } else if (res == OperationStatus.KEYEMPTY) {
                    System.out.println("没有从数据库" + dbName + "中找到:" + key + "。无法删除");
                } else {
                    System.out.println("删除操作失败，由于" + res.toString());
                }
                return false;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return false;
            } catch (DatabaseException e) {
                e.printStackTrace();
                return false;
            } finally {
                if (!success) {
                    if (txn != null) {
                        try {
                            txn.abort();
                        } catch (DatabaseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return false;
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

    public void closeDB() throws DatabaseException {
        if (catalogDb != null) {
            catalogDb.close();
        }
        if (env != null) {
            env.close();
        }
    }
}
