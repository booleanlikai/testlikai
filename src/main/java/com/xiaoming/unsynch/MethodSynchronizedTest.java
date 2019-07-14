package com.xiaoming.unsynch;

import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class MethodSynchronizedTest {
    public static void main(String[] args) {
        new Thread(()->{setsss();}).start();
        Bank.printssss();
    }

    public static void setsss(){
        while (true){
            Bank bank1 = new Bank();
            try {
                TimeUnit.SECONDS.sleep(1);
                Bank.printssss();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




}
