package com.luban.demo1;

/**
 * synchronized关键字
 */
public class Demo1 {

    private int count = 10;
    private Object object = new Object();

    public void test(){
        synchronized (object){
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

}
