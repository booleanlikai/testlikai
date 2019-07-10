package com.xiaoming.Concurrency;

public class testthread {
    private static int index=0;
    public static void checkNum(){
        System.out.println("xxxxxxxxxxxxx"+Thread.currentThread().getName());
        synchronized (testthread.class){
            while(testthread.index<=5){
                System.out.println((testthread.index++)+"xxxxxx"+Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            new Thread(()->{testthread.checkNum();}).start();
        }
    }
}


