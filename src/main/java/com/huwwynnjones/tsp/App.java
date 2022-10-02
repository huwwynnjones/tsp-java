package com.huwwynnjones.tsp;

import java.util.ArrayList;
import java.util.List;

import com.huwwynnjones.tsp.Permutations;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var a = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13));
        var perms = new Permutations(a);
        
        var count = 0;
        for (Object p : perms) {
            count += 1;
        }
        System.out.println(count);

    }
}