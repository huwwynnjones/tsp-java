package com.huwwynnjones.tsp;

import java.util.ArrayList;
import java.util.List;

import static com.huwwynnjones.tsp.Util.citiesFromCityKeys;
import static com.huwwynnjones.tsp.Util.journeyToCityPairs;
import static com.huwwynnjones.tsp.Util.calculateCost;
import static com.huwwynnjones.tsp.Util.loadCostsFromFile;

public class App {
    public static void main(String[] args) {
        var app = new App();
        app.run();
    }

    void run() {
        var costs = loadCostsFromFile();
        var cities = citiesFromCityKeys(costs);
        var permutations = new Permutations<>(new ArrayList<>(cities));
        var cheapestJourneys = new ArrayList<List<String>>();
        var lowestCost = Integer.MAX_VALUE;

        System.out.printf("Number of permutations %s%n", Util.factorial(cities.size()));

        for (var journey : permutations) {
            var cityPairs = journeyToCityPairs(journey);
            var currentCost = calculateCost(cityPairs, costs);
            if (currentCost < lowestCost) {
                cheapestJourneys.clear();
                cheapestJourneys.add(journey);
                lowestCost = currentCost;
            } else if (currentCost == lowestCost) {
                cheapestJourneys.add(journey);
            }
        }

        System.out.printf("Lowest cost %s, cheapest journeys %s%n", lowestCost, cheapestJourneys);
    }

}