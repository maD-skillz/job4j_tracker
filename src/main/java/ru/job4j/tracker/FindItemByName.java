package ru.job4j.tracker;

public class FindItemByName implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String findName = input.askStr("Enter name of items: ");
        Item[] findNameItem = tracker.findByName(findName);
        if (findNameItem.length > 0) {
            for (int i = 0; i < findNameItem.length; i++) {
                System.out.println(findNameItem[i]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены.");
        }
        return true;
    }
}
