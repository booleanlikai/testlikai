package com.luban.demo12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * atomicXXX
 * 一道面试题：多个atomic类连续调用能否构成原子性?
 */
public class Demo {

    AtomicInteger count = new AtomicInteger(0);

    public void test(){
        for (int i = 0; i < 10000; i++) {
            if(count.get() < 1000){
                count.incrementAndGet();
            }
        }
    }
    public static void main(String[] args) {
        Demo demo = new Demo();

        List<Thread> threads = new ArrayList();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(demo::test, "thread-" + i));
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println(demo.count);
    }

}
