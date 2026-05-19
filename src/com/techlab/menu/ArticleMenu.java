package menu;

import java.util.Scanner;
import java.util.List;
import repository.Repository;
import model.Article;
import model.Category;
import model.ElectronicArticle;

public class ArticleMenu extends Menu {
  
  public ArticleMenu(Scanner scanner) {
    super(scanner);
  }

  Repository<Article> articleRepository = new Repository<>();
  Repository<Category> categoryRepository = new Repository<>();

  @Override
    public void showMenu(){
      System.out.println("\n--- ARTICLES MENU ---");
      System.out.println("1 - Create article");
      System.out.println("2 - Show articles");
      System.out.println("3 - Query article");
      System.out.println("4 - Edit article");
      System.out.println("5 - Delete article");
      System.out.println("0 - Go back");
    };
  @Override
    public void trigger(){
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
            System.out.println("\nError: you entered an invalid option")
        }
      } while (option != 0);
    };

    public void createArticle() {
      if(categoryRepository.checkEmpty()){
        System.out.println("\nError: please create a category first");
        return;
      }

      String articleType = checkNoEmptyText(scanner, "\nWhich type of article you want to create? Food or Electronic?");
      String articleName = articleName();
      double articlePrice = articlePrice();

      if(articleType.equalsIgnoreCase("food")) articleExpireDate();
      else articleWarranty();
      
      //chequear categoria por codigo y agregarla al articulo
      Article article = new ElectronicArticle(0, articleName, articlePrice, null, 0);
      articleRepository.addToList(article);
    };

    public List<Article> showArticles() {
      return articleRepository.getList();
    };

    public Article queryArticle() {
      int code = checkInteger(scanner, "\nEnter the code of the article you want to query.");
      return articleRepository.searchByCode(code);
    };

    public void editArticle() {};

    public void deleteArticle() {
      int code = checkInteger(scanner, "\nEnter the code of the article you want to delete.");
      Article article = articleRepository.searchByCode(code);
      if(articleRepository.delete(article)) System.out.println("\nThe article with code " + code + " was deleted successfully");
      else System.err.println("\nError: The article could not be deleted");
    };

    public Category queryCategoryExists(){
      int code = checkInteger(scanner, "\nEnter the code of the article you want to query.");
      Category category = categoryRepository.searchByCode(code);
      return category;
    };

    public String articleName(){
      String name = checkNoEmptyText(scanner, "\nEnter the name of the article.");
      return name;
    };
    public double articlePrice(){
      double price = checkDouble(scanner, "\nEnter the price of the article.");
      return price;
    };
    public void articleWarranty(){};
    public void articleExpireDate(){};
}
