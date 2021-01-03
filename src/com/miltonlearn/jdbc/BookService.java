package com.miltonlearn.jdbc;

import com.miltonlearn.jdbc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
  @Autowired
  private BookCall bookCall;

  public void addBook(Book book) {
    bookCall.add(book);
  }

  public void updateBook(Book book) {
    bookCall.update(book);
  }

  public void deleteBook(int id) {
    bookCall.delete(id);
  }

  public int selectCount() {
    return bookCall.count();
  }

  public Book findBook(int id) {
    return bookCall.find(id);
  }

  public List<Book> findAll() {
    return bookCall.all();
  }
}
