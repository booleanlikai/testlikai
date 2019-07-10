package com.luban.demo9;

public class Demo {

    boolean running = true;

    public void test(){
        System.out.println("test start...");
        while (running){

        }
        System.out.println("test end...");
    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        new Thread(demo :: test,"t1").start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        demo.running = false;
    }

}