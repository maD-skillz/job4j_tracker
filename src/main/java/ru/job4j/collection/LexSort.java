package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String leftnNumb = left.split("[.]")[0];
        String rightNumb = right.split("[.]")[0];
        return Integer.compare(Integer.parseInt(leftnNumb), Integer.parseInt(rightNumb));
    }
}