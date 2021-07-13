package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListUsage {
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(-2);
        arrList.add(-1);
        arrList.add(0);
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.add(4);
        arrList.add(5);
        arrList.add(6);
        List<Integer> positiveNumbers = arrList.stream().filter((x) ->
                (x > 0)).collect(Collectors.toList());
        for (int i : positiveNumbers) {
            System.out.println(i);
        }
    }
}
