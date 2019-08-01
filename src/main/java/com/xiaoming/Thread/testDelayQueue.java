package com.xiaoming.Thread;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class testDelayQueue {

    private static final DelayQueue delayQueue = new DelayQueue();

    public static void main(String[] args) {
//        consumer consumer = new consumer(delayQueue);
//        product product = new product(delayQueue);
//        new Thread(consumer).start();
//        new Thread(product).start();
//        ReentrantLock
        ReentrantLock lock=new ReentrantLock(true);
        lock.lock();
        new Thread(()->{lock.lock();}).start();

    }

    static class consumer implements Runnable {
        private DelayQueue<myDelayElement> delayQueue;

        public consumer(DelayQueue<myDelayElement> delayQueue) {
            this.delayQueue = delayQueue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    myDelayElement myDelayElement = delayQueue.take();
                    System.out.println("------------name:" + myDelayElement.getName() + "----------timeWait:" + myDelayElement.getTimeWait() + "----------------submit:" + myDelayElement.getSubmitTime());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class product implements Runnable {
        private DelayQueue<myDelayElement> delayQueue;

        public product(DelayQueue<myDelayElement> delayQueue) {
            this.delayQueue = delayQueue;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                long ss = (long) (Math.random() * 100000);
                long tt = System.nanoTime();
                System.out.println(ss);
                System.out.println(tt);
                long time = TimeUnit.NANOSECONDS.toNanos(ss + tt);
                myDelayElement myDelayElement = new myDelayElement("生产者" + i, time, System.nanoTime());
                delayQueue.put(myDelayElement);
            }
        }
    }


    static class myDelayElement implements Delayed {
        private String name;
        private long timeWait;
        private long submitTime;

        public myDelayElement(String name, long timeWait, long submitTime) {
            this.name = name;
            this.timeWait = timeWait;
            this.submitTime = submitTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(timeWait - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (o == null || !(o instanceof myDelayElement))
                return 1;
            if (o == this)
                return 1;
            myDelayElement myDelayElement = (testDelayQueue.myDelayElement) o;
            if (this.submitTime > myDelayElement.submitTime)
                return 1;
            else if (this.submitTime == myDelayElement.submitTime)
                return 0;
            else
                return -1;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getTimeWait() {
            return timeWait;
        }

        public void setTimeWait(long timeWait) {
            this.timeWait = timeWait;
        }

        public long getSubmitTime() {
            return submitTime;
        }

        public void setSubmitTime(long submitTime) {
            this.submitTime = submitTime;
        }
    }
}
