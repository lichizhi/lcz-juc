package com.lcz.study.juc.end;

import com.lcz.study.help.SleepHelper;

public class T001_EndInterrupted {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (!Thread.interrupted()) {
                // sleep  wait
                System.out.println("go on");
            }
            System.out.println("t1 end");
        });

        t.start();

        SleepHelper.sleepSeconds(1);
        t.interrupt();
    }

}
