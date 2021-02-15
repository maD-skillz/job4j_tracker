package ru.job4j.tracker;
import java.util.Arrays;
import java.util.Scanner;

public class StartUI {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Tracker tracker = new Tracker();
      new StartUI().init(scanner, tracker);
   }

   public void init(Scanner scanner, Tracker tracker) {
      Item item = new Item();
      boolean run = true;
      while (run) {
         this.showMenu();
         System.out.print("Select: ");
         int select = Integer.valueOf(scanner.nextLine());
         if (select == 0) {
            System.out.println("=== Create a new Item ====");
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            Item name1 = new Item(name);
            tracker.add(name1);

         } else if (select == 1) {
            System.out.println("=== Show all items ====");
            Item[] arr = tracker.findAll();
            System.out.println(Arrays.toString(arr));

         } else if (select == 2) {
            System.out.println("=== Edit item ====");
            System.out.println("Enter Id: ");
            int getId = Integer.valueOf(scanner.nextLine());
            item.setId(getId);
            System.out.println("Enter Name: ");
            String editName = scanner.nextLine();
            item.setName(editName);
            Item replaceName = new Item(editName);
            if (tracker.replace(getId, replaceName)) {
                  System.out.println("Успешно.");
               } else {
                  System.out.println("Ошибка.");
               }

         } else if (select == 3) {
            System.out.println("=== Delete item ====");
            System.out.println("Enter item to delete: ");
            int delId = Integer.valueOf(scanner.nextLine());
            if (tracker.delete(delId)) {
               System.out.println("Успешно.");
            } else {
               System.out.println("Ошибка.");
            }

         } else if (select == 4) {
            System.out.println("=== Find item by Id ====");
            System.out.println("Enter Id:");
            int findId = Integer.valueOf(scanner.nextLine());
            Item find = tracker.findById(findId);
            if (find != null) {
               System.out.println(findId);
            } else {
               System.out.println("Ошибка.");
            }

         } else if (select == 5) {
            System.out.println("=== Find items by name ====");
            System.out.println("Enter name of items: ");
            String findName = scanner.nextLine();
            Item[] findNameItem = tracker.findByName(findName);
            if (findNameItem != null) {
               System.out.println(Arrays.toString(findNameItem));
            } else {
               System.out.println("Заявки с таким именем не найдены.");
            }

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