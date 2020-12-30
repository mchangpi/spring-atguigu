package com.miltonlearn;

public class Book {
  private String bname;
  private String bauthor;

  public void setBname(String bname) {
    this.bname = bname;
  }

  public void setBauthor(String bauthor) {
    this.bauthor = bauthor;
  }

  public void printInfo() {
    System.out.println(bname + " " + bauthor);
  }
}
