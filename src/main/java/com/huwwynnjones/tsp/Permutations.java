package com.huwwynnjones.tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Permutations<T extends List<?>> implements Iterable<T> {
    private T a;
    private int n;
    private List<Integer> p;
    private int i;
    private boolean initial_call;

    Permutations(T a) {
        this.a = (T) new ArrayList<>(a);
        n = this.a.size();
        p = createIntegerArray(n);
        i = 1;
        initial_call = true;
    }

    public Iterator<T> iterator() {
        return new Itr();
    }

    public Stream<T> stream(){
        return StreamSupport.stream(this.spliterator(), false);

    }

    private class Itr implements Iterator<T> {

        Itr() {
        }

        public boolean hasNext() {
            return Permutations.this.i < Permutations.this.n;
        }

        public T next() {
            if (Permutations.this.initial_call) {
                Permutations.this.initial_call = false;
                return (T) List.copyOf(Permutations.this.a);
            } else if (Permutations.this.i < Permutations.this.n) {
                Permutations.this.p.set(Permutations.this.i, (Permutations.this.p.get(Permutations.this.i) - 1));
                var j = odd(Permutations.this.i) ? Permutations.this.p.get(Permutations.this.i) : 0;
                Collections.swap(Permutations.this.a, j, Permutations.this.i);
                Permutations.this.i = 1;
                while (Permutations.this.p.get(Permutations.this.i) == 0) {
                    Permutations.this.p.set(Permutations.this.i, Permutations.this.i);
                    Permutations.this.i += 1;
                }
            }
            return (T) List.copyOf(Permutations.this.a);
        }

    }

    private boolean odd(int number) {
        return number % 2 != 0;
    }

    private List<Integer> createIntegerArray(int length) {
        return IntStream.range(0, length + 1).boxed().collect(Collectors.toList());
    }
}