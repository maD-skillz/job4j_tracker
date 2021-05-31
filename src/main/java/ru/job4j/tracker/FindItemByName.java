package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class FindItemByName implements UserAction {
    private final Output out;

    public FindItemByName(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String findName = input.askStr("Enter name of items: ");
        List<Item> findItemName = new ArrayList<>();
        if (findItemName.size() > 0) {
            for (Item index : findItemName) {
                out.println(index);
            }
        } else {
            out.println("Заявки с таким именем не найдены.");
        }
        return true;
    }
}
