package com.xiaoming.ConsumerProduce;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private int countproduct;
    private int productid;
    private BlockingQueue<String> blockingQueue;

    public Consumer(int countproduct, int productid, BlockingQueue<String> blockingQueue) {
        this.countproduct = countproduct;
        this.productid = productid;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String ss=blockingQueue.take();
                TimeUnit.SECONDS.sleep(1);
                System.out.println("消费take:"+ss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
