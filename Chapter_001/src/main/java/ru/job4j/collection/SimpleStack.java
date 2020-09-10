package ru.job4j.collection;

public class SimpleStack<T>  {

    private ForwardLinked<T> forwardLinked = new ForwardLinked<>();

    public void push(T value) {
        forwardLinked.add(value);
    }

    public T pop() {
        return forwardLinked.deleteLast();
    }
}
