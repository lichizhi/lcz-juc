package com.lcz.study.juc.interrupt;

import com.lcz.study.help.SleepHelper;

public class T003_InterruptSleep {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                //
                System.out.println("Thread is interrupted");
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });

        t.start();

        SleepHelper.sleepSeconds(2);
        t.interrupt();
    }

}
