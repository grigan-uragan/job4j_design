package ru.job4j.collection;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    public Tree(final E root) {
        this.root = new Node<>(root);
    }

    public boolean isBinary() {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (element.getChildren().size() > 2) {
                return false;
            }
            data.addAll(element.getChildren());
        }
        return true;
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> result = findBy(child);
        Optional<Node<E>> par = findBy(parent);
        if (result.isEmpty() && par.isPresent()) {
            par.get().getChildren().add(new Node<>(child));
            return true;
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (element.getValue().equals(value)) {
                result = Optional.of(element);
                break;
            }
            data.addAll(element.getChildren());
        }
        return result;
    }
}
