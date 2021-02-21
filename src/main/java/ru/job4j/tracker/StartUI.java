package ru.job4j.tracker;


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
         UserAction action = actions[select];
         run = action.execute(input, tracker);
      }
   }

   private void showMenu(UserAction[] actions) {
      out.println("Menu.");
      for (int index = 0; index < actions.length; index++) {
         System.out.println(index + ". " + actions[index].name());
      }
   }

   public static void main(String[] args) {
      Input input = new ConsoleInput();
      Output output = new ConsoleOutput();
      Tracker tracker = new Tracker();
      UserAction[] actions = {
              new CreateAction(output),
              new ALLItems(output),
              new ReplaceItem(output),
              new DeleteItem(output),
              new FindItemById(output),
              new FindItemByName(output),
              new Exit(output)
      };
      new StartUI(output).init(input, tracker, actions);
   }
}