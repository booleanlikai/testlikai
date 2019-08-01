package com.xiaoming.Thread;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class StudentTask implements Runnable {

    private Phaser phaser;

    public StudentTask(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "到达考试");
        phaser.arriveAndAwaitAdvance();
        System.out.println(Thread.currentThread().getName() + "第一题开始时间");
        doExercise();
        System.out.println(Thread.currentThread().getName() + "第一题结束时间");
        phaser.arriveAndAwaitAdvance();

        System.out.println(Thread.currentThread().getName() + "第二题开始时间");
        doExercise();
        System.out.println(Thread.currentThread().getName() + "第二题结束时间");
        phaser.arriveAndAwaitAdvance();

        System.out.println(Thread.currentThread().getName() + "第二题开始时间");
        doExercise();
        System.out.println(Thread.currentThread().getName() + "第二题结束时间");
        phaser.arriveAndAwaitAdvance();
    }

    public void doExercise() {
        long dutation = (long) (Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(dutation);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
