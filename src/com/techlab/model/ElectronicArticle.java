package com.techlab.model;

public class ElectronicArticle extends Article {
  private int warrantyMonths;

  public ElectronicArticle(int code, String name, double price, Category category, int warrantyMonths){
    super(code, name, price, category);
    this.warrantyMonths = warrantyMonths;
  }

  public int getWarrantyMonths() {
    return this.warrantyMonths;
  }
  public void setWarrantyMonths(int months) {
    this.warrantyMonths = months;
  }
  
  @Override
  public String getArticleType() {
    return "Electronic";
  }
  @Override
  public double calculateFinalPrice() {
    return 0;
  }
  @Override
  public String getSpecificDetail() {
    return "Warranty: " + warrantyMonths + " months.";
  }
}
