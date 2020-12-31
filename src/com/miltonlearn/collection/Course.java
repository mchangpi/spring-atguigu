package com.miltonlearn.collection;

public class Course {
  private String name;

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
