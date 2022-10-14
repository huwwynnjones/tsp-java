package com.huwwynnjones.tsp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {

    private Util() {}

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
}
