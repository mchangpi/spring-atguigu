package com.miltonlearn.test;

import com.miltonlearn.jdbc.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJDBC {
  @Test
  public void testCRUD() {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("beanAnnoJDBCTemplate.xml");

    BookService bookService = context.getBean("bookService", BookService.class);
    //Book book = new Book(1, "Java 6", "10 books");
    //bookService.addBook(book);
    //book = new Book(2, "Java 3", "10 books");
    //bookService.updateBook(book);
    //bookService.deleteBook(1);

    System.out.println("Select count " + bookService.selectCount());
    System.out.println(bookService.findBook(1));
    System.out.println(bookService.findAll());
  }
}
