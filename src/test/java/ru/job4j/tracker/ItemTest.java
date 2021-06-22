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
        Item cat = new Item();
        Item dog = new Item();
        Item fish = new Item();

        fish.setId(3);
        fish.setName("Fish");
        dog.setId(2);
        dog.setName("Dog");
        cat.setId(1);
        cat.setName("Cat");

        List<Item> itemList = new ArrayList<>();
        itemList.add(fish);
        itemList.add(dog);
        itemList.add(cat);
        Collections.sort(itemList, new SortAscByName());

        List<Item> expectedList = new ArrayList<>();
        expectedList.add(cat);
        expectedList.add(dog);
        expectedList.add(fish);
        assertThat(itemList , is(expectedList));
    }

    @Test
    public void whenSortToLow() {
        Item cat = new Item();
        Item dog = new Item();
        Item fish = new Item();

        cat.setId(1);
        cat.setName("Cat");
        fish.setId(3);
        fish.setName("Fish");
        dog.setId(2);
        dog.setName("Dog");

        List<Item> itemList = new ArrayList<>();
        itemList.add(fish);
        itemList.add(dog);
        itemList.add(cat);
        Collections.sort(itemList, new SortDescByName());

        List<Item> expectedList = new ArrayList<>();
        expectedList.add(fish);
        expectedList.add(dog);
        expectedList.add(cat);
        assertThat(itemList , is(expectedList));
    }

}