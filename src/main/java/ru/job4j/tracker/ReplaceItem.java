package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    private final Output out;

    public ReplaceItem(Output out) {
        this.out = out;
    }

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
            out.println("Успешно.");
        } else {
            out.println("Ошибка.");
        }
        return true;
    }
}
