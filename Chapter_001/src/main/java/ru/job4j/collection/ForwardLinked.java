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

    public E deleteFirst() {
        Node<E> result = head;
        if (head == null) {
            throw new NoSuchElementException();
        }

        head = head.next;
        return result.value;
    }

    public E deleteLast() {
       Node<E> current = head;
       Node<E> prev = null;
       if (head == null) {
           throw new NoSuchElementException();
       }
       while (current.next != null) {
           prev = current;
           current = current.next;
       }
       E result = current.value;
       if (prev == null) {
           head = null;
       } else {
           prev.next = null;
       }
       return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private Node<E> node = head;
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
        private E value;
        private Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
