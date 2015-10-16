package com.landsea.berkeleydb;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.db.*;
import junit.framework.TestCase;

import java.io.File;
import java.util.List;

/**
 * Created by SDL on 2015/9/17.
 */
public class Jedtion extends TestCase {
    private static final String RESOURCE = ".//src//util//importData";
    private Environment env;

    private Database db, classDB;

    private StoredClassCatalog classCatalog;
    /**
     * 初始化，设置数据库的环境和创建数据库
     */
//    public void setUp() throws Exception {
//
//        env = new Environment(new File(".//src//util//importData"), null);
//        EnvironmentMutableConfig envMutableConfig = new EnvironmentMutableConfig();
//        envMutableConfig.setTxnNoSync(true);
//        env.setMutableConfig(envMutableConfig);
//
//        DatabaseConfig dbConfig = new DatabaseConfig();
//        dbConfig.setAllowCreate(true);
//        db = env.openDatabase(null, "myDB", dbConfig);
//        classDB = env.openDatabase(null, "classDB", dbConfig);
//        classCatalog = new StoredClassCatalog(classDB);
//    }
//    // test: put key-value
//    public void testPut(String key, Suppliers supp) throws Exception {
//        EntryBinding dataBinding = new SerialBinding(classCatalog,
//                Suppliers.class);
//        DatabaseEntry keyEntry = new DatabaseEntry(key.getBytes("UTF-8"));
//        DatabaseEntry dataEntry = new DatabaseEntry();
//        dataBinding.objectToEntry(supp, dataEntry);
//        db.put(null, keyEntry, dataEntry);
//    }
//    // test: get
//    public void testGet() throws Exception {
//        EnvironmentConfig envConfig = new EnvironmentConfig();
//        envConfig.setAllowCreate(true);
//        // envConfig.setReadOnly(true);
//        env = new Environment(new File(".//src//util//importData"), envConfig);
//        List myDbNames = env.getDatabaseNames();
//        System.out.println("Database size: " + myDbNames.size());
//        for (int i = 0; i < myDbNames.size(); i++) {
//            System.out.println("Database Name: " + (String) myDbNames.get(i));
//        }
//
//        DatabaseConfig dbConfig = new DatabaseConfig();
//        dbConfig.setAllowCreate(true);
//        // dbConfig.setReadOnly(true);
//        db = env.openDatabase(null, "myDB", dbConfig);
//        classDB = env.openDatabase(null, "classDB", dbConfig);
//        classCatalog = new StoredClassCatalog(classDB);
//
//        System.out.println("Db: " + db.count());
//
//        EntryBinding dataBinding = new SerialBinding(classCatalog,
//                Suppliers.class);
//
//        DatabaseEntry keyEntry = new DatabaseEntry("key".getBytes("UTF-8"));
//        DatabaseEntry dataEntry = new DatabaseEntry();
//        db.get(null, keyEntry, dataEntry, LockMode.DEFAULT);
//        Suppliers p = (Suppliers) dataBinding.entryToObject(dataEntry);
//        System.out.println(p.getCategory());
//    }
//
//    /**
//     * test: read database
//     * @throws Exception
//     */
//    public void testStore() throws Exception {
//
//        EnvironmentConfig envConfig = new EnvironmentConfig();
//        envConfig.setAllowCreate(true);
//        env = new Environment(new File(".//src//util//importData"), envConfig);
//
//        DatabaseConfig dbConfig = new DatabaseConfig();
//        dbConfig.setAllowCreate(true);
//        db = env.openDatabase(null, "myDB", dbConfig);
//        classDB = env.openDatabase(null, "classDB", dbConfig);
//        classCatalog = new StoredClassCatalog(classDB);
//
//        EntryBinding dataBinding = new SerialBinding(classCatalog,Suppliers.class);
//
//        Cursor cursor = null;
//        CursorConfig config = new CursorConfig();
//        config.setDirtyRead(true);
//        cursor = db.openCursor(null, config);       // open cursor
//
//        try {
//            // Database and environment open omitted for brevity
//            // Open the cursor. cursor = myDatabase.openCursor(null, null);
//            // Cursors need a pair of DatabaseEntry objects to operate. These hold
//            // the key and data found at any given position in the database.
//            DatabaseEntry foundKey = new DatabaseEntry();
//            DatabaseEntry foundData = new DatabaseEntry();
//            // To iterate, just call getNext() until the last database record has been
//            // read. All cursor operations return an OperationStatus, so just read
//            // until we no longer see OperationStatus.SUCCESS
//            while (cursor.getNext(foundKey, foundData, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
//                // getData() on the DatabaseEntry objects returns the byte array
//                // held by that object. We use this to get a String value. If the
//                // DatabaseEntry held a byte array representation of some other data
//                // type (such as a complex object) then this operation would look
//                // considerably different.
//                String keyString = new String(foundKey.getData());
//
//                Suppliers supp = (Suppliers)dataBinding.entryToObject(foundData);
//                System.out.println("Key - Data : " + keyString + " - "
//                        + supp.getCompanyName() + "");
//            }
//        } catch (DatabaseException de) {
//            System.err.println("Error accessing database." + de);
//        } finally {
//            // Cursors must be closed.
//            cursor.close();
//            db.close();
//            classDB.close();
//            env.cleanLog();
//            env.close();
//        }
//
//    }
//
//    public void tearDown() throws Exception {
//        db.close();
//        classDB.close();
//        env.cleanLog();
//        env.close();
//    }

    public static void main(String[] args) {
        Jedtion t = new Jedtion();
        try {
            // t.setUp();
            // Suppliers supp = new Suppliers();
            // supp.setCategory("fivefive");
            // t.testPut("5",supp);
            // t.testGet();
            // t.testStore();
            // t.tearDown();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
