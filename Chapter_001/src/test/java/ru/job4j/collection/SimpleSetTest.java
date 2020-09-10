package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddDifferentElements() {
        SimpleSet<Integer> numbers = new SimpleSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        assertThat(numbers.getSize(), is(3));
    }

    @Test
    public void whenAddEqualsElements() {
        SimpleSet<Integer> numbers = new SimpleSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        assertThat(numbers.getSize(), is(2));
    }

    @Test
    public void whenIteratorGetNext() {
        SimpleSet<Integer> numbers = new SimpleSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        Iterator<Integer> iterator = numbers.iterator();
        iterator.next();
        assertThat(iterator.next(), is(2));
    }

}