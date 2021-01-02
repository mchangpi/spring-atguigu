package com.miltonlearn.aop;

import org.springframework.stereotype.Component;

@Component
public class User {
  public void add() {
    System.out.println("User Add....");
    //int i = 1 / 0;
  }
}
