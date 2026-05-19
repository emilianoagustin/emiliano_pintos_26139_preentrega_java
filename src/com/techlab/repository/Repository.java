package com.techlab.repository;

import com.techlab.interfaces.Identifiable;
import java.util.ArrayList;
import java.util.List;

public class Repository<T extends Identifiable> {
  private ArrayList<T> list = new ArrayList<>();

  public boolean addToList(T object) {
    if(object == null) {
      return false;
    }
    if(searchByCode(object.getCode()) != null) {
      return false;
    }
    return list.add(object);
  }
  
  public List<T> getList() {
    return new ArrayList<>(list);
  }
  
  public T searchByCode(int code) {
    for(T object : list) {
      if(object.getCode() == code) {
        return object;
      }
    };
    return null;
  }

  public boolean delete(T object) {
    if(object == null) {
      return false;
    }
    return list.remove(object);
  }
  
  public boolean checkEmpty() {
    if(list.isEmpty()) {
      System.out.println("There's no items in this list.");
      return true;
    }
    return false;
  }
}
