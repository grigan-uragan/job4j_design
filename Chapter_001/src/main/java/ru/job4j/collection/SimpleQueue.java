package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        while (!in.isEmpty()) {
            T element = in.pop();
            out.push(element);
        }
        T result = out.pop();
        while (!out.isEmpty()) {
            in.push(out.pop());
        }
        return result;
    }

    public void push(T element) {
        in.push(element);
    }
}
