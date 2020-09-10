package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T>{
    private final SimpleArray<T> store = new SimpleArray<>();
    private int size = 0;

    public void add(T elements) {
        Iterator<T> iterator = store.iterator();
       if (size == 0) {
           store.add(elements);
           size++;
           return;
       }
       while (iterator.hasNext()) {
           if (iterator.next().equals(elements)) {
               return;
           }
       }
       store.add(elements);
       size++;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return store.iterator();
    }
}
