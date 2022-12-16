package com.lcz.study.juc.queue;

import java.util.concurrent.SynchronousQueue;

public class T003_SynchronousQueue {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                while (true) {
                    System.out.println(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        queue.put("a");
    }
}
