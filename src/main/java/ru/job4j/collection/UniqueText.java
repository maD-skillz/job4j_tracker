package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();

        /* for-each origin -> new HashSet. */
        for (String index : origin) {
            check.add(index);
        }
        /* for-each text -> hashSet.contains */
        for (String index2 : text) {
            if (check.contains(index2)) {
                return true;
            }

        }

        return false;
    }
}