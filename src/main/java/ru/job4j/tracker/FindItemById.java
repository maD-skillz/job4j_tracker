package ru.job4j.tracker;

public class FindItemById implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int findId = input.askInt("Enter Id:");
        Item find = tracker.findById(findId);
        if (find != null) {
            System.out.println(findId);
        } else {
            System.out.println("Ошибка.");
        }
        return true;
    }
}
