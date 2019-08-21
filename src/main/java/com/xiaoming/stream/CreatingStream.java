package com.xiaoming.stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
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

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\likai\\Desktop\\testceshi.txt");
        String conntents = new String(Files.readAllBytes(Paths.get("C:\\Users\\likai\\Desktop\\testceshi.txt")), StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(conntents.split("\\PL+"));
        show("words", words);
        Stream<String> song = Stream.of("gently", "down", "the", "stream");
        show("song", song);
        Stream<String> silence = Stream.empty();
        show("slience", silence);
        Stream<String> echos = Stream.generate(() -> "Echo");
        show("echos", echos);
        Stream<Double> randoms = Stream.generate(Math::random);
        show("random", randoms);
        Stream<BigInteger> integerStream = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
        show("integers", integerStream);
        Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(conntents);
        show("wordsAnotherWay", wordsAnotherWay);
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            show("lines", lines);
        }

    }
}
