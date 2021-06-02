package ru.job4j.tracker;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
       @Test
    public void whenCreateItem() {
           Output out = new StubOutput();
           String newItem = "New Item";
        Input in = new StubInput(
                new String[]{"0", newItem, "1"}
        );
        Tracker tracker = new Tracker();
           List<UserAction> result = new ArrayList<>();
               result.add(new CreateAction(out));
               result.add(new Exit(out));

               new StartUI(out).init(in, tracker, result);
        assertThat(tracker.findAll(), is(newItem));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        /* Добавим в tracker новую заявку */
        Item addItem = tracker.add(new Item("Replace this name"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "Replaced name";
        Input in = new StubInput(
                new String[] {"0",String.valueOf(addItem.getId()), replacedName, "1"}
        );
        List<UserAction> result = new ArrayList<>();
            result.add(new ReplaceItem(out));
            result.add(new Exit(out));

        new StartUI(out).init(in, tracker, result);
        assertThat(tracker.findById(addItem.getId()), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item delItem = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[] {"0", String.valueOf(delItem.getId()), "1"}
        );
        List<UserAction> result = new ArrayList<>();
        result.add(new DeleteItem(out));
        result.add(new Exit(out));

        new StartUI(out).init(in, tracker, result);
        assertThat(tracker.findById(delItem.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0",
                });
        Tracker tracker = new Tracker();
        List<UserAction> result = new ArrayList<>();
        result.add(new Exit(out));

        new StartUI(out).init(in, tracker, result);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. "
                        + "=== Exit Program ===="
                        + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"8", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> result = new ArrayList<>();
        result.add(new Exit(out));

        new StartUI(out).init(in, tracker, result);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit Program ====%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. === Exit Program ====%n"
                                + "0. Exit%n"
                )
        ));
    }

    @Test
    public void whenFindAllItems() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Item item = tracker.add(new Item("item"));
        Input in = new StubInput(
                new String[] {"0", "1"});
        List<UserAction> result = new ArrayList<>();
        result.add(new ALLItems(out));
        result.add(new Exit(out));

        new StartUI(out).init(in, tracker, result);
        assertThat(out.toString(), is(String.format("Menu.%n"
                + "0. === Show all items ====%n"
                + "1. === Exit Program ====%n"
                + "=== Show all items ====%n"
                + item + "%n"
                + "Menu.%n"
                + "0. === Show all items ====%n"
                + "1. === Exit Program ====%n"
                + "0. Exit%n")));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        String find = "Name to find";
        Input in = new StubInput(
                new String[] {"0", find, "1"}
        );
        Item nameToFind = tracker.add(new Item("Name to find"));
        List<UserAction> result = new ArrayList<>();
        result.add(new FindItemByName(out));
        result.add(new Exit(out));

        new StartUI(out).init(in, tracker, result);
        assertThat(out.toString(), is(String.format("Menu.%n"
                + "0. === Find items by name ====%n"
                + "1. === Exit Program ====%n"
                + nameToFind + "%n"
                + "Menu.%n"
                + "0. === Find items by name ====%n"
                + "1. === Exit Program ====%n"
                + "0. Exit%n")));
       }

       @Test
    public void whenFindById() {
           Tracker tracker = new Tracker();
           Output out = new StubOutput();
           Item findId = tracker.add(new Item("Id"));
           Input in = new StubInput(
                   new String[]{"0", String.valueOf(findId.getId()), "1"});
           List<UserAction> result = new ArrayList<>();
           result.add(new FindItemById(out));
           result.add(new Exit(out));

           new StartUI(out).init(in, tracker, result);
           assertThat(out.toString(), is(String.format("Menu.%n"
                   + "0. === Find item by Id ====%n"
                   + "1. === Exit Program ====%n"
                   + findId + "%n"
                   + "Menu.%n"
                   + "0. === Find item by Id ====%n"
                   + "1. === Exit Program ====%n"
                   + "0. Exit%n")));
       }
       }
