package com.xiaoming.stream.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingIntoMaps {
    public static class Person {
        private int id;
        private String name;
        private int age;

        @Override
        public String toString() {
            return getClass().getName() + "[id=" + id + "name" + name + "]";
        }

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Person(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static Stream<Person> people() {
        return Stream.of(new Person(1001, "Peter"), new Person(1002, "Paul"), new Person(1003, "Mary"), new Person(1003, "Mary2"));
    }

    public static Stream<Person> peoples() {
        return Stream.of(
                new Person(1001, "Peter", 23),
                new Person(1002, "Paul", 45),
                new Person(1003, "Mary", 56),
                new Person(1003, "Mary2", 21),
                new Person(1001, "Peter22", 25),
                new Person(1002, "Paul22", 42),
                new Person(1003, "Mary22", 56),
                new Person(1003, "Mary222", 21)
        );
    }

    public static void main(String args[]) {
        Map<Integer, Set<String>> maps24 = peoples().collect(
                Collectors.groupingBy(
                        Person::getId,
                        Collectors.mapping(Person::getName, Collectors.toSet())
                )
        );
        System.out.println(maps24);
        Map<Integer, Optional<Person>> maps21 = peoples().collect(Collectors.groupingBy (Person::getId, Collectors.maxBy(Comparator.comparingInt(Person::getAge))));
        System.out.println(maps21);
        Map<Integer, Optional<String>> maps22 = peoples().collect(Collectors.groupingBy(Person::getId, Collectors.mapping(Person::getName, Collectors.maxBy(Comparator.comparingInt(String::length)))));
        System.out.println(maps22);
        Map<Integer, Integer> maps2 = peoples().collect(Collectors.groupingBy(Person::getId, Collectors.summingInt(Person::getAge)));
        System.out.println(maps2);
        Map<Integer, List<Person>> maps = people().collect(Collectors.groupingBy(Person::getId));
        System.out.println(maps);
        Map<Integer, Set<Person>> mapss = people().collect(Collectors.groupingBy(Person::getId, Collectors.toSet()));
        System.out.println(mapss);
        Map<Integer, Long> mapss1 = people().collect(Collectors.groupingBy(Person::getId, Collectors.counting()));
        System.out.println(mapss1);
        Map<Integer, String> idToname = people().collect(Collectors.toMap(Person::getId, Person::getName, (existingValue, newValue) -> newValue));
        System.out.println(idToname);
        Map<Integer, Person> idToperson = people().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println(idToperson);
        idToperson = people().collect(Collectors.toMap(Person::getId, Function.identity(),
                (existingValue, newValue) -> {
                    throw new IllegalStateException();
                }, TreeMap::new));
        System.out.println(idToperson);
        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = localeStream.collect(Collectors.toMap(Locale::getLanguage, l -> l.getDisplayLanguage(l),
                (existingValue, newValue) -> existingValue));
        System.out.println(languageNames);
        localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryLanguages = localeStream.collect(
                Collectors.toMap(
                        Locale::getDisplayCountry, locale -> Collections.singleton(locale.getDisplayLanguage()),
                        (a, b) -> {
                            Set<String> union = new HashSet<>(a);
                            union.addAll(b);
                            return union;
                        }));
        System.out.println(countryLanguages);
        localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> countryToLocales = localeStream.collect(
                Collectors.groupingBy(Locale::getCountry)
        );
        System.out.println(countryLanguages);


    }
}
