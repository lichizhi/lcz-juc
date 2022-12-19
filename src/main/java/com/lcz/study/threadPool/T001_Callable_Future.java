package com.lcz.study.threadPool;

import java.util.concurrent.*;

public class T001_Callable_Future {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> "hello";

        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> future = es.submit(callable);
        System.out.println(future.get());

        FutureTask<String> task = new FutureTask<>(callable);
        es.submit(task);
        System.out.println(task.get());

        es.shutdown();
    }
}
