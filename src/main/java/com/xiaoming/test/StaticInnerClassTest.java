package com.xiaoming.test;

import com.xiaoming.test.Manager;

public class StaticInnerClassTest {

    public static void main(String[] args) {
//        double[] d = new double[20];
//        for (int i = 0; i < d.length; i++) {
//            d[i] = 100 * Math.random();
//        }
//        ArrayAlg.Pari p = ArrayAlg.minmax(d);
//        System.out.println("min=" + p.getFirst());
//        System.out.println("max=" + p.getSecond());
        String[] words={"Mary","had","a","little","lamb"};
        ArrayAlg.Pari<String> mm=ArrayAlg.minmax(words);

        System.out.println("min=" + mm.getFirst());
        System.out.println("max=" + mm.getSecond());

        ArrayAlg.Pari<String>[] paris= (ArrayAlg.Pari<String>[]) new ArrayAlg.Pari<?>[10];
    }

    static class ArrayAlg {
        public static class Pari<T> {
            private T first;
            private T second;

            public Pari(T first, T second) {
                this.first = first;
                this.second = second;
            }

            public  T getFirst() {
                return first;
            }

            public T getSecond() {
                return second;
            }

        }

        public static Pari minmax(double[] value) {
            double min = Double.POSITIVE_INFINITY;
            double max = Double.NEGATIVE_INFINITY;
            for (double v : value) {
                if (min > v) min = v;
                if (max < v) max = v;
            }
            return new Pari(min, max);
        }
        public static<T extends Comparable> Pari<T> minmax(T[] value) {
            if(value==null||value.length==0) return null;
            T min = value[0];
            T max = value[0];
            for (int i = 0; i <value.length ; i++) {
                if(min.compareTo(value[i])>0) min=value[i];
                if(max.compareTo(value[i])<0) max=value[i];
            }
            return  new Pari(min, max);
        }

        public static void minmax(Pari<? super Manager> value) {



        }
        
    }
}
