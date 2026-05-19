

import java.util.ArrayList;
import java.util.Scanner;

import menu.ArticleMenu;
import menu.CategoryMenu;
import menu.Menu;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int option;

    do {
        System.out.println("\n==========================================");
        System.out.println("   BASIC ARTICLE SYSTEM - CLASS 1");
        System.out.println("==========================================");
        System.out.println("1 - Show articles menu");
        System.out.println("2 - Show categories menu");
        System.out.println("0 - Exit");
        System.out.println("==========================================");

        option = Menu.checkInteger(scanner, "Enter an option: ");

        switch (option) {
          case 1:
            System.out.println("\nOption 1");
            break;
          case 2:
            System.out.println("\nOption 2");
            break;
          case 0:
            System.out.println("\nExiting system...¡Goodbye!");
            break;
        
          default:
            System.out.println("\nError: you entered an invalid option");
        }
    } while (option != 0);
    scanner.close();
  }
}
