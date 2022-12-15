package com.lcz.study.juc.interview;

import com.lcz.study.help.SleepHelper;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 实现一个容器，提供两个方法：add()、size()
 * 写两个线程，一个线程添加10个元素到容器中，另一个线程监控容器元素个数，当个数为5时给出提示并结束线程
 */
public class T001_CountDownLatch {

    List<Object> list = Collections.synchronizedList(new LinkedList<>());

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        T001_CountDownLatch t = new T001_CountDownLatch();

        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);
        new Thread(() -> {
            System.out.println("t2 start");
            if (t.size() != 5) {
                try {
                    latch1.await();
                    latch2.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 end");
        }, "t2").start();

        SleepHelper.sleepSeconds(1);

        new Thread(() -> {
            System.out.println("t1 start");
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println(i);
                if (t.size() == 5) {
                    latch1.countDown();
                    try {
                        latch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("t1 end");
        }, "t1").start();


    }
}
