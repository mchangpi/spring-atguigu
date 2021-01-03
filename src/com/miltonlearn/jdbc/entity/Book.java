package com.miltonlearn.jdbc.entity;

public class Book {
  private int id;
  private String name;
  private String status;

  public Book() {
    this.id = 0;
    this.name = "";
    this.status = "";
  }

  public Book(int id, String name, String status) {
    this.id = id;
    this.name = name;
    this.status = status;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getStatus() {
    return status;
  }

  @Override
  public String toString() {
    return id + ":" + name + ":" + status;
  }
}

