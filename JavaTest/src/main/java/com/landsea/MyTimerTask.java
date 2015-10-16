package com.landsea;

import java.sql.Time;
import java.util.TimerTask;

/**
 * Created by SDL on 2015/9/10.
 */
public class MyTimerTask extends TimerTask {

    private String str = "My Timer.";

    public MyTimerTask(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        System.out.println(str + "Timer thread is running...");
    }
}
