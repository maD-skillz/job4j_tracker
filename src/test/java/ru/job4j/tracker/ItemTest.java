package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenSortToHigh() {
        Item cat = new Item(1, "Cat");
        Item dog = new Item(2, "Dog");
        Item fish = new Item(3, "Fish");

        List<Item> itemList = new ArrayList<>();
        itemList.add(fish);
        itemList.add(dog);
        itemList.add(cat);
        Collections.sort(itemList, new SortAscByName());

        List<Item> expectedList = new ArrayList<>();
        expectedList.add(cat);
        expectedList.add(dog);
        expectedList.add(fish);
        assertThat(itemList, is(expectedList));
    }

    @Test
    public void whenSortToLow() {
        Item cat = new Item(1, "Cat");
        Item dog = new Item(2, "Dog");
        Item fish = new Item(3, "Fish");

        List<Item> itemList = new ArrayList<>();
        itemList.add(dog);
        itemList.add(cat);
        itemList.add(fish);
        Collections.sort(itemList, new SortDescByName());

        List<Item> expectedList = new ArrayList<>();
        expectedList.add(fish);
        expectedList.add(dog);
        expectedList.add(cat);
        assertThat(itemList, is(expectedList));
    }
}