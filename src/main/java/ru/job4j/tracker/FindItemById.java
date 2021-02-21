package ru.job4j.tracker;

public class FindItemById implements UserAction {
    private final Output out;

    public FindItemById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int findId = input.askInt("Enter Id:");
        Item find = tracker.findById(findId);
        if (find != null) {
            out.println(findId);
        } else {
            out.println("Ошибка.");
        }
        return true;
    }
}
