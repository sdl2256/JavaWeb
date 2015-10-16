package com.landsea.mybdb;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.bind.tuple.TupleBinding;
import com.sleepycat.db.*;

/**
 * Created by SDL on 2015/9/18.
 */
public class MyDatabaseRead {

    private static String myDbsPath = "F:\\JavaWebTest\\JavaTest\\src\\main\\java\\com\\landsea\\mybdb";

    // Encapsulates the database environment and databases.
    private static MyDbs myDbs = new MyDbs();

    private static EntryBinding vendorBinding;

    public static void main(String args[]) {
        MyDatabaseRead edr = new MyDatabaseRead();
        try {
            edr.run(args);
        } catch (DatabaseException dbe) {
            System.err.println("ExampleDatabaseRead: " + dbe.toString());
            dbe.printStackTrace();
        } finally {
            myDbs.close();
        }
        System.out.println("All done.");
    }


    private void run(String args[])
            throws DatabaseException {

        myDbs.setup(myDbsPath);

        // Setup our bindings.
        vendorBinding = new SerialBinding(myDbs.getClassCatalog(),
                Vendor.class);

        showVendors();
    }

    private void showVendors() throws DatabaseException {
        // Get a cursor
        Cursor cursor = myDbs.getVendorDB().openCursor(null, null);

        // DatabaseEntry objects used for reading records
        DatabaseEntry foundKey = new DatabaseEntry();
        DatabaseEntry foundData = new DatabaseEntry();

        try { // always want to make sure the cursor gets closed
            while (cursor.getNext(foundKey, foundData,
                    LockMode.DEFAULT) == OperationStatus.SUCCESS) {
                Vendor theVendor =
                        (Vendor) vendorBinding.entryToObject(foundData);
                System.out.println(theVendor);
            }
        } catch (Exception e) {
            System.err.println("Error on inventory cursor:");
            System.err.println(e.toString());
            e.printStackTrace();
        } finally {
            cursor.close();
        }
    }
}
