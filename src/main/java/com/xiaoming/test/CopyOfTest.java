package com.xiaoming.test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {
//    public static void main(String[] args) {
//        CopyOfTest copyOfTest = new CopyOfTest();
//        Integer[] a={1,2,3};
////        a= (Integer[]) copyOfTest.badCopyOf(a,10);
//        System.out.println(Arrays.toString(a));
//
//        String[] b={"tom","Dick","ssssdas"};
//        b= (String[]) copyOfTest.goodCopyOf(b,10);
//        System.out.println(Arrays.toString(b));
//    }

    public  Object[] badCopyOf(Object[] a, int newlength){
        Object[] newArray=new Object[newlength];
        System.arraycopy(a,0,newArray,0,Math.min(a.length,newlength));
        return newArray;
    }

    public Object goodCopyOf(Object a,int newlength){
        Class cl=a.getClass();
        if(!cl.isArray())
            return null;
        Class c=cl.getComponentType();
        int length= Array.getLength(a);
        Object newArray=Array.newInstance(c,newlength);
        System.arraycopy(a,0,newArray,0,Math.min(newlength,length));
        return newArray;
    }
}
