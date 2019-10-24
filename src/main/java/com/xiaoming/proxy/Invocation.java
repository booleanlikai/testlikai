package com.xiaoming.proxy;

import java.lang.reflect.Proxy;

public class Invocation {

//    ClassLoader loader,
//    Class<?>[] interfaces,
//    InvocationHandler h

    public static void main(String[] args) {
        Object o = Proxy.newProxyInstance(Invocation.class.getClassLoader(), new Class[]{testProxy.class}, new likaiInvacationHandler());
        testProxy t = (testProxy) o;
        t.query();
    }
}
