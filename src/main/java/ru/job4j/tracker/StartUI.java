package ru.job4j.tracker;


import java.util.ArrayList;

public class StartUI {
   private  final Output out;

   public StartUI(Output out) {
      this.out = out;
   }

   public void init(Input input, Tracker tracker, UserAction[] actions) {
      boolean run = true;
      while (run) {
         this.showMenu(actions);
         int select = input.askInt("Select: ");
         if (select < 0 || select >= actions.length) {
            out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
            continue;
         }
         UserAction action = actions[select];
         run = action.execute(input, tracker);
      }
   }

   private void showMenu(UserAction[] actions) {
      out.println("Menu.");
      for (int index = 0; index < actions.length; index++) {
         out.println(index + ". " + actions[index].name());
      }
   }

   public static void main(String[] args) {
      Output output = new ConsoleOutput();
      Input input = new ValidateInput(output, new ConsoleInput());
      Tracker tracker = new Tracker();
      List<Item> result = new ArrayList<>();
      result.add(new CreateAction(output));
      result.add(new ALLItems(output));
      result.add(new ReplaceItem(output));
      result.add(new DeleteItem(output));
      result.add(new FindItemById(output));
      result.add(new FindItemByName(output));
      result.add(new Exit(output));
    /*  UserAction[] actions = {
              new CreateAction(output),
              new ALLItems(output),
              new ReplaceItem(output),
              new DeleteItem(output),
              new FindItemById(output),
              new FindItemByName(output),
              new Exit(output) */

     new StartUI(output).init(input, tracker, result);
   }
}