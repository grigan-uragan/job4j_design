package ru.job4j.collection;

import java.util.Objects;

public class SimpleHashMap<K, V> {
    private Node<K, V>[] table;
    private int size = 0;

    public boolean insert(K key, V value) {
        //check table
        int start = size;
        if (table == null || table.length == size) {
            resize();
        }
        int hash = Objects.hashCode(key);
        Node<K, V> node = new Node<>(key, value, hash);
        add(node);
        return start != size;
    }

    public V get(K key) {
        int index = indexOf(key);
        if (table[index] != null) {
           return table[index].value;
        }
        return null;
    }

    public boolean delete(K key) {
        int start = size;
        int index = indexOf(key);
        if (table[index] != null) {
            table[index] = null;
            size--;
        }
        return start != size;
    }

    public int getSize() {
        return size;
    }

    private void add(Node<K, V> element) {
        int index = indexOf(element.key);
        if (table[index] == null) {
            table[index] = element;
            size++;
        }
    }

    private int indexOf(K key) {
        int hash = Objects.hashCode(key);
        return hash % table.length;
    }

    private void resize() {
        if (table == null) {
            table = new Node[16];
        } else {
            int newSize = table.length << 1;
            table = replaceItem(table, new Node[newSize]);
        }
    }

    private Node<K, V>[] replaceItem(Node<K, V>[] oldTab, Node<K, V>[] newTab) {
        for (int i = 0; i < oldTab.length; i++) {
            int index = oldTab[i].hash % newTab.length;
            newTab[index] = oldTab[i];
        }
        return newTab;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private int hash;

        public Node(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }
}
