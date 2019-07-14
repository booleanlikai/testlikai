package com.xiaoming.test;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class twinprimes {
    private static volatile Map<String, String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {


        long starttime = new Date().getTime();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        comsuner comsuner = new comsuner(3, 99999999);
        forkJoinPool.invoke(comsuner);
        System.out.println("sssssssssssssssss:" + comsuner.join());
        long endtime = new Date().getTime();
//        System.out.println(map);
        System.out.println(starttime);
        System.out.println(endtime);
        System.out.println("消耗时间：" + (endtime - starttime));

//        System.out.println(isprime(4));
    }

    public static int sumti(int start, int end) {
        int count = 0;
        int first = 0;
        int second = 0;
        for (int i = start; i < end; i++) {
            if (isprime(i)) {
//                System.out.println(i);
                if (first == 0) {
                    first = i;
                } else if (second == 0 && first != 0) {
                    second = i;
                    if (second - first == 2) {
                        count++;
                        map.put(second + "_" + first, second + "_" + first);
                    }
                } else {
                    first = second;
                    second = i;
                    if (second - first == 2) {
                        count++;
                        map.put(second + "_" + first, second + "_" + first);
                    }
                }
            }
        }
        return count;
    }

    public static boolean isprime(int i) {
        boolean isprime = true;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                isprime = false;
                return false;
            }
        }
        if (isprime) {
            return true;
        }
        return false;
    }

    static class comsuner extends RecursiveTask {

        int start;
        int end;
        public static final int THRSHOLD = 750;

        public comsuner(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Object compute() {
            int mid = (int) (start + end) / 2;
            int count;
            if (end - start > THRSHOLD) {
//                System.out.println(Thread.currentThread().getName()+Thread.currentThread().getId());
                comsuner comsuner1 = new comsuner(start, mid + 1);
                comsuner comsuner2 = new comsuner(mid - 1, end);
                comsuner1.fork();
                Integer rightlong = (Integer) comsuner2.compute();
                return (Integer) comsuner1.join() + rightlong;
            } else {
                return twinprimes.sumti(start, end);
            }
        }
    }
}
