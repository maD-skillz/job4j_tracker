package ru.job4j.tracker;

public class ALLItems implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] arr = tracker.findAll();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        return true;
    }
}
