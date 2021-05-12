package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
       @Test
    public void whenCreateItem() {
           Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        /* Добавим в tracker новую заявку */
        Item addItem = tracker.add(new Item("Replaced name"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "Replaced name";
        Input in = new StubInput(
                new String[] {"0",String.valueOf(addItem.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceItem(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(addItem.getId()).getName(), is(replacedName));
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
        UserAction[] actions = {
                new DeleteItem(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(delItem.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0",
                });
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
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
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
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
        Input in = new StubInput(
                new String[] {"0", "1"});
        Item item = tracker.add(new Item("item"));
        UserAction[] actions = {
                new ALLItems(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
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
        String find = "Finded Name";
        Input in = new StubInput(
                new String[] {"0", find, "1"}
        );
        Item findedName = tracker.add(new Item("Finded Name"));
        UserAction[] actions = {
                new FindItemByName(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(String.format("Menu.%n"
                + "0. === Find items by name ====%n"
                + "1. === Exit Program ====%n"
                + findedName + "%n"
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
           UserAction[] actions = {
                   new FindItemById(out),
                   new Exit(out)
           };
           new StartUI(out).init(in, tracker, actions);
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
