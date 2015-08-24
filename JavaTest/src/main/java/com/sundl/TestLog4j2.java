package com.sundl;

//import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SDL on 2015/7/28.
 */
public class TestLog4j2 {

//    private static Logger logger = Logger.getLogger("HelloWorld");

    public static void main(String[] args) {
//
//        TestLog4j2.logger.info("hello,world");
//        TestLog4j2.logger.error("There is a error here");


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat df2 = new SimpleDateFormat("y-M-d H:ma:s");

        String time = df.format(new Date());
        String time2 = df2.format(new Date());

        System.out.println(time);
        System.out.println(time2);

        String nu = null;
        String s = nu + "1";
        System.out.println("s==============" + s);
    }
}
