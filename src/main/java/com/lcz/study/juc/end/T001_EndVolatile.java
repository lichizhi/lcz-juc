package com.lcz.study.juc.end;

import com.lcz.study.help.SleepHelper;

public class T001_EndVolatile {

    private static volatile boolean running = true;

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            long i = 0L;
            while (running) {
                i++;
            }

            System.out.println("end and i = " + i);
        });

        t.start();

        SleepHelper.sleepSeconds(1);

        running = false;
    }

}
