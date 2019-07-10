package com.luban.demo1;

public class Demo3 {

    private int count = 10;

    //相当于是synchronized(this)
    public synchronized void test(){
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

}
