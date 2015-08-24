package com.sundl;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by SDL on 2015/7/3.
 */
public class TestTime {
    private static final Logger log = Logger.getLogger(TestTime.class);

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse("2015-04-08 12:10:12");
            System.out.println(date.getTime());//1428466212000
            date = sdf.parse("2015-07-08 12:10:12");
            System.out.println(date.getTime());//1436328612000
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Date date = new Date(1296555205000L);//2011-02-01 18:13:25
        Date date2 = new Date(1496555205000L);//2017-06-04 13:46:45

        System.out.println(format.format(date));
        System.out.println(format.format(date2));

        Calendar c1 = Calendar.getInstance();
        c1.setTime(new Date());

        //当Calendar中设置的时间超过每项的最大值时,会以减去最大值后的值设置时间,例如月份设置13,最后会变成13-11=02
        Calendar c2 = Calendar.getInstance();
        c2.set(1920, 13, 24, 22, 32, 22);
        //使用pattern
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        SimpleDateFormat format2 = new SimpleDateFormat("yy-MM-dd H:m:s");
        SimpleDateFormat format3 = new SimpleDateFormat("y-M-d H:m:s");
        //使用约定格式
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());


        //获取Calendar中各个属性字段的方法
        log.info("The year now time is " + c1.get(c1.YEAR));
        log.info("The month now time is " + c1.get(c1.MONTH));
        log.info("The day_of_month now time is " + c1.get(c1.DAY_OF_MONTH));
        log.info("The day_of_week now time is " + c1.get(c1.DAY_OF_WEEK));
        log.info("今天是在这个月的第几个星期: " + c1.get(c1.DAY_OF_WEEK_IN_MONTH));
        log.info("The day_of_year now time is " + c1.get(c1.DAY_OF_YEAR));
        //不同模式对应的格式略有不同,有时间可以测试多一点模式
        log.info("yyyy-MM-dd H:m:s-->" + format1.format(c1.getTime()));
        log.info("yy-MM-dd H:m:s-->" + format2.format(c1.getTime()));
        log.info("y-M-d H:m:s-->" + format3.format(c1.getTime()));
        log.info("DateFormat.FULL-->" + dateFormat.format(c1.getTime()));

        log.info(format.format(c2.getTime()));
    }
}
