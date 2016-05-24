package com.sundl.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by SDL on 2015/6/5.
 */
public class HelloWorldImpl implements IHelloWorld {

    public String sayHello(String username) {
        return "Hello " + username;
    }

    public Date getDateNow() {
        return new Date();
    }

    public Date getDate(Date date) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        cal.add(Calendar.DATE, +4);

        System.out.println(df.format(cal.getTime()));

        return cal.getTime();
    }

    public void setUser(String username) {

    }
}
