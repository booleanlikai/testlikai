package com.xiaoming.test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;
import java.util.function.Consumer;

public class genericReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException {
        String name = "java.util.Arrays";
        Class<?> cl = Class.forName(name);
        printClass(cl);
        for (Method m : cl.getDeclaredMethods())
            printMethod(m);
    }

    public static void printClass(Class<?> cl) {
        System.out.println(cl);
        printTypes(cl.getTypeParameters(), "<", ",", ">", true);
        Type sc = cl.getGenericSuperclass();
        if (sc != null) {
            System.out.print("extend");
            printtype(sc, false);
        }
        printTypes(cl.getGenericInterfaces(), "implement", ",", "", false);
        System.out.println();

    }

    public static void printMethod(Method method) {
        String name = method.getName();
        System.out.print(Modifier.toString(method.getModifiers()));
        System.out.print("");
        printTypes(method.getTypeParameters(), "<", ",", ">", true);
        printtype(method.getGenericReturnType(), false);
        System.out.print("  ");
        System.out.print(name);
        System.out.print("(");
        printTypes(method.getGenericParameterTypes(), "", ",", "", false);
        System.out.print(")");
    }

    public static void printtype(Type type, boolean isDefinition) {
        if (type instanceof Class) {
            Class<?> t = (Class<?>) type;
            System.out.println(t.getName());
        } else if (type instanceof TypeVariable) {
            TypeVariable<?> t = (TypeVariable<?>) type;
            System.out.println(t.getName());
            if (isDefinition)
                printTypes(t.getBounds(), "extends", "&", "", false);
        } else if (type instanceof WildcardType) {
            WildcardType t = (WildcardType) type;
            System.out.print("?");
            printTypes(t.getUpperBounds(), "extends", "&", "", false);
            printTypes(t.getLowerBounds(), "super", "&", "", false);
        } else if (type instanceof ParameterizedType) {
            ParameterizedType t = (ParameterizedType) type;
            Type owner = t.getOwnerType();
            if (owner != null) {
                printtype(owner, false);
                System.out.print(".");
            }
            printtype(t.getRawType(), false);
            printTypes(t.getActualTypeArguments(), "<", ",", ">", false);
        } else if (type instanceof GenericArrayType) {
            GenericArrayType t = (GenericArrayType) type;
            System.out.println("");
            printtype(t.getGenericComponentType(), isDefinition);
            System.out.print("[]");
        }

    }


    public static void printTypes(Type[] types, String pre, String sep, String suf, boolean isDefinition) {
        if (pre.equals("extends") && Arrays.equals(types, new Type[]{Object.class}))
            return;
        if (types.length > 0)
            System.out.print(pre);
        for (int i = 0; i < types.length; i++) {
            if (i > 0) System.out.print(sep);
            printtype(types[i], isDefinition);
        }
        if (types.length > 0)
            System.out.print(suf);
    }
}
