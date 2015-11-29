package com.sundl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by SDL on 2015/11/27.
 */
public class TestLongTime {
    public static void main(String[] args) {

        //使用pattern
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yy-MM-dd H:m:s");
        SimpleDateFormat format3 = new SimpleDateFormat("y-M-d H:m:s");

        //使用约定格式
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());

        String time1 = "2015-11-26 17:00:00";
        String time2 = "2015-11-27 17:00:00";

        //1448528400000
        //1448614800000

        try {
            Date d1 = format1.parse(time1);
            Date d2 = format1.parse(time2);

            System.out.println(d1.getTime());
            System.out.println(d2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        String s = format1.format(new Date(1450117905000L));
//
//        System.out.println(s);
        System.out.println(new Date(1448528400000L));
        System.out.println(new Date(1448614800000L));
    }
}
