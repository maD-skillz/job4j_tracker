package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        BiConsumer<Integer, String> biCon = (s, s1) -> System.out.println(s + " " + s1);
        map.forEach(biCon);

        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0 || map.get(i).length() == 4;
       for (Integer i : map.keySet()) {
           System.out.println("key: " + biPred + " value: " + map.get(i));
            }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        System.out.println(sup.get());

        Consumer<String> con = () -> "strings";
        Function<String, String> func = (s) -> System.out.println(s.toUpperCase());
        func.accept(con.get());
    }
}