package org.lazylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

public class LazyList<T> implements Iterable<T> {
    private final List<Supplier<T>> elements = new ArrayList<>();

    public void add(Supplier<T> supplier) {
        elements.add(supplier);
    }

    public T get(int index) {
        return elements.get(index).get();
    }

    @Override
    public Iterator<T> iterator() {
        return elements.stream().map(Supplier::get).iterator();
    }
}
