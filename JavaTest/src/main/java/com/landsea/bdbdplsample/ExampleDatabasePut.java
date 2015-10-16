package com.landsea.bdbdplsample;

import com.sleepycat.db.DatabaseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDL on 2015/9/17.
 */
public class ExampleDatabasePut {

    private static File myDbEnvPath = new File("F:\\bdb/tmp/JEDB");
    private static File inventoryFile = new File("F:\\bdb\\inventory.txt");
    private static File vendorsFile = new File("F:\\bdb/vendors.txt");

    private DataAccessor da;

    // Encapsulates the environment and data store.
    private static MyDbEnv myDbEnv = new MyDbEnv();

    private static void usage() {
        System.out.println("ExampleDatabasePut [-h <env directory>]");
        System.out.println("      [-i <inventory file>]");
        System.out.println("      [-v <vendors file>]");
        System.exit(-1);
    }

    private void loadVendorsDb()
            throws DatabaseException {

        // loadFile opens a flat-text file that contains our data
        // and loads it into a list for us to work with. The integer
        // parameter represents the number of fields expected in the
        // file.
        List vendors = loadFile(vendorsFile, 8);

        // Now load the data into the store.
        for (int i = 0; i < vendors.size(); i++) {
            String[] sArray = (String[]) vendors.get(i);
            Vendor theVendor = new Vendor();
            theVendor.setVendor(sArray[0]);
            theVendor.setAddress(sArray[1]);
            theVendor.setCity(sArray[2]);
            theVendor.setState(sArray[3]);
            theVendor.setZipcode(sArray[4]);
            theVendor.setBizPhoneNumber(sArray[5]);
            theVendor.setRepName(sArray[6]);
            theVendor.setRepPhoneNumber(sArray[7]);

            // Put it in the store.
            da.vendorByName.put(theVendor);
        }
    }

    private void loadInventoryDb()
            throws DatabaseException {

        // loadFile opens a flat-text file that contains our data
        // and loads it into a list for us to work with. The integer
        // parameter represents the number of fields expected in the
        // file.
        List inventoryArray = loadFile(inventoryFile, 6);

        // Now load the data into the store. The item's sku is the
        // key, and the data is an Inventory class object.

        for (int i = 0; i < inventoryArray.size(); i++) {
            String[] sArray = (String[]) inventoryArray.get(i);
            String sku = sArray[1];

            Inventory theInventory = new Inventory();
            theInventory.setItemName(sArray[0]);
            theInventory.setSku(sArray[1]);
            theInventory.setVendorPrice((new Float(sArray[2])).floatValue());
            theInventory.setVendorInventory((new Integer(sArray[3])).intValue());
            theInventory.setCategory(sArray[4]);
            theInventory.setVendor(sArray[5]);

            // Put it in the store. Note that this causes our secondary key
            // to be automatically updated for us.
            da.inventoryBySku.put(theInventory);
        }
    }

    private static void parseArgs(String args[]) {
        for (int i = 0; i < args.length; ++i) {
            if (args[i].startsWith("-")) {
                switch (args[i].charAt(1)) {
                    case 'h':
                        myDbEnvPath = new File(args[++i]);
                        break;
                    case 'i':
                        inventoryFile = new File(args[++i]);
                        break;
                    case 'v':
                        vendorsFile = new File(args[++i]);
                        break;
                    default:
                        usage();
                }
            }
        }
    }

    private List loadFile(File theFile, int numFields) {
        List<String[]> records = new ArrayList<String[]>();
        try {
            String theLine = null;
            FileInputStream fis = new FileInputStream(theFile);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(fis));
            while ((theLine = br.readLine()) != null) {
                String[] theLineArray = theLine.split("#");
                if (theLineArray.length != numFields) {
                    System.out.println("Malformed line found in " +
                            theFile.getPath());
                    System.out.println("Line was: '" + theLine);
                    System.out.println("length found was: " +
                            theLineArray.length);
                    System.exit(-1);
                }
                records.add(theLineArray);
            }
            // Close the input stream handle
            fis.close();
        } catch (FileNotFoundException e) {
            System.err.println(theFile.getPath() + " does not exist.");
            e.printStackTrace();
            usage();
        } catch (IOException e) {
            System.err.println("IO Exception: " + e.toString());
            e.printStackTrace();
            System.exit(-1);
        }
        return records;
    }

    protected ExampleDatabasePut() {
    }


    private void run(String args[]) throws DatabaseException {
        // Parse the arguments list
        parseArgs(args);

        myDbEnv.setup(myDbEnvPath,  // Path to the environment home
                false);       // Environment read-only?

        // Open the data accessor. This is used to store
        // persistent objects.
        da = new DataAccessor(myDbEnv.getEntityStore());

        System.out.println("loading vendors db....");
        loadVendorsDb();

        System.out.println("loading inventory db....");
        loadInventoryDb();
    }

    public static void main(String args[]) {
        ExampleDatabasePut edp = new ExampleDatabasePut();
        try {
            edp.run(args);
        } catch (DatabaseException dbe) {
            System.err.println("ExampleDatabasePut: " + dbe.toString());
            dbe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
            e.printStackTrace();
        } finally {
            myDbEnv.close();
        }
        System.out.println("All done.");
    }
}
