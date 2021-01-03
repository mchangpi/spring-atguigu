package com.miltonlearn.jdbc;

import com.miltonlearn.jdbc.entity.Book;

public interface IBookCall {
  public void add(Book book);

  public void update(Book book);

  public void delete(int id);
}
