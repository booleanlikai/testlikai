package com.xiaoming.Thread;

public class testPhaser {
    public static void main(String[] args) throws InterruptedException {
        Myphaser myphaser = new Myphaser();
        StudentTask[] studentTasks = new StudentTask[5];
        for (int i = 0; i < studentTasks.length; i++) {
            studentTasks[i] = new StudentTask(myphaser);
            myphaser.register();
        }
        Thread[] threads = new Thread[studentTasks.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(studentTasks[i], "Student" + i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

       System.out.println("Phaser has finished" + myphaser.isTerminated());
    }
}
