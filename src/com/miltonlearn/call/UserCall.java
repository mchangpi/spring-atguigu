package com.miltonlearn.call;

import org.springframework.stereotype.Repository;

@Repository(value = "userCallObj")
public class UserCall implements IUserCall {
  @Override
  public int add(int a, int b) {
    return a + b;
  }

  @Override
  public String update(String id) {
    System.out.println("User Call update... " + id);
    return id;
  }
}

