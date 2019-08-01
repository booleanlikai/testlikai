package com.xiaoming.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreatingStream {
    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> fistElements = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.print(title + ":");
        for (int i = 0; i < fistElements.size(); i++) {
            if (i > 0)
                System.out.print(",");
            if (i < fistElements.size())
                System.out.println(fistElements.get(i));
            else
                System.out.println("...");
        }
    }

    public static void main(String[] args) {

    }
}
