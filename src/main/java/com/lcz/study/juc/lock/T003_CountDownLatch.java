package com.lcz.study.juc.lock;

import java.util.concurrent.CountDownLatch;

public class T003_CountDownLatch {

    private static void usingCountDownLatch() {
        Thread[] threads = new Thread[100];
        CountDownLatch downLatch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                // 做一些事情
                for (int j = 0; j < 10000; j++) {

                }
                downLatch.countDown();
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end latch");
    }

    public static void main(String[] args) {
        usingCountDownLatch();
    }
}
