package com.lcz.study.juc.atomicity;

public class T000_Test {

    static int a = 0;

    public static void main(String[] args) {
        synchronized (T000_Test.class) {
            a++;
        }
    }
}
