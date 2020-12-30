package com.miltonlearn;

public class Book {
  private String bname;
  private String bauthor;
  private String price;

  public void setBname(String bname) {
    this.bname = bname;
  }

  public void setBauthor(String bauthor) {
    this.bauthor = bauthor;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public void printInfo() {
    System.out.println(bname + " ,author: " + bauthor + " ,price: " + this.price);
  }
}
