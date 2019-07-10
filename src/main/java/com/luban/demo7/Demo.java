package com.luban.demo7;

import java.util.concurrent.TimeUnit;

public class Demo {

    synchronized void test(){
        System.out.println("demo test start........");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("demo test end........");
    }

    public static void main(String[] args) {
            new Demo2().test();
    }

}

class Demo2 extends Demo{

    @Override
    synchronized void test(){
        System.out.println("demo2 test start........");
        super.test();
        System.out.println("demo2 test end........");
    }

}