package com.huwwynnjones.tsp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args )
    {
        var app = new App();
        app.run();


        // var a = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        // var perms = new Permutations<>(a);
        // System.out.println(perms.stream().count());
    }

    void run() {
        var costs = loadCostsFromFile();
        System.out.println(citiesFromCityKeys(costs));
    }

    private HashMap<CityKey, Integer> loadCostsFromFile() {
        var costs = new HashMap<CityKey, Integer>(); 
        try (var buf = new BufferedReader(new FileReader("cities.txt"))) {
            buf.lines().forEach((line) -> {
                var mapEntry = MapEntry.stringToMapEntry(line);
                costs.put(mapEntry.key, mapEntry.cost);
            });
        } catch (IOException ex) {
            System.err.println(ex);
        }
        return costs;
    }

    private Set<String> citiesFromCityKeys(HashMap<CityKey, Integer> costs) {
        var keys = costs.keySet();
        return keys.stream().flatMap((k) -> List.of(k.start, k.end).stream()).collect(Collectors.toSet());
    }
}