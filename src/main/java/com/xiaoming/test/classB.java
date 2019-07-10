package com.xiaoming.test;

public class classB  implements Cloneable{
    private String nameb;
    private String ageb;
    private String codeb;

    public String getNameb() {
        return nameb;
    }

    public void setNameb(String nameb) {
        this.nameb = nameb;
    }

    public String getAgeb() {
        return ageb;
    }

    public void setAgeb(String ageb) {
        this.ageb = ageb;
    }

    public String getCodeb() {
        return codeb;
    }

    public void setCodeb(String codeb) {
        this.codeb = codeb;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
