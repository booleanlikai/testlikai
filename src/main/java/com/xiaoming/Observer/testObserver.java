package com.xiaoming.Observer;

public class testObserver {

    public static void main(String[] args) {
        Reader reader=new Reader();
        Reader1 reader1=new Reader1();
        publish publish = new publish();
        publish.addObserver(reader);
        publish.addObserver(reader1);
        publish.publisher("测试观察者模式");
    }
}
