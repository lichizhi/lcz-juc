package com.lcz.study.juc;

import com.lcz.study.help.SleepHelper;

public class T000_ThreadLocal {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() -> {
            SleepHelper.sleepSeconds(2);
            System.out.println(threadLocal.get());
        }).start();

        new Thread(() -> {
            SleepHelper.sleepSeconds(1);
            threadLocal.set("hello");
        }).start();
    }
}
