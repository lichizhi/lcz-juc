package com.lcz.study.juc.atomicity;

import java.util.concurrent.CountDownLatch;

public class T001_PlusPlus {

    private static long n = 0L;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        CountDownLatch latch = new CountDownLatch(threads.length);

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    synchronized (T001_PlusPlus.class) {
                        n++;
                    }
                }
                latch.countDown();
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        latch.await();
        System.out.println(n);
    }
}
