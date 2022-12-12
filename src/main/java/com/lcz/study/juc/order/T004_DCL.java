package com.lcz.study.juc.order;

public class T004_DCL {

    private static volatile T004_DCL INSTANCE = null;

    private T004_DCL() {
    }

    public static T004_DCL getInstance() {
        if (INSTANCE == null) {
            synchronized (T004_DCL.class) {
                if (INSTANCE == null) {
                    INSTANCE = new T004_DCL();
                }
            }
        }

        return INSTANCE;
    }

    public void m() {
        System.out.println(this.hashCode());
    }

    public static void main(String[] args) {
        T004_DCL instance = T004_DCL.getInstance();
        instance.m();
    }
}
