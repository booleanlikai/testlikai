package com.xiaoming.Concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTasKTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        mycallable mycallable = new mycallable();
        String ss = "测试";
        FutureTask<String> task = new FutureTask<String>(mycallable, ss);
        new Thread(task).start();
        System.out.println(task.get());
    }

    static class mycallable implements Runnable {

        @Override
        public void run() {
            System.out.println("sssss");
        }
    }
}
