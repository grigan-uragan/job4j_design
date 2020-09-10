package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                T element = in.pop();
                out.push(element);
            }
        }
        return out.pop();
    }

    public void push(T element) {
        in.push(element);
    }
}
