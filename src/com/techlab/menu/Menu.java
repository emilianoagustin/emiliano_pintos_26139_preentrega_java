package menu;

import java.util.Scanner;

public abstract class Menu {
  protected Scanner scanner;

  public Menu(Scanner scanner) {
    this.scanner = scanner;
  }

  public abstract void showMenu();

  public abstract void trigger();

  public static int checkInteger(Scanner scanner, String message) {
    while(true) {
      try {
        System.out.print(message);
        return Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Error: you must enter a valid number");
      }
    }
  }
  
  public double checkDouble(Scanner scanner, String message) {
    while (true) {
      try {
        System.out.print(message);
        return Double.parseDouble(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Error: you must enter a valid number");
      }
    }
  }

  public String checkNoEmptyText(Scanner scanner, String message) {
    while(true) {
      System.out.print(message);
      String text = scanner.nextLine();

      if(!text.isEmpty()) return text.trim();

      System.out.println("Error: the text cannot be empty.");
    }
  }
  
  public String checkType(Scanner scanner)    {
    while (true) {

      System.out.println("Choose the type of your article:");
      System.out.println("- Food");
      System.out.println("- Electronics");

      String type = scanner.nextLine().trim().toLowerCase();

      if (type.equals("food") || type.equals("electronics")) {
        return type;
      }

      System.out.println("Invalid type. Please try again.");
    }
  }
}
