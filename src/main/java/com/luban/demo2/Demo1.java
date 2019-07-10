package com.luban.demo2;

import java.util.concurrent.TimeUnit;

public class Demo1 {

    Object o = new Object();

    public void test(){
        synchronized (o) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        Demo1 demo = new Demo1();

        new Thread(demo :: test, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(demo :: test, "t2");

        demo.o = new Object();
        //t2能否执行？
        t2.start();
    }

}
