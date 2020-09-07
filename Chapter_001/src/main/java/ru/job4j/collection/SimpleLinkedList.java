package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;
    private int size = 0;

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> temp = first;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                E result = temp.item;
                temp = temp.next;
                return result;
            }
        };
    }

    private static class Node<E> {
        private Node<E> prev;
        private Node<E> next;
        private E item;

        public Node(Node<E> p, E element, Node<E> n) {
            prev = p;
            next = n;
            item = element;
        }
    }

    public void add(E element) {
        Node<E> l = last;
        Node<E> elem = new Node<>(l, element, null);
        last = elem;
        if (l == null) {
            first = elem;
        } else {
            l.next = elem;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        int position = Objects.checkIndex(index, size);
        Node<E> result = first;
        for (int i = 0; i < position; i++) {
             result = first.next;
        }
        return result.item;
    }
}
