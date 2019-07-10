package com.xiaoming.Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class testThread {

    private static volatile Object object = new Object();
    private static volatile boolean flage = false;

    private static volatile Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        mythyread mythyread2 = new mythyread("thread1", true);
        mythyread mythyread3 = new mythyread("thread2", false);
        new Thread(mythyread2).start();
        new Thread(mythyread3).start();
    }

    static class mythyread implements Runnable {

        private String count;
        private boolean threadFlage = false;

        public mythyread(String count, boolean threadFlage) {
            this.count = count;
            this.threadFlage = threadFlage;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    if (flage == threadFlage) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(count);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        flage = threadFlage;
                        object.notify();
                    }
                }
            }

        }
    }
}
