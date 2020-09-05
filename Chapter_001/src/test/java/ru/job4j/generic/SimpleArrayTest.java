package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void whenAdd() {
        SimpleArray<String> strings = new SimpleArray<>(10);
        assertThat(strings.add("a"), is(true));
    }

    @Test
    public void whenGet() {
        SimpleArray<String> strings = new SimpleArray<>(10);
        strings.add("a");
        strings.add("b");
        strings.add("c");
        assertThat(strings.get(0), is("a"));
    }

    @Test
    public void whenRemove() {
        SimpleArray<String> strings = new SimpleArray<>(10);
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.remove(0);
        assertThat(strings.get(0), is("b"));
    }

    @Test
    public void whenIterator() {
        SimpleArray<String> strings = new SimpleArray<>(10);
        strings.add("a");
        strings.add("b");
        strings.add("c");
        Iterator<String> iterator = strings.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("a"));
    }
}