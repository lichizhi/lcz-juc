package com.lcz.study.juc.interrupt;

import com.lcz.study.help.SleepHelper;

public class T001_Interrupt {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (;;) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is interrupted");
                    System.out.println(Thread.currentThread().isInterrupted());
                    break;
                }
            }
        });

        t.start();

        SleepHelper.sleepSeconds(1);
        t.interrupt();
    }

}
