package ru.job4j.tracker;


public class StartUI {

   public static void main(String[] args) {
      Input input = new ConsoleInput();
      Tracker tracker = new Tracker();
      new StartUI().init(input, tracker);
   }

   public static void createItem(Input input, Tracker tracker) {
      System.out.println("=== Create a new Item ====");
      String name = input.askStr("Enter name: ");
      Item item = new Item(name);
      tracker.add(item);
   }

   public static void showAllItems(Input input, Tracker tracker) {
      System.out.println("=== Show all items ====");
      Item[] arr = tracker.findAll();
      for (int i = 0; i < arr.length; i++) {
         System.out.println(arr[i]);
      }
   }

   public static void editItem(Input input, Tracker tracker) {
      System.out.println("=== Edit item ====");
      int getId = input.askInt("Enter Id: ");
      Item item = new Item();
      item.setId(getId);
      String editName = input.askStr("Enter Name: ");
      item.setName(editName);
      Item replaceName = new Item(editName);
      if (tracker.replace(getId, replaceName)) {
         System.out.println("Успешно.");
      } else {
         System.out.println("Ошибка.");
      }
   }

   public static void deleteItem(Input input, Tracker tracker) {
      System.out.println("=== Delete item ====");
      int delId = input.askInt("Enter item to delete: ");
      if (tracker.delete(delId)) {
         System.out.println("Успешно.");
      } else {
         System.out.println("Ошибка.");
      }
   }

   public static void findItemById (Input input, Tracker tracker) {
      System.out.println("=== Find item by Id ====");
      int findId = input.askInt("Enter Id:");
      Item find = tracker.findById(findId);
      if (find != null) {
         System.out.println(findId);
      } else {
         System.out.println("Ошибка.");
      }
   }

   public static void findItemsByName (Input input, Tracker tracker) {
      System.out.println("=== Find items by name ====");
      String findName = input.askStr("Enter name of items: ");
      Item[] findNameItem = tracker.findByName(findName);
      if (findNameItem.length > 0) {
         for (int i = 0; i < findNameItem.length; i++) {
            System.out.println(findNameItem[i]);
         }
      } else {
         System.out.println("Заявки с таким именем не найдены.");
      }
   }

   public void init(Input input, Tracker tracker) {
      Item item = new Item();
      boolean run = true;
      while (run) {
         this.showMenu();
         int select = input.askInt("Select: ");
         if (select == 0) {
            StartUI.createItem(input, tracker);

         } else if (select == 1) {
            StartUI.showAllItems(input, tracker);

         } else if (select == 2) {
            StartUI.editItem(input, tracker);

         } else if (select == 3) {
            StartUI.deleteItem(input, tracker);

         } else if (select == 4) {
            StartUI.findItemById(input, tracker);

         } else if (select == 5) {
            StartUI.findItemsByName(input, tracker);

         } else if (select == 6) {
            System.out.println("Exit Program");
            run = false;
         }
      }
   }

   private void showMenu() {
      System.out.println("Menu.");
      System.out.println("0. Add new Item");
      System.out.println("1. Show all items");
      System.out.println("2. Edit item");
      System.out.println("3. Delete item");
      System.out.println("4. Find item by Id");
      System.out.println("5. Find items by name");
      System.out.println("6. Exit Program");
   }
}