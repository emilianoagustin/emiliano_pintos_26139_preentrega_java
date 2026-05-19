package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
  protected Scanner scanner;

  public Menu(Scanner scanner) {
    this.scanner = scanner;
  }

  public abstract void showMenu();

  public abstract void trigger();

  public int checkInteger(Scanner scanner, String message) {
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

  
  // TODO:
  // Metodos checkDouble y readYesNo
}
