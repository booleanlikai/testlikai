package com.xiaoming.stream;

import org.springframework.cglib.core.Local;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class OptionalTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\likai\\Desktop\\testceshi.txt");
        String conntents = new String(Files.readAllBytes(Paths.get("C:\\Users\\likai\\Desktop\\testceshi.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(conntents.split("\\PL+"));

        Optional<String> optionalValue = words.stream()
                .filter(s -> s.contains("instead"))
                .findFirst();
        System.out.println(optionalValue.orElse("No word") + "contains fred");

        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result:" + result);
        result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("result:" + result);
        try {
            optionalString.orElseThrow(IllegalStateException::new);
            System.out.println("result:" + result);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        optionalString = words.stream()
                .filter(s -> s.contains("instead"))
                .findFirst();
        optionalString.ifPresent(s -> System.out.println(s + "contains red"));

        Set<String> results = new HashSet<>();
        optionalValue.ifPresent(results::add);
        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println(added);
        System.out.println(results);

        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));
        Optional<Double> result2 = Optional.of(-4.0)
                .flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
        System.out.println(result2);

    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}
