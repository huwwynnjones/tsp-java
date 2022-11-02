package com.huwwynnjones.tsp;

import java.util.List;

record CityKey(String start, String end) {

    CityKey(List<String> cityPair) {
        this(cityPair.get(0), cityPair.get(1));
    }

    CityKey reverseKey() {
        return new CityKey(this.end, this.start);
    }
}
