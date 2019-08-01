package com.xiaoming.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountLongWords {
    public static void main(String[] args) throws IOException {
        String conntents = new String(Files.readAllBytes(Paths.get("C:\\Users\\likai\\Desktop\\testceshi.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(conntents.split("\\PL+"));
        long start0 = System.currentTimeMillis();
        long count = 0;
        for (String word : words) {
            if (word.length() > 12)
                count++;
        }
        long end0 = System.currentTimeMillis();
        System.out.println(count + "-----------" + (end0 - start0));
        long start1 = System.currentTimeMillis();
        count = words.stream().filter((s) -> {
            return s.length() > 12;
        }).count();
        long end1 = System.currentTimeMillis();
        System.out.println(count + ":::::" + (end1 - start1));

        long start2 = System.currentTimeMillis();
        long count1 = words.parallelStream().filter((s) -> {
            return s.length() > 12;
        }).count();


        long end2 = System.currentTimeMillis();
        System.out.println(count1 + ":::::" + (end2 - start2));

        long start3 = System.currentTimeMillis();
        long count2 = words.stream().parallel().filter((s) -> {
            return s.length() > 12;
        }).count();
        long end3 = System.currentTimeMillis();
        System.out.println(count2 + ":::::" + (end3 - start3));

        String jsonString = "{\"name\": \"xxxxxx\"}";

    }
}
