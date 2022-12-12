package com.lcz.study.juc.lock;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class T001_LongAdder {

    private static final LongAdder adder = new LongAdder();
    private static final AtomicLong atomicLong = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[2000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    adder.increment();
                }
            });
        }

        long start = System.currentTimeMillis();

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("LongAdder " + adder.longValue() + " time " + (System.currentTimeMillis() - start));

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
                    atomicLong.incrementAndGet();
                }
            });
        }

        start = System.currentTimeMillis();

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("AtomicLong " + atomicLong.get() + " time " + (System.currentTimeMillis() - start));
    }
}
