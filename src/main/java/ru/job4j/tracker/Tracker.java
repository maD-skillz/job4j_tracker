package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<Item>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        items.add(item);
        return item;
    }

    public Item[] findAll() {
        return items.size();
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.size()];
        int count = 0;
        for (int i = 0; i < size; i++) {
            Item name = items.get(i);
            if (name.getName().equals(key)) {
                rsl[count++] = name;
            }
        }
        return Arrays.copyOf(rsl, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != - 1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
    int index = indexOf(id);
    boolean rsl = index != -1;
    if (rsl) {
        items.get(index).setId(id);
    }
    return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.clear();
       /*     System.arraycopy(items, index + 1, items, index, size - index);
            items.size() - 1 = null;
            size--; */
            return true;
        }
       return false;
    }
}
