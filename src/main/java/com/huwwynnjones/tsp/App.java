package com.huwwynnjones.tsp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class App 
{
    public static void main( String[] args )
    {
        var a = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        var perms = new Permutations<>(a);
        var s = StreamSupport.stream(perms.spliterator(), false);
        System.out.println(s.count());
    }
}