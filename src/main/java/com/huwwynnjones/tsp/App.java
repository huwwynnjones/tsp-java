package com.huwwynnjones.tsp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {
    public static void main(String[] args) {
        var app = new App();
        app.run();
    }

    void run() {
        var costs = loadCostsFromFile();
        var cities = Util.citiesFromCityKeys(costs);
        var permutations = new Permutations<>(new ArrayList<String>(cities));
        var cheapestJourneys = new ArrayList<List<String>>();
        var lowestCost = Integer.MAX_VALUE;

        for(var journey: permutations) {
            var cityPairs = Util.journeyToCityPairs(journey);
            var currentCost = Util.calculateCost(cityPairs, costs);
            if (currentCost < lowestCost) {
                cheapestJourneys.clear();
                cheapestJourneys.add(journey);
                lowestCost = currentCost;
            } else if (currentCost == lowestCost) {
                cheapestJourneys.add(journey);
            }
        }

        System.out.println(String.format("Lowest cost %s, cheapest journeys %s", lowestCost, cheapestJourneys));
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

}