package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.generic.SimpleArray;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedListTest {

    @Test
    public void whenAddAndGet() {
        SimpleLinkedList<String> strings = new SimpleLinkedList<>();
        strings.add("a");
        assertThat(strings.get(0), is("a"));
    }

    @Test
    public void whenIterator() {
        SimpleLinkedList<String> strings = new SimpleLinkedList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        Iterator<String> iterator = strings.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("a"));
    }

}