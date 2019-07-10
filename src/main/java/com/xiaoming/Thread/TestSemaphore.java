package com.xiaoming.Thread;

import java.util.concurrent.Semaphore;

public class     TestSemaphore {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3,false);
        for (int i = 0; i < 10 ; i++) {
            new Mythread(i,semaphore).start();
        }
    }

    static class Mythread extends Thread{

        private int i;
        private Semaphore semaphore;

        public Mythread(int i, Semaphore semaphore) {
            this.i = i;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("当前线程："+Thread.currentThread().getName()+"当前序号"+i);
                Thread.sleep(5000);
                System.out.println("执行完成当前线程："+Thread.currentThread().getName()+"当前序号"+i);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            super.run();
        }
    }
}
