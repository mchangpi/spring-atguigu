package com.miltonlearn;

public class Order {
  private String oname;
  private String address;

  public Order(String oname, String address) {
    this.oname = oname;
    this.address = address;
  }

  public void printOrder() {
    System.out.println(this.oname + " to addr " + this.address);
  }
}

