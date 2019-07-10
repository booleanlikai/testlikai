package com.luban.demo3;

public class Demo1 implements Runnable{

    private int count = 10;

    @Override
    public void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        Demo1 demo = new Demo1();
        for (int i = 0; i < 5; i++) {
            new Thread(demo,"THREAD" + i).start();
        }
    }

}
