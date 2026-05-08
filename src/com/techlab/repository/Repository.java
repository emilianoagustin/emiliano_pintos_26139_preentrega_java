package repository;

import interfaces.Identifiable;
import java.util.ArrayList;

public class Repository<T extends Identifiable> {
  private ArrayList<T> list = new ArrayList<>();

  public boolean addToList(T object) {
    return true;
  }
  
  public ArrayList<T> getList() {
    return list;
  }
  
  public T searchByCode(int code) {
    T object;
    return object;
  }

  public boolean delete(T object) {
    return true;
  }
  
  public boolean checkEmpty() {
    if(list.isEmpty()) {
      System.out.println("There's no items in the catalogue.");
      return true;
    }
    return false;
  }
}
