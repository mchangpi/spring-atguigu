package com.miltonlearn;

public class Order {
  private String name;
  //private String address;

  public Order() {
    System.out.println(this + " 1. call non param Constructor");
  }

  public void setName(String name) {
    this.name = name;
    System.out.println(this + " 2. Set name " + name);
  }

  public void init() {
    System.out.println(this + " 3. call Init ");
  }

  public void onDestroy() {
    System.out.println(this + " 5. Been Destroyed");
  }

  public void printOrder() {
    System.out.println(this.name);
  }
}

