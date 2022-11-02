package com.huwwynnjones.tsp;

<<<<<<< HEAD
public final class MapEntry {
    final CityKey key;
    final int cost;

    MapEntry(CityKey key, int cost) {
        this.key = key;
        this.cost = cost;
    }

=======
record MapEntry (CityKey key, int cost) {
>>>>>>> with_records
    static MapEntry from(String input) {
        var items = input.split(" ");
        var key = new CityKey(items[0], items[1]);
        var cost = Integer.parseInt(items[2]);
        return new MapEntry(key, cost);
    }
}