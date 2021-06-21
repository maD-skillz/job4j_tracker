package ru.job4j.tracker;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByNameToLow implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        List<Integer> list = first.getName().compareTo(second.getName());
        return Collections.sort(list, Collections.reverseOrder());
    }
}
