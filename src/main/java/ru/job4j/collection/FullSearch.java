package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task index : list) {
            if (index.equals(numbers)) {
                numbers.add(index.getNumber());
            }
        }
        return numbers;
    }
}