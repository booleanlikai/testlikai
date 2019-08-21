package com.xiaoming.stream.collection;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DownstreamCollectors {
    public static class City {
        private String name;
        private String state;
        private int population;

        public City(String name, String state, int population) {
            this.name = name;
            this.state = state;
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }
    }

    public static Stream<City> readCities(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
                .map(l -> l.split(","))
                .map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
    }

    public static void main(String[] args) throws IOException {
        Stream<Locale> localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLocaleSet = localeStream.collect(
                Collectors.groupingBy(
                        Locale::getCountry,
                        Collectors.toSet()
                )
        );
        System.out.println(countryToLocaleSet);
        localeStream = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLocalesCounts = localeStream.collect(
                Collectors.groupingBy(
                        Locale::getCountry,
                        Collectors.counting()
                )
        );
        System.out.println(countryToLocalesCounts);
        Stream<City> cites = readCities("C:\\Users\\likai\\Desktop\\cities.txt");
        Map<String, Integer> stateToCityPopulation = cites.collect(
                Collectors.groupingBy(
                        City::getState,
                        Collectors.summingInt(City::getPopulation)
                )
        );
        System.out.println(stateToCityPopulation);
        cites = readCities("C:\\Users\\likai\\Desktop\\cities.txt");
        Map<String, Optional<String>> stateToLongesCityName = cites.collect(
                Collectors.groupingBy(
                        City::getState,
                        Collectors.mapping(City::getName,
                                Collectors.maxBy(Comparator.comparingInt(String::length))
                        )
                )
        );
        System.out.println(stateToLongesCityName);
    }
}
