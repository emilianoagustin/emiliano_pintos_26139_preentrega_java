package model;

public class FoodArticle extends Article {
  private int daysUntilExpires;

  public FoodArticle(int code, String name, double price, Category category, int daysUntilExpires) {
    super(code, name, price, category);
    this.daysUntilExpires = daysUntilExpires;
  }

  public int getDaysUntilExpires() {
    return this.daysUntilExpires;
  }
  public void setDaysUntilExpires(int days) {
    this.daysUntilExpires = days;
  }

  @Override
  public String getArticleType() {
    return " ";
  }
  @Override
  public double calculateFinalPrice() {
    return 0;
  }
  @Override
  public String getSpecificDetail() {
    return " ";
  }
}
