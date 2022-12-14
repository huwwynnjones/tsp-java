package com.huwwynnjones.tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Permutations<T extends List<E>, E> implements Iterable<List<E>> {
    private final List<E> a;
    private final int n;
    private final List<Integer> p;
    private int i;
    private boolean initialCall;

    Permutations(T a) {
        this.a = new ArrayList<>(a);
        n = this.a.size();
        p = createIntegerArray(n);
        i = 1;
        initialCall = true;
    }

    @Override
    public Iterator<List<E>> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<List<E>> {

        Itr() {
        }

        @Override
        public boolean hasNext() {
            return Permutations.this.i < Permutations.this.n;
        }

        /*
         * quickperm see https://www.baeldung.com/cs/array-generate-all-permutations
         * and https://www.quickperm.org/
         * adapted a bit to be iterable
         */
        @Override
        public List<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            var self = Permutations.this;
            if (self.initialCall) {
                self.initialCall = false;
                return copyOf(self.a);
            } else if (self.i < self.n) {
                self.p.set(self.i, (self.p.get(self.i) - 1));
                var j = odd(self.i) ? self.p.get(self.i) : 0;
                Collections.swap(self.a, j, self.i);
                self.i = 1;
                while (self.p.get(self.i) == 0) {
                    self.p.set(self.i, self.i);
                    self.i += 1;
                }
            }
            return copyOf(self.a);
        }

        private List<E> copyOf(List<E> a) {
            return new ArrayList<>(a);
        }

        private boolean odd(int number) {
            return number % 2 != 0;
        }
    }

    private List<Integer> createIntegerArray(int length) {
        return IntStream.range(0, length + 1).boxed().collect(Collectors.toList());
    }
}