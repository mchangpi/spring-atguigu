package com.miltonlearn.jdbc;

import com.miltonlearn.jdbc.entity.Book;

import java.util.List;

public interface IBookCall {
  public void add(Book book);

  public void update(Book book);

  public void delete(int id);

  public int count();

  public Book find(int id);

  public List<Book> all();
}
