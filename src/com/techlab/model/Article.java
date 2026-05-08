package model;

import interfaces.Calculable;
import interfaces.Identifiable;

public abstract class Article implements Identifiable, Calculable{
  protected int code;
  protected String name;
  protected double price;
  protected Category category;

  public Article(int code, String name, double price, Category category) {
    this.code = code;
    this.name = name;
    this.price = price;
    this.category = category;
  }

  public void setCode(int code){
    this.code = code;
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return this.price;
  }
  public void setPrice(double price) {
    this.price = price;
  }

  public Category getCategory() {
    return this.category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public abstract String getArticleType();
  public abstract String getSpecificDetail();

  @Override
  public int getCode() {
    return this.code;
  }

  @Override
  public String toString() {
    return "{\"Article\":{\"code\":\"" + this.code + "\",\"name\":\"" + this.name + "\",\"price\":" + this.price + "}}";
  }
}
