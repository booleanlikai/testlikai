package com.xiaoming.stream.collection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {
    public static void main(String[] args) throws IOException {
        Iterator<Integer> iter = Stream.iterate(0, n -> n + 1).limit(10).iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
        Object[] numbers = Stream.iterate(0, integer -> integer + 1).limit(10).toArray();
        System.out.println("Object Array" + numbers);

        try {
            Integer number = (Integer) numbers[0];
            System.out.println("number" + number);
            System.out.println("The following statement throws an exception:");
            Integer[] numbers2 = (Integer[]) numbers;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        Integer[] number3 = Stream.iterate(0, integer -> integer + 1).limit(10).toArray(Integer[]::new);
        System.out.println(number3.toString());

        Set<String> noViewlSet = noVowels().collect(Collectors.toSet());
        show("noViewSet", noViewlSet);
        TreeSet<String> noViewTreeSet = noVowels().collect(Collectors.toCollection(TreeSet::new));
        show("noViewTreeSet", noViewTreeSet);

        String result = noVowels().limit(10).collect(Collectors.joining(","));
        System.out.println("Joining with commas:" + result);
        IntSummaryStatistics summaryStatistics = noVowels().collect(Collectors.summarizingInt(String::length));
        double averageWordLength = summaryStatistics.getAverage();
        double maxWordLength = summaryStatistics.getMax();
        System.out.println("Average word length:" + averageWordLength);
        System.out.println("maxWordLength:" + maxWordLength);
        System.out.println("forEach:");
        noVowels().limit(10).forEach(System.out::println);
    }

    public static Stream<String> noVowels() throws IOException {
        Path path = Paths.get("C:\\Users\\likai\\Desktop\\testceshi.txt");
        String conntents = new String(Files.readAllBytes(Paths.get("C:\\Users\\likai\\Desktop\\testceshi.txt")), StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(conntents.split("\\PL+"));
        return words.map(s -> s.replaceAll("[aeiouAEIOU]", ""));
    }

    public static <T> void show(String label, Set<T> set) {
        System.out.println(label + ":" + set.getClass().getName());
        System.out.println("[" + set.stream().limit(10).map(Objects::toString).collect(Collectors.joining(",")) + "]");
    }


}
