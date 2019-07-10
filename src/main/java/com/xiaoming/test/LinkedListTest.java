package com.xiaoming.test;

import java.util.*;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> a =new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b=new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        ListIterator<String> listIterator=a.listIterator();
        Iterator<String> iterator=b.iterator();

        while (iterator.hasNext()){
            String name= iterator.next();
            if(listIterator.hasNext()) listIterator.next();
            listIterator.add(name);
        }



        System.out.println(a);

        iterator=b.iterator();
        while (iterator.hasNext()){
            iterator.next();
            if(iterator.hasNext()){
                iterator.next();
                iterator.remove();
            }
        }
        System.out.println(b);

        System.out.println(a);
        a.removeAll(b);
        System.out.println(a);
    }
}
