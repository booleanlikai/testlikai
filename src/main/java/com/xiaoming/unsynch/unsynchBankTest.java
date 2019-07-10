package com.xiaoming.unsynch;

import java.util.concurrent.locks.Condition;

public class unsynchBankTest {
    public static final int NACCOUNTS = 4;
    public static final double INITAL_BALACNE = 1000;
    public static final double MAX_AMOUNT = 1000;
    public static final int DELAY = 10;


    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITAL_BALACNE);
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            new Thread(() -> {
                while (true) {
//                    System.out.println(Thread.currentThread().getName() + "threadID:" + Thread.currentThread().getId());
                    int toaccount = (int) (bank.size() * Math.random());
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(fromAccount, toaccount, amount);
                    try {
                        Thread.sleep((long) ((int) DELAY * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
