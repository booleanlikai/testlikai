package com.xiaoming.proxy;

import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Invocation {

//    ClassLoader loader,
//    Class<?>[] interfaces,
//    InvocationHandler h

    public static void main(String[] args) {
//        Object o = Proxy.newProxyInstance(Invocation.class.getClassLoader(), new Class[]{testProxy.class}, new likaiInvacationHandler());
//        testProxy t = (testProxy) o;
//        t.query();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
