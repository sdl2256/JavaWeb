package com.landsea.bdb;

import com.sleepycat.db.DatabaseException;

import java.io.FileNotFoundException;

/**
 * Created by SDL on 2015/9/17.
 */
public class Sample {
    private SampleDatabase db;
    private SampleViews views;

    public static void main(String args)
    {
        System.out.println("\nRunning sample: " + Sample.class);
        String homeDir = "./tmp";
//        for (int i = 0; i < args.length; i += 1)
//        {
//            String arg = args[i];
//            if (args[i].equals("-h") && i < args.length - 1)
//            {
//                i += 1;
//                homeDir = args[i];
//            }
//            else
//            {
//                System.err.println("Usage:\n java " +
//                        Sample.class.getName() +
//                        "\n  [-h <home-directory>]");
//                System.exit(2);
//            }
//        }
    }

    private Sample(String homeDir)
            throws DatabaseException, FileNotFoundException
    {
    }

    private void close()
            throws DatabaseException
    {
    }

    private void run()
            throws Exception
    {
    }
}
