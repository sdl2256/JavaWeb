package com.landsea.date;

import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by SDL on 2015/9/14.
 */
public class TestDate {
    private static final Logger logger = Logger.getLogger(TestDate.class);

    public static void main(String[] args) {
        short month = 0, day = 0, hour = 24, minute = 60;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            String now = sdf.format(new Date());
            System.out.println(now);
//            now = null;
//            Date date = sdf.parse("01-14 16:58");
            Date date = sdf.parse(now);
            TimeZone chinaTimeZone = TimeZone.getTimeZone("Asia/Shanghai");
            Calendar cal = Calendar.getInstance(chinaTimeZone);
            cal.setTime(date);
            int mon = cal.get(Calendar.MONTH) + 1;//获取月份
            month = (short) mon;
            day = (short) cal.get(Calendar.DATE);//获取日
            hour = (short) cal.get(Calendar.HOUR_OF_DAY);//小时
            minute = (short) cal.get(Calendar.MINUTE);//分
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }

        System.out.println(month);
        System.out.println(day);
        System.out.println(hour);
        System.out.println(minute);

        System.out.println("***************");
        System.out.println(sdf.format(new Date(0, 0, 0)));
    }

}
