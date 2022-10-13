package com.huwwynnjones.tsp;

import java.util.List;

public final class CityKey {
    final String start;
    final String end;

    CityKey(String start, String end) {
        this.start = start;
        this.end = end;
    }

    CityKey(List<String> cityPair) {
        this.start = cityPair.get(0);
        this.end = cityPair.get(1);
    }

    CityKey reverseKey() {
        return new CityKey(this.end, this.start);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CityKey other) {
            return this.start.equals(other.start) && this.end.equals(other.end);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        var result = 17 + this.start.hashCode();
        result = 31 * result + this.end.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("(start %s, end %s)", this.start, this.end);
    }
}
