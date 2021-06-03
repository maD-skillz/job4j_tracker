package ru.job4j.tracker;
import java.util.List;
import java.util.ArrayList;

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
        List<Item> arr = tracker.findAll();
        for (Item index : arr) {
            out.println(index);
        }
        return true;
    }
}
