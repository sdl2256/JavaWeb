package com.landsea;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by SDL on 2015/9/10.
 */
public class MainThreadTest {
    public static void main(String[] args) {
        String str = "I am SDL";
        Timer timer = new Timer();
        MyTimerTask myTimerTask = new MyTimerTask(str);
        timer.schedule(myTimerTask, 5000, 5000);

        System.out.println("Main thread ends!");
    }
}
