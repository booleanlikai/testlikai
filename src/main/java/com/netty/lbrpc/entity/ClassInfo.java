package com.netty.lbrpc.entity;

import java.io.Serializable;

public class ClassInfo implements Serializable {
    private String ClassName;
    private String methodName;
    private Object[] args;
    private Class[] clazzType;

    public ClassInfo(String className, String methodName, Object[] args, Class[] clazzType) {
        ClassName = className;
        this.methodName = methodName;
        this.args = args;
        this.clazzType = clazzType;
    }

    public ClassInfo() {
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Class[] getClazzType() {
        return clazzType;
    }

    public void setClazzType(Class[] clazzType) {
        this.clazzType = clazzType;
    }
}
