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
  
  public boolean checkEmpty(String message) {
    if(list.isEmpty()) {
      System.out.println("------ **** ------");
      System.out.println(message);
      return true;
    }
    return false;
  }
}
