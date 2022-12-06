package com.lcz.study.juc.order;

import java.util.concurrent.CountDownLatch;

public class T001_Disorder {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            CountDownLatch latch = new CountDownLatch(2);
            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
                latch.countDown();
            });
            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
                latch.countDown();
            });

            t1.start();
            t2.start();
            latch.await();

            if (x == 0 && y == 0) {
                System.out.println("第" + i + "次 （" + x + "," + y + ")");
                break;
            }
        }
    }
}
