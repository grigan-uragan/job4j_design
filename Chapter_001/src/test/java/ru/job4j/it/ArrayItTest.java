package ru.job4j.it;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class ArrayItTest {

    @Test
    public void whenMultiCallHasNextThenTrue() {
        ArrayIt iterator = new ArrayIt(new int[]{1, 2, 3, 4, 5});
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        ArrayIt iterator = new ArrayIt(new int[]{1, 2, 3, 4, 5});
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        ArrayIt iterator = new ArrayIt(new int[]{});
        iterator.next();
    }
}