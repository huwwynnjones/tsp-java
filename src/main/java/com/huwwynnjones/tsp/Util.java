package com.huwwynnjones.tsp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Util {

    private Util() {
    }

    static HashMap<CityKey, Integer> loadCostsFromFile(String filename) throws IOException {
        var costs = new HashMap<CityKey, Integer>();
        try (var buf = new BufferedReader(new FileReader(filename))) {
            buf.lines().forEach(line -> {
                var mapEntry = MapEntry.from(line);
                costs.put(mapEntry.key(), mapEntry.cost());
            });
        } catch (IOException ex) {
            throw new IOException(ex);
        }
        return costs;
    }

    static Set<String> citiesFromCityKeys(HashMap<CityKey, Integer> costs) {
        var keys = costs.keySet();
        return keys.stream().flatMap(k -> Stream.of(k.start(), k.end())).collect(Collectors.toSet());
    }

    static List<List<String>> journeyToCityPairs(List<String> journey) {
        var stack = new ArrayDeque<>(journey);
        var result = new ArrayList<List<String>>();
        while (stack.size() > 1) {
            var first = stack.pollFirst();
            var second = stack.peekFirst();
            result.add(List.of(first, second));
        }
        return result;
    }

    static int calculateCost(List<List<String>> cityPairs, HashMap<CityKey, Integer> costs) {
        return cityPairs.stream().mapToInt(p -> getCost(p, costs)).sum();
    }

    private static int getCost(List<String> pair, HashMap<CityKey, Integer> costs) {
        var key = new CityKey(pair);
        if (costs.containsKey(key)) {
            return costs.get(key);
        } else if (costs.containsKey(key.reverseKey())) {
            return costs.get(key.reverseKey());
        } else {
            throw new RuntimeException(String.format("No costs for %s", pair));
        }
    }

    static int factorial(int number) {
        return IntStream.rangeClosed(1, number).reduce(1, (acc, x) -> acc * x);
    }
}
