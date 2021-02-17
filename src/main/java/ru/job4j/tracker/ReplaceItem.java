package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int getId = input.askInt("Enter Id: ");
        String editName = input.askStr("Enter Name: ");
        Item replaceName = new Item(editName);
        if (tracker.replace(getId, replaceName)) {
            System.out.println("Успешно.");
        } else {
            System.out.println("Ошибка.");
        }
        return true;
    }
}
