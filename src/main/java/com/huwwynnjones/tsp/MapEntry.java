package com.huwwynnjones.tsp;

record MapEntry(CityKey key, int cost) {
    static MapEntry from(String input) {
        var items = input.split(" ");
        var key = new CityKey(items[0], items[1]);
        var cost = Integer.parseInt(items[2]);
        return new MapEntry(key, cost);
    }
}