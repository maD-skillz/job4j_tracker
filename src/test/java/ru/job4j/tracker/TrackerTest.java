package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id), is("Bug with description"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("replaced item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), "5",
                "replaced item"
        };

        Item replaced = tracker.findById(item.getId());
        assertThat(replaced, is(answers));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));

        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> result = new ArrayList<>();
        result.add(new DeleteItem(out));
        result.add(new Exit(out));

        new StartUI(out).init(in, tracker, result);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}