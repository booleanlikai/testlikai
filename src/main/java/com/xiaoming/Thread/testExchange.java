package com.xiaoming.Thread;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Exchanger;

public class testExchange {
    static class myExchangeTest extends Thread {
        private Exchanger<String> exchanger;
        private String ss;
        private String threadName;

        public myExchangeTest(Exchanger<String> exchanger, String ss, String threadName) {
            this.exchanger = exchanger;
            this.ss = ss;
            this.threadName = threadName;
        }

        @Override
        public void run() {
            try {
                System.out.println(threadName +":"+exchanger.exchange(ss));
                String xx=exchanger.exchange(ss);
                System.out.println(xx+"ss"+threadName);
                System.out.println(ss+".."+threadName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger=new Exchanger<>();
        myExchangeTest myExchangeTest1=new myExchangeTest(exchanger,"thread1","thread1");
        myExchangeTest myExchangeTest2=new myExchangeTest(exchanger,"thread2","thread2");
        myExchangeTest myExchangeTest3=new myExchangeTest(exchanger,"thread3","thread3");
        myExchangeTest1.start();
        myExchangeTest2.start();
        myExchangeTest3.start();
    }
}
