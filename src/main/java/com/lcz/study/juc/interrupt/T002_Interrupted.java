package com.lcz.study.juc.interrupt;

import com.lcz.study.help.SleepHelper;

public class T002_Interrupted {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (;;) {
                if (Thread.interrupted()) {
                    System.out.println("Thread is interrupted");
                    System.out.println(Thread.interrupted());
                    break;
                }
            }
        });

        t.start();

        SleepHelper.sleepSeconds(2);
        t.interrupt();
    }

}
