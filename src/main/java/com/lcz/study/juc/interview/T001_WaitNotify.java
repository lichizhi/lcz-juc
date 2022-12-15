package com.lcz.study.juc.interview;

import com.lcz.study.help.SleepHelper;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 实现一个容器，提供两个方法：add()、size()
 * 写两个线程，一个线程添加10个元素到容器中，另一个线程监控容器元素个数，当个数为5时给出提示并结束线程
 */
public class T001_WaitNotify {

    List<Object> list = Collections.synchronizedList(new LinkedList<>());

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        T001_WaitNotify t = new T001_WaitNotify();

        Object lock = new Object();
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 start");
                if (t.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 end");
                lock.notify(); // 通知t1继续运行
            }
        }, "t2").start();

        SleepHelper.sleepSeconds(1);

        new Thread(() -> {
            System.out.println("t1 start");
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    t.add(new Object());
                    System.out.println(i);
                    if (t.size() == 5) {
                        lock.notify(); // notify() 不会释放锁

                        try {
                            lock.wait(); // 让出锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            System.out.println("t1 end");
        }, "t1").start();


    }
}
