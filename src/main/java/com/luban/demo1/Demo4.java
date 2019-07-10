package com.luban.demo1;

public class Demo4 {

    private static int count = 10;

    public synchronized static void test(){
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void test2(){
        synchronized (Demo4.class){
            count--;
        }
    }

}
