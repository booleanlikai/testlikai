package com.xiaoming.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class testOptional {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("xiaoming");
        System.out.println(name);
//        Optional<String> someNull = Optional.of(null);
        Optional empty = Optional.ofNullable(null);
        if (name.isPresent()) {
            System.out.println(name.get());
        }
        name.ifPresent((n) -> {
            System.out.println("The length of the value is:" + n.length());
        });
        System.out.println(empty.orElse("There is no value present!"));
        System.out.println(name.orElse("There is some value!"));
        System.out.println(empty.orElseGet(() -> "Default Value"));
        System.out.println(name.orElseGet(String::new));
        try {
            empty.orElseThrow(IllegalArgumentException::new);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Optional<String> uppername = name.flatMap((n) -> Optional.of(n.toUpperCase()));
        System.out.println(uppername.get());

        /*filter*/
        List<String> names = Arrays.asList("YanWei", "YanTian");
        for (String s : names) {
            Optional<String> nameLenLessThan7 = Optional.of(s).filter((value) -> value.length() < 7);
            System.out.println(nameLenLessThan7.orElse("The name is more than 6 characters"));

        }
    }
}
