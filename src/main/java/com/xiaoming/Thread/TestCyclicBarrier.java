package com.xiaoming.Thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier= new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程："+Thread.currentThread().getName());
            }
        });

        MyThread myThread1 =new MyThread(cyclicBarrier);
        MyThread myThread2 = new MyThread(cyclicBarrier);
        MyThread myThread3 = new MyThread(cyclicBarrier);
        myThread1.start();
        myThread2.start();
        myThread3.start();
        System.out.println("继续执行主线程");
    }

    public static class MyThread extends Thread {
        CyclicBarrier cyclicBarrier;

        public MyThread(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("等待执行完成" + Thread.currentThread().getName() + "线程ID：" + Thread.currentThread().getId());
            try {
                Thread.sleep(5000);
                System.out.println("写入数据完毕" + Thread.currentThread().getName() + "线程ID：" + Thread.currentThread().getId());
                cyclicBarrier.await();
                Thread.sleep(1000);
                System.out.println("线程执行完成" + Thread.currentThread().getName() + "线程ID：" + Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
