package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List findAll() {
        return List.copyOf(items);
    }

    public List findByName(String key) {
        Item[] rsl = new Item[items.size()];
        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            Item name = items.get(i);
            if (name.getName().equals(key)) {
                rsl[count++] = name;
            }
        }
        return List.copyOf(items);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
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

    public boolean replace(int id) {
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
            items.remove(index);
            return true;
        }
       return false;
    }
}
