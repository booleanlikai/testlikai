package com.xiaoming.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class parallelStreams {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("C:\\Users\\likai\\Desktop\\test.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        int[] shortWords = new int[10];
        wordList.parallelStream().forEach(s -> {
            if (s.length() < 10) shortWords[s.length()]++;
        });
        System.out.println(Arrays.toString(shortWords));
        Arrays.fill(shortWords, 0);
        wordList.parallelStream().forEach(s -> {
            if (s.length() < 10) shortWords[s.length()]++;
        });
        System.out.println(Arrays.toString(shortWords));
        Arrays.fill(shortWords, 0);
        Map<Integer, Long> map = wordList.stream().filter(n ->
                n.length() < 10).collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(map);

        Map<Integer, List<String>> map1 = wordList.stream().filter(n -> n.length() < 10).collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(map1);
    }
}
