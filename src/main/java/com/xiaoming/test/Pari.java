package com.xiaoming.test;

public class Pari<T> {
    private T first;
    private T second;

    public Pari() {
    }

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

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
