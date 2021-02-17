package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int delId = input.askInt("Enter item to delete: ");
        if (tracker.delete(delId)) {
            System.out.println("Успешно.");
        } else {
            System.out.println("Ошибка.");
        }
        return true;
    }
}
