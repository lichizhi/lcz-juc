package com.lcz.study.threadPool;

import java.util.concurrent.*;

public class T002_ThreadPool {
    public static void main(String[] args) {
        new ThreadPoolExecutor(2,
                4,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(5);
        Executors.newScheduledThreadPool(4);


        Executors.newWorkStealingPool();

    }
}
