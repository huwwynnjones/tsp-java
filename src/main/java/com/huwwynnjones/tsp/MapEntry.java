package com.huwwynnjones.tsp;

public final class MapEntry {
    final CityKey key;
    final int cost;

    MapEntry(CityKey key, int cost) {
        this.key = key;
        this.cost = cost;
    }

    static MapEntry stringToMapEntry(String input) {
        var items = input.split("\s");
        var key = new CityKey(items[0], items[1]);
        var cost = Integer.parseInt(items[2]);
        return new MapEntry(key, cost);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MapEntry) {
            var other = (MapEntry) obj;
            return this.key.equals(other.key) && this.cost == other.cost;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return key.hashCode() + cost;
    }

    @Override
    public String toString() {
        return String.format("key %s, cost %s", this.key, this.cost);
    }
}
