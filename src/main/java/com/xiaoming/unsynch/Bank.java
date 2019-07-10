package com.xiaoming.unsynch;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] account;
    private Lock banklock = new ReentrantLock();
    private Condition condition;

    public Bank(double[] account) {
        this.account = account;
    }

    public Bank(int n, double initialBalance) {
        this.account = new double[n];
        Arrays.fill(this.account, initialBalance);
        this.condition = banklock.newCondition();
    }

    public void transfer(int from, int to, double amount) {
        banklock.lock();
        try {
            System.out.printf("account:%10.2f    %10.2f from %d to %d      ", account[from], amount, from, to);
            while (account[from] < amount)
                condition.await();
//            System.out.println(Thread.currentThread().getName() + "threadID:" + Thread.currentThread().getId());
            account[from] -= amount;
            account[to] += amount;
            System.out.printf("%10.2f from %d to %d\n", amount, from, to);
            Thread.sleep(1000);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            banklock.unlock();
        }
    }

    public double getTotalBalance() {
        double sum = 0;
        for (double v : this.account) {
            sum += v;
        }
        return sum;
    }

    public int size() {
        return this.account.length;
    }
}
