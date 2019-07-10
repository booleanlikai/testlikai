package com.xiaoming.ConsumerProduce;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class producter implements Runnable {
    private int countproduct;
    private int productid;
    private BlockingQueue<String> blockingQueue;


    public producter(int countproduct, int productid, BlockingQueue<String> blockingQueue) {
        this.countproduct = countproduct;
        this.productid = productid;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                blockingQueue.put("产生"+productid);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("put:"+productid);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
