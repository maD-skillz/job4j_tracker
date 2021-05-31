package ru.job4j.tracker;
import java.util.List;

import java.util.ArrayList;

public class StartUI {

   private  final Output out;

   public StartUI(Output out) {
      this.out = out;
   }

   public void init(Input input, Tracker tracker, List<UserAction>result) {
      boolean run = true;
      while (run) {
         this.showMenu(result);
         int select = input.askInt("Select: ");
         if (select < 0 || select >= result.size()) {
            out.println("Wrong input, you can select: 0 .. " + (result));
            continue;
         }
         UserAction action = result.get(select);
         run = action.execute(input, tracker);
      }
   }

   private void showMenu(List result) {
      out.println("Menu.");
      for (Object index : result) {
         out.println(index + ". ");
      }
   }

   public static void main(String[] args) {
      Output output = new ConsoleOutput();
      Input input = new ValidateInput(output, new ConsoleInput());
      Tracker tracker = new Tracker();
      List<UserAction> result = new ArrayList<>();
      result.add(new CreateAction(output));
      result.add(new ALLItems(output));
      result.add(new ReplaceItem(output));
      result.add(new DeleteItem(output));
      result.add(new FindItemById(output));
      result.add(new FindItemByName(output));
      result.add(new Exit(output));

      new StartUI(output).init(input, tracker, result);
   }
}