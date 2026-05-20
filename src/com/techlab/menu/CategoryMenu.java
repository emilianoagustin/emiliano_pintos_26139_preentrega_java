package com.techlab.menu;

import java.util.Scanner;
import java.util.List;

import com.techlab.model.Article;
import com.techlab.model.Category;
import com.techlab.repository.Repository;

public class CategoryMenu extends Menu{
  
  protected Repository<Article> articleRepository;
  protected Repository<Category> categoryRepository;

  public CategoryMenu(Scanner scanner, Repository<Article> articleRepository, Repository<Category> categoryRepository) {
    super(scanner);
    this.articleRepository = articleRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public void showMenu(){
    System.out.println("\n--- ARTICLES MENU ---");
    System.out.println("1 - Create category");
    System.out.println("2 - Show categories");
    System.out.println("3 - Query category");
    System.out.println("4 - Edit category");
    System.out.println("5 - Delete category");
    System.out.println("0 - Go back");
    System.out.println();
  };

  @Override
  public void trigger(){
    showMenu();
    int option = checkInteger(scanner, "Enter an option: ");

      do {
        switch (option) {
          case 1:
            createArticle();
            break;
          case 2:
            showArticles();
            break;
          case 3:
            queryArticle();
            break;
          case 4:
            editArticle();
          case 5:
            deleteArticle();
          case 0:
            System.out.println("\nGoing back to previous menu...¡Goodbye!");
            break;
          default:
            System.out.println("\nError: you entered an invalid option");
        }
      } while (option != 0);
  }
}
