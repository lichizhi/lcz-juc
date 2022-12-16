package com.lcz.study.juc.queue;

import com.lcz.study.help.SleepHelper;

import java.util.concurrent.LinkedTransferQueue;

public class T002_TransferQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

        queue.add("x1");
        queue.add("x2");
        new Thread(() -> {
            try {
                while (true) {
                    System.out.println(queue.take());
                    SleepHelper.sleepSeconds(5);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        queue.transfer("a");
    }
}
