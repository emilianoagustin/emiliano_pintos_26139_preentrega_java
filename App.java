
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int option;

    do {
        System.out.println("\n==========================================");
        System.out.println("   SISTEMA BÁSICO DE ARTÍCULOS - CLASE 1");
        System.out.println("==========================================");
        System.out.println("1 - Ingresar artículo");
        System.out.println("2 - Listar artículos");
        System.out.println("3 - Consultar un artículo");
        System.out.println("4 - Modificar un artículo");
        System.out.println("5 - Eliminar un artículo");
        System.out.println("0 - Salir");
        System.out.println("==========================================");

        option = checkInteger(scanner, "Enter an option: ");

        switch (option) {
          case 1:
            System.out.println("\nOption 1");
            break;
          case 2:
            System.out.println("\nOption 2");
            break;
          case 3:
            System.out.println("\nOption 3");
            break;
          case 4:
            System.out.println("\nOption 4");
            break;
          case 5:
            System.out.println("\nOption 5");
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

  public static String checkNoEmptyText(Scanner scanner, String message) {
    while(true) {
      System.out.print(message);
      String text = scanner.nextLine();

      if(!text.isEmpty()) return text.trim();

      System.out.println("Error: the text cannot be empty.");
    }
  }
}
