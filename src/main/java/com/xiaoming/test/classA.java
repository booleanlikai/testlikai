package com.xiaoming.test;

public class classA <E> extends classB implements Cloneable{

    E e;
    @copya(name = "nameb")
    private String name;

    @copya(name = "ageb")
    private String age;

    @copya(name = "codeb")
    private String code;

    private classB classB;

    public classA(String name, String age, String code, com.xiaoming.test.classB classB) {
        this.name = name;
        this.age = age;
        this.code = code;
        this.classB = classB;
    }

    public classA() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public static String teststatic() {
        return new String("小明");
    }

    public com.xiaoming.test.classB getClassB() {
        return classB;
    }

    public void setClassB(com.xiaoming.test.classB classB) {
        this.classB = classB;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        classA classA= (com.xiaoming.test.classA) super.clone();
        classA.classB= (com.xiaoming.test.classB) classB.clone();
        return classA;
    }
}
