package com.xiaoming.Observer;

import java.util.Observable;

public class publish extends Observable {
    private String magazineName;

    public String getMagazineName() {
        return magazineName;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    public publish() {
    }

    public void  publisher(String magazineName) {
        this.magazineName = magazineName;
        super.setChanged();
        super.notifyObservers(this);
    }
}
