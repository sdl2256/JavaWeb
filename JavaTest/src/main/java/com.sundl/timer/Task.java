package com.sundl.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by SDL on 2015/8/6.
 */
public class Task extends TimerTask {

    int index = 0;

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(++index + "--Thread " + this.scheduledExecutionTime());
                Thread.sleep(999);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();

        Task task = new Task();

        timer.schedule(task, 1000, 1000);
    }
}
