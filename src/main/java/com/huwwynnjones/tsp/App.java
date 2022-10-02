package com.huwwynnjones.tsp;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        var a = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        var perms = new Permutations<>(a);
        System.out.println(perms.stream().count());
    }
}