package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private  Object[] data;
    private int index = 0;

    public SimpleArray(int capacity) {
        this.data = new Object[capacity];
    }

    public boolean add(T model) {
        if (index < data.length) {
            data[index++] = model;
            return true;
        }
        System.out.println("Array is full");
        return false;
    }

    public T get(int position) {
        return (T) data[Objects.checkIndex(position, index)];
    }

    public boolean set(int position, T model) {
        data[Objects.checkIndex(position, index)] = model;
        return true;
    }

    public boolean remove(int position) {
        for (int i = Objects.checkIndex(position, index); i < index - 1; i++) {
            data[i] = data[i + 1];
        }
        index--;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) Arrays.asList(data).iterator();
    }
}
