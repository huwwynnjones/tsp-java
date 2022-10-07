package com.huwwynnjones.tsp;

public final class CityKey {
    final String start;
    final String end;

    CityKey(String start, String end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CityKey) {
            var other = (CityKey) obj;
            return this.start.equals(other.start) && this.end.equals(other.end);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("(start %s, end %s)", this.start, this.end);
    }
}
