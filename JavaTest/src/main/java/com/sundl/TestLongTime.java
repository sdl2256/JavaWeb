package com.sundl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by SDL on 2015/11/27.
 */
public class TestLongTime {
    public static void main(String[] args) throws ParseException {

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

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone gmtTime = TimeZone.getTimeZone("UTC");

        TimeZone aDefault = TimeZone.getDefault();
        System.out.println(aDefault.getDisplayName());
        String timeZones[] = TimeZone.getAvailableIDs();
//        for (String timeZone : timeZones)
//            System.out.println(timeZone);

        sf.setTimeZone(gmtTime);
        try {
            Date dd = sf.parse(time2);
            System.out.println("Time2 string : " + time2);
            System.out.println("time2=" + sf.format(dd));
            System.out.println("time2=" + format1.format(dd));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date now = new Date();
        String utc = sf.format(now);

        String local = format1.format(now);



        Date parse = format1.parse(utc);
        System.out.println(now.getTime());
        System.out.println(parse.getTime());


        System.out.println(utc);
        System.out.println(local);

//        String s = format1.format(new Date(1450117905000L));
//
//        System.out.println(s);
        System.out.println(new Date(1449828249000L));
        System.out.println(new Date(2000000000000L));

        String t1 = "2015-11-27 17:00:00";
        String t2 = "2015-11-27 17:01:00";

        try {
            long minus = format1.parse(t2).getTime() - format1.parse(t1).getTime();
            System.out.println(minus);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TimeZone timezone = TimeZone.getDefault();

        // checking time zone value
        System.out.println("Time zone:" + timezone.getTimeZone("GMT-8:00").getDisplayName());
    }
}
