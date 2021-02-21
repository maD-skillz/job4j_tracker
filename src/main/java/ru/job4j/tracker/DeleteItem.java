package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int delId = input.askInt("Enter item to delete: ");
        if (tracker.delete(delId)) {
            out.println("Успешно.");
        } else {
            out.println("Ошибка.");
        }
        return true;
    }
}
