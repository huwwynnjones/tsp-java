package com.huwwynnjones.tsp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PermutationsTest {
    
    @Test
    void permutationsIterator() {
        var a = new ArrayList<>(List.of(1, 2, 3));
        var p = new Permutations<>(a);
        var itr = p.iterator();
        assertEquals(List.of(1, 2, 3), itr.next());
        assertEquals(List.of(2, 1, 3), itr.next());
        assertEquals(List.of(3, 1, 2), itr.next());
        assertEquals(List.of(1, 3, 2), itr.next());
        assertEquals(List.of(2, 3, 1), itr.next());
        assertEquals(List.of(3, 2, 1), itr.next());
        assertFalse(itr.hasNext());
    }
}
