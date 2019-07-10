package com.xiaoming.test;

public class Something {
    public Something() {
    }
    public Something(int x) {
    }
    public Something(String something) {
        this(Integer.valueOf(something));
        System.out.println(something);
    }

    public static String startWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    public String endWith(String s) {
        return String.valueOf(s.charAt(s.length() - 1));
    }

    public void endWith() {
    }
}
