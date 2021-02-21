package ru.job4j.tracker;

public class ALLItems implements UserAction {
    private final Output out;

    public ALLItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ====");
        Item[] arr = tracker.findAll();
        for (int i = 0; i < arr.length; i++) {
            out.println(arr[i]);
        }
        return true;
    }
}
