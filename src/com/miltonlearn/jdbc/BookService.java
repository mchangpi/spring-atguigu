package com.miltonlearn.jdbc;

import com.miltonlearn.jdbc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  @Autowired
  private BookCall bookCall;

  public void addBook(Book book) {
    bookCall.add(book);
  }
}
