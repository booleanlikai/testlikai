package com.xiaoming.ConsumerProduce;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class testmain {

    private static final BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(4);

    public static void main(String[] args) {
        Consumer consumer1 = new Consumer(1, 1, blockingQueue);
        Consumer consumer2 = new Consumer(2, 2, blockingQueue);
        Consumer consumer3 = new Consumer(3, 3, blockingQueue);
        Consumer consumer4 = new Consumer(4, 4, blockingQueue);
        producter producter1 = new producter(1, 1, blockingQueue);
        producter producter2 = new producter(2, 2, blockingQueue);
        producter producter3 = new producter(3, 3, blockingQueue);
        producter producter4 = new producter(4, 4, blockingQueue);
        producter producter5 = new producter(5, 5, blockingQueue);
        producter producter6 = new producter(6, 6, blockingQueue);

        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();
        new Thread(consumer4).start();
        new Thread(producter1).start();
        new Thread(producter2).start();
        new Thread(producter3).start();
        new Thread(producter4).start();
        new Thread(producter5).start();
        new Thread(producter6).start();
    }
}
