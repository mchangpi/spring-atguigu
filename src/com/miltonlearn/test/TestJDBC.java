package com.miltonlearn.test;

import com.miltonlearn.jdbc.BookService;
import com.miltonlearn.jdbc.entity.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJDBC {
  @Test
  public void testAddBook() {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("beanAnnoJDBCTemplate.xml");

    BookService bookService = context.getBean("bookService", BookService.class);
    Book book = new Book(1, "Java", "Sold out");
    bookService.addBook(book);
  }
}
