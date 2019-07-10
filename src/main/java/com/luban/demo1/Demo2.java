package com.luban.demo1;

public class Demo2 {

    private int count = 10;

    public void test(){
        synchronized (this){
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

}
