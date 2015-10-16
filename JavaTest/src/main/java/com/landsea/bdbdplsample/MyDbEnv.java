package com.landsea.bdbdplsample;

import com.sleepycat.db.DatabaseException;
import com.sleepycat.db.Environment;
import com.sleepycat.db.EnvironmentConfig;
import com.sleepycat.persist.EntityStore;
import com.sleepycat.persist.StoreConfig;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by SDL on 2015/9/17.
 */
public class MyDbEnv {
    private Environment myEnv;
    private EntityStore store;

    // Our constructor does nothing
    public MyDbEnv() {
    }

    // The setup() method opens the environment and store
    // for us.
    public void setup(File envHome, boolean readOnly)
            throws DatabaseException {

        EnvironmentConfig myEnvConfig = new EnvironmentConfig();
        StoreConfig storeConfig = new StoreConfig();

//        myEnvConfig.setReadOnly(readOnly);
        storeConfig.setReadOnly(readOnly);

        // If the environment is opened for write, then we want to be
        // able to create the environment and entity store if
        // they do not exist.
//        myEnvConfig.setInitializeCache(true);
        myEnvConfig.setAllowCreate(!readOnly);
        storeConfig.setAllowCreate(!readOnly);

        try {
            // Open the environment and entity store
            myEnv = new Environment(envHome, myEnvConfig);
            store = new EntityStore(myEnv, "EntityStore", storeConfig);
        } catch (FileNotFoundException fnfe) {
            System.err.println("setup(): " + fnfe.toString());
            System.exit(-1);
        }
    }

    // Return a handle to the entity store
    public EntityStore getEntityStore() {
        return store;
    }

    // Return a handle to the environment
    public Environment getEnv() {
        return myEnv;
    }

    // Close the store and environment.
    public void close() {
        if (store != null) {
            try {
                store.close();
            } catch (DatabaseException dbe) {
                System.err.println("Error closing store: " +
                        dbe.toString());
                System.exit(-1);
            }
        }

        if (myEnv != null) {
            try {
                // Finally, close the environment.
                myEnv.close();
            } catch (DatabaseException dbe) {
                System.err.println("Error closing MyDbEnv: " +
                        dbe.toString());
                System.exit(-1);
            }
        }
    }
}
