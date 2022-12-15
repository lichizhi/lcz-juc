package com.lcz.study.juc.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T001_ConcurrentLinkedQueue {

    static final Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 1000; i++) {
            tickets.add("票编号：" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    String ticket = tickets.poll();
                    if (ticket == null) {
                        break;
                    } else System.out.println(ticket);
                }
            }).start();
        }
    }
}
