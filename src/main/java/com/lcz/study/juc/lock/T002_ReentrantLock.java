package com.lcz.study.juc.lock;

import com.lcz.study.help.SleepHelper;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 基本用法
 * 还可以使用 tryLock()、lockInterruptibly()、new ReentrantLock(true)：true表示公平锁
 */
public class T002_ReentrantLock {

    private static final ReentrantLock lock = new ReentrantLock();

    public void m1() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                SleepHelper.sleepSeconds(1);
                System.out.println(i);
            }
        } finally {
            lock.unlock();
        }
    }

    public void m2() {
        lock.lock();
        try {
            System.out.println("m2...");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        T002_ReentrantLock t002ReentrantLock = new T002_ReentrantLock();
        new Thread(t002ReentrantLock::m1).start();
        SleepHelper.sleepSeconds(1);
        new Thread(t002ReentrantLock::m2).start();
    }
}
