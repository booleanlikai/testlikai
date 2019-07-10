package com.xiaoming.Observer;

import java.util.Observable;
import java.util.Observer;

public class Reader1 implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof publish){
            publish publish=(com.xiaoming.Observer.publish)o;
            System.out.println("我要订阅11111111"+publish.getMagazineName());
        }
    }
}
