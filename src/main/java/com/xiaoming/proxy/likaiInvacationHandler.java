package com.xiaoming.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class likaiInvacationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LK annotation = method.getAnnotation(LK.class);
        String value = annotation.value();
        System.out.println(value);
        return null;
    }
}
