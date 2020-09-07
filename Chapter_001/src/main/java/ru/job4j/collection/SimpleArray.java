package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container = new Object[10];
    private int modCount = 0;
    private int size = 0;

    public T get(int index) {
        return (T) container[Objects.checkIndex(index, size)];
    }

    public void add(T model) {
        if (container.length == size) {
           container = grow();
        }
        container[size++] = model;
        modCount++;
    }

    private Object[] grow() {
        int oldCapacity = container.length;
        int minCapacity = oldCapacity + (oldCapacity / 2 + 1);
        return Arrays.copyOf(container, minCapacity);
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private int expectedModCount = modCount;
            private int point = 0;
            @Override
            public boolean hasNext() {
                return point != size;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return (T) container[point++];
            }
        };
    }
}
