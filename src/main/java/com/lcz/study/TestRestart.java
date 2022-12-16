package com.lcz.study;

public class TestRestart {
    public static void main(String[] args) {
        restart:
        for (int i = 0; i < 10; i++) {
            System.out.println("i: " + i);
            for (int j = 0; j < 20; j++) {
                System.out.println("i-j: " + i + "-" + j);
                if (i == 5) continue restart;
            }
            System.out.println("======");
        }
    }
}
