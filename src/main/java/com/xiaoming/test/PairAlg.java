package com.xiaoming.test;

public class PairAlg {
    public boolean hasNulls(Pari<?> p){
        return p.getFirst()==null||p.getSecond()==null;
    }

    public static  void swap(Pari<?> p){
        swaphelper(p);
    }

    public static  <T>  void swaphelper(Pari<T> p){
        T t=p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
