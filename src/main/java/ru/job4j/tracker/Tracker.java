package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] namesWithoutNull = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            Item name = items[i];
            if (name != null) {
                namesWithoutNull[size] = name;
                size++;
            }
        }
        namesWithoutNull = Arrays.copyOf(namesWithoutNull, size);
        for (int i = 0; i < namesWithoutNull.length; i++) {
            System.out.println(namesWithoutNull[i]);
        }
        return namesWithoutNull;
    }

    public Item[] findByName(String key) {
        Item[] equalNames = new Item[items.length];
        Item item = new Item();
        for (int i = 0; i < items.length; i++) {
             Item name = items[i];
            if (item.getName().equals(key)) {
                equalNames[size] = name;
                size++;
            }
        }
        equalNames = Arrays.copyOf(equalNames, size);
        for (int i = 0; i < equalNames.length; i++) {
            System.out.println(equalNames[i]);
        }
        return equalNames;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}