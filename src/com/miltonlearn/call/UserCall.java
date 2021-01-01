package com.miltonlearn.call;

import org.springframework.stereotype.Repository;

@Repository(value = "userCallObj")
public class UserCall implements IUserCall {
  @Override
  public void update() {
    System.out.println("User Call update...");
  }
}

