package com.miltonlearn.bean;

public class Employee {
  private String name;
  private String gender;
  private Dept dept;

  public void setDept(Dept dept) {
    this.dept = dept;
  }

  public Dept getDept() {
    return dept;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void printInfo() {
    System.out.println(dept + ":" + name + ":" + gender);
  }
}
