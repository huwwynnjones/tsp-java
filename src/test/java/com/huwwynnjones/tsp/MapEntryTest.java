package com.huwwynnjones.tsp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MapEntryTest {
    @Test
    void stringToMapEntry() {
        var input = "A B 80";
        var correct_result = new MapEntry(new CityKey("A", "B"), 80);
        assertEquals(correct_result, MapEntry.from(input));
    }
}
