package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void whenOneAddTwoDeleteTwoChangedThenOneTwoTwo() {
        Analize analize = new Analize();
        Analize.User one = new Analize.User(1, "One");
        Analize.User two = new Analize.User(2, "Two");
        Analize.User three = new Analize.User(3, "Three");
        Analize.User four = new Analize.User(4, "Four");
        Analize.User fourChange = new Analize.User(4, "Four+");
        Analize.User five = new Analize.User(5, "Five");
        Analize.User fiveChange = new Analize.User(5, "Five+");
        Analize.User six = new Analize.User(6, "Six");
        List<Analize.User> previous = new ArrayList<>();
        previous.add(one);
        previous.add(two);
        previous.add(three);
        previous.add(four);
        previous.add(five);
        List<Analize.User> current = new ArrayList<>();
        current.add(three);
        current.add(fiveChange);
        current.add(fourChange);
        current.add(six);
        assertThat(analize.diff(previous, current), is(new Analize.Info(1, 2, 2)));
    }
}