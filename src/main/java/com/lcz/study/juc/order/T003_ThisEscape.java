package com.lcz.study.juc.order;

import com.lcz.study.help.SleepHelper;

public class T003_ThisEscape {

    private final int num = 8;

    public T003_ThisEscape() {
       new Thread(() -> System.out.println(this.num)).start();
    }

    public static void main(String[] args) {
        new T003_ThisEscape();
        SleepHelper.sleepSeconds(1);
    }
}
