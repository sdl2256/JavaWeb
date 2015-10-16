package com.landsea.bdb;

import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.db.*;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by SDL on 2015/9/17.
 */
public class SampleDatabase {
    private Environment env;
    private static final String CLASS_CATALOG = "java_class_catalog";
    private StoredClassCatalog javaCatalog;

    private static final String SUPPLIER_STORE = "supplier_store";
    private static final String PART_STORE = "part_store";
    private static final String SHIPMENT_STORE = "shipment_store";
    private Database supplierDb;
    private Database partDb;
    private Database shipmentDb;

    public SampleDatabase(String homeDirectory)
            throws DatabaseException, FileNotFoundException {
        System.out.println("Opening environment in: " + homeDirectory);

        EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setTransactional(true);
        envConfig.setAllowCreate(true);
        envConfig.setInitializeCache(true);
        envConfig.setInitializeLocking(true);

        env = new Environment(new File(homeDirectory), envConfig);

        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setTransactional(true);
        dbConfig.setAllowCreate(true);
        dbConfig.setType(DatabaseType.BTREE);

        Database catalogDb = env.openDatabase(null, CLASS_CATALOG, null, dbConfig);

        partDb = env.openDatabase(null, PART_STORE, null, dbConfig);
        supplierDb = env.openDatabase(null, SUPPLIER_STORE, null,
                dbConfig);
        shipmentDb = env.openDatabase(null, SHIPMENT_STORE, null,
                dbConfig);

        javaCatalog = new StoredClassCatalog(catalogDb);
    }

    public void close()
            throws DatabaseException {
        partDb.close();
        supplierDb.close();
        shipmentDb.close();
        javaCatalog.close();
        env.close();
    }

    public final Environment getEnvironment() {
        return env;
    }

    public final StoredClassCatalog getClassCatalog() {
        return javaCatalog;
    }

    public final Database getPartDatabase() {
        return partDb;
    }

    public final Database getSupplierDatabase() {
        return supplierDb;
    }

    public final Database getShipmentDatabase() {
        return shipmentDb;
    }
}
