package com.lcz.study.juc.interrupt;

import com.lcz.study.help.SleepHelper;

public class T004_InterruptSynchronized {

    private static final Object o = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (o) {
                SleepHelper.sleepSeconds(10);
            }
        });

        t1.start();
        SleepHelper.sleepSeconds(1);

        Thread t2 = new Thread(() -> {
            synchronized (o) {

            }
            System.out.println("t2 end");
        });

        t2.start();
        SleepHelper.sleepSeconds(1);

        // 不会打断t2，t2必须得等待t1释放锁后结束
        t2.interrupt();
    }
}
