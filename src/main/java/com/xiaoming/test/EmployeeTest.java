package com.xiaoming.test;

import org.w3c.dom.css.CSSStyleDeclaration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff=new Employee[3];
//        Employee ss=new Employee();
        staff[0]=new Employee("Carl Cracker",75000,1987,12,15);
        staff[1]=new Employee("Harry Hacker",50000,1887,10,05);
        staff[2]=new Employee("Tony Tester",5000,1989,11,14);
//        Arrays.sort(staff,(a,b)->Double.compare(a.getSalary(),b.getSalary()));
        Arrays.stream(staff).forEach((n)->{
            System.out.println("---------"+n.getName());
        });

        List list=Arrays.stream(staff).map((n)->{
            System.out.println(n.getName());
            return n.getName();
        }).collect(Collectors.toList());

        System.out.println(list);

//        for (Employee e:staff) {
//            e.rasieSalary(5);





//        }
////
//        for (Employee e:staff){
//            System.out.println(e.toString());
//        }




//        ClassLoader c=EmployeeTest.class.getClassLoader();
//        System.out.println(c);
//        ClassLoader c1=c.getParent();
//        System.out.println(c1);
//        ClassLoader c2=c1.getParent();
//        System.out.println(c2);
    }
}
