package com.miltonlearn.bean;

public class Dept {
  private String name;

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
