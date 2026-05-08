package model;

import interfaces.Identifiable;

public class Category implements Identifiable{
  private int code;
  private String name;
  private String description;

  public Category(int code, String name, String description) {
    this.code = code;
    this.name = name;
    this.description = description;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getName() {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public int getCode() {
    return this.code;
  }

  @Override
  public String toString() {
    return "{\"Article\":{\"code\":\"" + this.code + "\",\"name\":\"" + this.name + "\",\"description\":" + this.description + "}}";
  }
}
