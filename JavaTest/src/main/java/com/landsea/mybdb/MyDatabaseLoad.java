package com.landsea.mybdb;

import com.landsea.GettingStarted.*;
import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.db.DatabaseEntry;
import com.sleepycat.db.DatabaseException;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by SDL on 2015/9/18.
 */
public class MyDatabaseLoad {
    private static String myDbsPath = "F:\\JavaWebTest\\JavaTest\\src\\main\\java\\com\\landsea\\mybdb";

    // DatabaseEntries used for loading records
    private static DatabaseEntry theKey = new DatabaseEntry();
    private static DatabaseEntry theData = new DatabaseEntry();

    // Encapsulates the databases.
    private static MyDbs myDbs = new MyDbs();

    public static void main(String args[]) {
        MyDatabaseLoad edl = new MyDatabaseLoad();
        try {
            edl.run(args);
        } catch (DatabaseException dbe) {
            System.err.println("ExampleDatabaseLoad: " + dbe.toString());
            dbe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
            e.printStackTrace();
        } finally {
            myDbs.close();
        }
        System.out.println("All done.");
    }

    private void run(String args[])
            throws DatabaseException {

        myDbs.setup(myDbsPath);

        System.out.println("loading vendors db....");
        loadVendorsDb();

    }


    private void loadVendorsDb()
            throws DatabaseException {

        // Now load the data into the database. The vendor's name is the
        // key, and the data is a Vendor class object.

        // Need a serial binding for the data
        EntryBinding dataBinding =
                new SerialBinding(myDbs.getClassCatalog(), Vendor.class);

        for (int i = 0; i < 10; i++) {
            Vendor theVendor = new Vendor("苹果" + i);
            theVendor.setRepPhoneNumber(i + "" + i + "" + i + "" + i + "" + i);

            // The key is the vendor's name.
            // ASSUMES THE VENDOR'S NAME IS UNIQUE!
            String vendorName = theVendor.getVendorName();
            try {
                theKey = new DatabaseEntry(vendorName.getBytes("UTF-8"));
            } catch (IOException willNeverOccur) {
            }

            // Convert the Vendor object to a DatabaseEntry object
            // using our SerialBinding
            dataBinding.objectToEntry(theVendor, theData);

            // Put it in the database.
            myDbs.getVendorDB().put(null, theKey, theData);
        }
    }
}
