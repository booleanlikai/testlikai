package com.luban.demo15;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RLDemo1 {

    Lock lock = new ReentrantLock();

    public void test1(){
        try {
            lock.lock();//this
            for (int i = 0; i < 3; i++) {
                System.out.println(i);
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void test2(){
        lock.lock();
        System.out.println("test 2...");
        lock.unlock();
    }

    public static void main(String[] args) {
        RLDemo1 rlDemo1 = new RLDemo1();
        new Thread(rlDemo1::test1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(rlDemo1::test2).start();
    }

}
