package com.xiaoming.Thread;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {


    public static  void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        mythread mythread1 = new mythread(countDownLatch);
        mythread mythread2 = new mythread(countDownLatch);
        new Thread(mythread1).start();
        new Thread(mythread2).start();

        System.out.println("等待两个主线程执行完毕");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个主线程执行完毕");

    }

    public static class mythread implements Runnable {

        private CountDownLatch countDownLatch;

        public mythread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("子线程" + Thread.currentThread().getName() + "正在执行" + countDownLatch.getCount());
            try {
                Thread.sleep(5000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
