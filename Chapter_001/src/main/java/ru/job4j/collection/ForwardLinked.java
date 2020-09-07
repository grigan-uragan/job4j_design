package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<E> implements Iterable<E> {
    private Node<E> head;

    public void add(E element) {
        Node<E> node = new Node<>(element, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<E> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
            head = head.next;

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            Node<E> node = head;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = node.value;
                node = node.next;
                return result;
            }
        };
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
