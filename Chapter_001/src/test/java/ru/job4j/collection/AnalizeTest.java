package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    People one = new People(1, "One");
    People two = new People(2, "Two");
    People three = new People(3, "Three");
    People four = new People(4, "Four");
    People five = new People(5, "Five");
    List<People> previous = List.of(one, two, three);
    List<People> current = new ArrayList<>(previous);
    Analize analize = new Analize();
    @Before
    public void addTest() {
        current.add(four);
        current.add(five);
        current.set(0, new People(1, "New One"));
    }

    @Test
    public void when2addedThenTwoZeroZero() {
        Info result = analize.diff(previous, current);
        Info inspect = new Info(2, 0, 0);
        assertThat(inspect, is(result));
    }




}