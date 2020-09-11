package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private final SimpleArray<T> store = new SimpleArray<>();
    private int size = 0;

    public void add(T elements) {
       if (size == 0) {
           store.add(elements);
           size++;
           return;
       }
       if (!contains(elements)) {
           store.add(elements);
           size++;
       }
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return store.iterator();
    }

    private boolean contains(T value) {
        for (T element : store) {
            if (Objects.equals(element, value)) {
                return true;
            }
        }
        return false;
    }
}
