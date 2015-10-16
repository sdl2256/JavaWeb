package com.landsea.mybdb;

import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.db.Database;
import com.sleepycat.db.DatabaseConfig;
import com.sleepycat.db.DatabaseException;
import com.sleepycat.db.DatabaseType;

import java.io.FileNotFoundException;

/**
 * Created by SDL on 2015/9/18.
 */
public class MyDbs {
    // The databases that our application uses
    private Database vendorDb = null;
    private Database classCatalogDb = null;
    // Needed for object serialization
    private StoredClassCatalog classCatalog;

    private String vendordb = "VendorDB.db";
    private String classcatalogdb = "ClassCatalogDB.db";

    // The setup() method opens all our databases for us.
    public void setup(String databasesHome)
            throws DatabaseException {
        DatabaseConfig myDbConfig = new DatabaseConfig();
        myDbConfig.setErrorStream(System.err);
        myDbConfig.setErrorPrefix("MyDbs");
        myDbConfig.setType(DatabaseType.BTREE);
        myDbConfig.setAllowCreate(true);
        // Now open, or create and open, our databases
        // Open the vendors and inventory databases
        try {
            vendordb = databasesHome + "/" + vendordb;
            vendorDb = new Database(vendordb,
                    null,
                    myDbConfig);
            // Open the class catalog db. This is used to
            // optimize class serialization.
            classcatalogdb = databasesHome + "/" + classcatalogdb;
            classCatalogDb = new Database(classcatalogdb,
                    null,
                    myDbConfig);
        } catch (FileNotFoundException fnfe) {
            System.err.println("MyDbs: " + fnfe.toString());
            System.exit(-1);
        }

        // Create our class catalog
        classCatalog = new StoredClassCatalog(classCatalogDb);

    }

    // getter methods
    public Database getVendorDB() {
        return vendorDb;
    }

    public StoredClassCatalog getClassCatalog() {
        return classCatalog;
    }

    // Close the databases
    public void close() {
        try {
            if (vendorDb != null) {
                vendorDb.close();
            }
            if (classCatalogDb != null) {
                classCatalogDb.close();
            }
        } catch (DatabaseException dbe) {
            System.err.println("Error closing MyDbs: " +
                    dbe.toString());
            System.exit(-1);
        }
    }
}
