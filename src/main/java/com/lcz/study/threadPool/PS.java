package com.lcz.study.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PS {

    private static final List<Integer> list = new ArrayList<>();

    static {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            list.add(1000000 + random.nextInt(1000000));
        }
    }

    public static void foreach() {
        list.forEach(PS::isPrime);
    }

    public static void parallel() {
        list.parallelStream().forEach(PS::isPrime);
    }

    private static void isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) return;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        foreach();
        System.out.println(System.currentTimeMillis() - start);


        start = System.currentTimeMillis();
        parallel();
        System.out.println(System.currentTimeMillis() - start);
    }
}
