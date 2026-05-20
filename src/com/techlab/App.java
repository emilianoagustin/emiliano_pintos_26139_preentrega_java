package com.techlab;

import java.util.Scanner;

import com.techlab.menu.ArticleMenu;
import com.techlab.menu.CategoryMenu;
import com.techlab.menu.Menu;

import com.techlab.model.Article;
import com.techlab.model.Category;
import com.techlab.repository.Repository;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Repository<Article> articleRepository = new Repository<>();
    Repository<Category> categoryRepository = new Repository<>();

    Menu articleMenu = new ArticleMenu(scanner, articleRepository, categoryRepository);
    Menu categoryMenu = new CategoryMenu(scanner, articleRepository, categoryRepository);

    int option;

    do {
        System.out.println("\n==========================================");
        System.out.println("   BASIC ARTICLE SYSTEM - CLASS 1");
        System.out.println("==========================================");
        System.out.println("1 - Show articles menu");
        System.out.println("2 - Show categories menu");
        System.out.println("0 - Exit");
        System.out.println("==========================================");
        System.out.println();

        option = Menu.checkInteger(scanner, "Enter an option: ");

        switch (option) {
          case 1:
            articleMenu.trigger();
            break;
          case 2:
            categoryMenu.showMenu();
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