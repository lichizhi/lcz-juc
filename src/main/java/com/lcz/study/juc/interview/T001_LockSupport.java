package com.lcz.study.juc.interview;

import com.lcz.study.help.SleepHelper;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * 实现一个容器，提供两个方法：add()、size()
 * 写两个线程，一个线程添加10个元素到容器中，另一个线程监控容器元素个数，当个数为5时给出提示并结束线程
 */
public class T001_LockSupport {

    List<Object> list = Collections.synchronizedList(new LinkedList<>());

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    static Thread t1, t2;
    public static void main(String[] args) {
        T001_LockSupport t = new T001_LockSupport();

        t2 = new Thread(() -> {
            System.out.println("t2 start");
            LockSupport.park();
            System.out.println("t2 end");
            LockSupport.unpark(t1);
        }, "t2");

        t1 = new Thread(() -> {
            System.out.println("t1 start");
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println(i);
                if (t.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
            System.out.println("t1 end");
        }, "t1");

        t2.start();
        SleepHelper.sleepSeconds(1);
        t1.start();

    }
}
