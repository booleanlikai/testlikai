package com.xiaoming.test;

public enum type {
    AA("1","AA的描述"),
    BB("2","BB的描述"),
    CC("3","CC的描述")
    ;

    private String aa;
    private String bb;

     type(String aa, String bb) {
        this.aa=aa;
        this.bb=bb;
    }

    type() {
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }
}
