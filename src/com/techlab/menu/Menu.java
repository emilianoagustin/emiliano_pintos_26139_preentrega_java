package com.techlab.menu;

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
        System.out.println("\nError: you must enter a valid number");
      }
    }
  }
  
  protected double checkDouble(Scanner scanner, String message) {
    while (true) {
      try {
        System.out.print(message);
        return Double.parseDouble(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("\nError: you must enter a valid number");
      }
    }
  }

  protected String checkNoEmptyText(Scanner scanner, String message) {
    while(true) {
      System.out.print(message);
      String text = scanner.nextLine();

      if(!text.isEmpty()) return text.trim();

      System.out.println("\nError: the text cannot be empty.");
    }
  }

  protected boolean checkConfirm(String message) {
    while (true) {
      System.out.print(message);
      String option = scanner.nextLine().trim().toUpperCase();

      if(option.equals("Y")) return true;
      if(option.equals("N")) return false;

      System.out.print("\nError: You entered an invalid option.");
    }
  }
}
