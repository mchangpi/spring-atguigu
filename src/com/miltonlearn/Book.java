package com.miltonlearn;

import java.util.List;

public class Book {
  private String bname;
  private String bauthor;
  private String price;
  private List<String> list;

  public void setBname(String bname) {
    this.bname = bname;
  }

  public void setBauthor(String bauthor) {
    this.bauthor = bauthor;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public void setList(List<String> list) {
    this.list = list;
  }

  public void printInfo() {
    System.out.println(bname + ":" + bauthor + ":" + this.price + ":" + list);
  }
}
