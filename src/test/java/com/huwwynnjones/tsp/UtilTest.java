package com.huwwynnjones.tsp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class UtilTest {
   
    @Test
    void citiesFromCityKeys() {
        var costs = new HashMap<CityKey, Integer>();
        costs.put(new CityKey("A", "B"), 80);
        costs.put(new CityKey("A", "C"), 30);
        var correct_result = Set.of("A", "B", "C");
        assertEquals(correct_result, Util.citiesFromCityKeys(costs));        
    }

    @Test
    void journeyToCityPairs() {
        var journey = List.of("A", "B", "C");
        var correct_result = List.of(List.of("A", "B"), List.of("B", "C"));
        assertEquals(correct_result, Util.journeyToCityPairs(journey)); 
    }

    @Test
    void calculateCost(){
        var costs = new HashMap<CityKey, Integer>();
        costs.put(new CityKey("A", "B"), 30);
        costs.put(new CityKey("B", "C"), 50);
        var cityPairs = List.of(List.of("A", "B"), List.of("B", "C"));
        assertEquals(80, Util.calculateCost(cityPairs, costs));

    }
}
