package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenSortToHigh() {
        Item cat = new Item();
        Item dog = new Item();
        cat.setId(1);
        cat.setName("Cat");
        dog.setId(2);
        dog.setName("Dog");
        assertThat(cat.compareTo(dog) , is(-1));
    }

    @Test
    public void whenSortToLow() {
        Item cat = new Item();
        Item dog = new Item();
        cat.setId(1);
        cat.setName("Cat");
        dog.setId(2);
        dog.setName("Dog");
        assertThat(dog.compareTo(cat), is(1));
    }

}