package ru.job4j.tracker;
import java.util.List;

import java.util.ArrayList;

public class StartUI {

   private  final Output out;

   public StartUI(Output out) {
      this.out = out;
   }

   public void init(Input input, Tracker tracker, List result) {
      boolean run = true;
      while (run) {
         this.showMenu(result);
         int select = input.askInt("Select: ");
         if (select < 0 || result > result.size()) {
            out.println("Wrong input, you can select: 0 .. " + (result));
            continue;
         }
         List result = result[select];
         run = result.execute(input, tracker);
      }
   }

   private void showMenu(List result) {
      out.println("Menu.");
      for (Object index : result) {
         out.println(index + ". " + result[index].name());
      }
   }

   public static void main(String[] args) {
      Output output = new ConsoleOutput();
      Input input = new ValidateInput(output, new ConsoleInput());
      Tracker tracker = new Tracker();
      List<Item> result = new ArrayList<>;
      result.add(new Item CreateAction(output));
      result.add(new ALLItems(output));
      result.add(new ReplaceItem(output));
      result.add(new DeleteItem(output));
      result.add(new FindItemById(output));
      result.add(new FindItemByName(output));
      result.add(new Exit(output));
 /*     UserAction[] actions = {
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