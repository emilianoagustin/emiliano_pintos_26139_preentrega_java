package com.techlab.menu;

import java.util.Scanner;
import java.util.List;
import com.techlab.repository.Repository;
import com.techlab.model.Article;
import com.techlab.model.Category;
import com.techlab.model.ElectronicArticle;
import com.techlab.model.FoodArticle;

public class ArticleMenu extends Menu {
  protected Repository<Article> articleRepository;
  protected Repository<Category> categoryRepository;

  public ArticleMenu(Scanner scanner, Repository<Article> articleRepository, Repository<Category> categoryRepository) {
    super(scanner);
    this.articleRepository = articleRepository;
    this.categoryRepository = categoryRepository;
  }

  // Repository<Article> articleRepository = new Repository<>();
  // Repository<Category> categoryRepository = new Repository<>();

  @Override
    public void showMenu(){
      System.out.println("\n--- ARTICLES MENU ---");
      System.out.println("1 - Create article");
      System.out.println("2 - Show articles");
      System.out.println("3 - Query article");
      System.out.println("4 - Edit article");
      System.out.println("5 - Delete article");
      System.out.println("0 - Go back");
      System.out.println();
    };
  @Override
    public void trigger(){
      int option;

      do {
        showMenu();
        option = checkInteger(scanner, "Enter an option: ");

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
            break;
          case 5:
            deleteArticle();
            break;
          case 0:
            System.out.println("\nGoing back to previous menu...¡Goodbye!");
            break;
          default:
            System.out.println("\nError: you entered an invalid option");
        }
      } while (option != 0);
    };

    private void createArticle() {
      if(categoryRepository.checkEmpty("\nError: A new article needs a category. Category list is empty, please create a category first.")){
        return;
      }

      Article article;
      int articleType = checkType(scanner);
      String articleName = articleName();
      double articlePrice = articlePrice();
      Category category = queryCategoryExists();
      int code = 1;
      
      if(articleType == 1) {
        int articleExpireDate = articleExpireDate();
        article = new FoodArticle(code, articleName, articlePrice, category, articleExpireDate);
      } else {
        int articleWarranty = articleWarranty();
        article = new ElectronicArticle(code, articleName, articlePrice, category, articleWarranty);
      }
      boolean articleAdded = articleRepository.addToList(article);

      if(articleAdded){
        System.out.println("\nArticle created successfully!");
        System.out.println(article);
      }else {
        System.out.println("\nError: article not created.");
      }
    };

    private void showArticles() {
      List<Article> list = articleRepository.getList(); 
      if(articleRepository.checkEmpty("\nError: Article list is empty, please create an article first.")){
        return;
      }

      System.out.println("\n---- ARTICLE LIST ----");
      System.out.println();
      for(Article article : list) {
        System.out.println(article);
      }
    };

    public void queryArticle() {
      if(articleRepository.checkEmpty("\nError: Article list is empty, please create an article first.")){
        return;
      }

      showArticles();

      int code = checkInteger(scanner, "\nEnter the code of the article you want to query: ");
      Article article = articleRepository.searchByCode(code);

      System.out.println("\n ---- ARTICLE FOUND ----");
      System.out.println(article);
    };

    public void editArticle() {};

    public void deleteArticle() {
      if(articleRepository.checkEmpty("\nError: Article list is empty, please create an article first.")){
        return;
      }

      showArticles();

      int code = checkInteger(scanner, "\nEnter the code of the article you want to delete: ");
      Article article = articleRepository.searchByCode(code);

      if(article == null) {
        System.out.println("\nError: Article not found.");
        return;
      }
      
      System.out.println("\n ---- ARTICLE FOUND ----");
      System.out.println(article);

      boolean confirm = checkConfirm("\nConfirm delete? (Y/N): ");

      if (!confirm) {
        System.out.println("\nOperation cancelled.");
      }
      
      boolean deteledArticle = articleRepository.delete(article);
      
      if(deteledArticle){
        System.out.println("\nArticle deleted successfully!");
      }else System.err.println("\nError: The article could not be deleted.");
    };

    public Category queryCategoryExists(){
      int code = checkInteger(scanner, "\nEnter the code of the category you want to add to your article: ");
      Category category = categoryRepository.searchByCode(code);
      return category;
    };
    
    public String articleName(){
      String name = checkNoEmptyText(scanner, "\nEnter the name of the article: ");
      return name;
    };
    public double articlePrice(){
      double price = checkDouble(scanner, "\nEnter the price of the article: ");
      return price;
    };
    public int articleWarranty(){
      int months = checkInteger(scanner, "\nEnter the months of the article warranty: ");
      return months;
    };
    public int articleExpireDate(){
      int date = checkInteger(scanner, "\nEnter the article expire date: ");
      return date;
    };
    public int checkType(Scanner scanner)    {
      System.out.println("--- CREATE A NEW ARTICLE ---");
      System.out.println("1 - Food");
      System.out.println("2 - Electronics");
      
      int type;
      do {
        type = checkInteger(scanner, "\nChoose the type of your article:");
        if (type != 1 && type != 2) {
          System.out.println("Error: you must choose between 1 and 2.");
        }
      }
      while (type != 1 && type != 2);

      return type;
    };
}
