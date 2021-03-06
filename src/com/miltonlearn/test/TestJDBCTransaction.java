package com.miltonlearn.test;

import com.miltonlearn.jdbc.BookService;
import com.miltonlearn.transaction.UserService;
import com.miltonlearn.config.TxConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TestJDBCTransaction {

  @Nullable
  private String transactionName;

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
    List<Object[]> batchArgs = new ArrayList<>();
    /*
    Object[] o1 = {"5", "Spring", "3books"};
    Object[] o2 = {"6", "SpringBoot", "5books"};
    Object[] o3 = {"7", "SpringCloud", "6books"};*/
    /*
    Object[] o1 = {"Spring", "0books", 5};
    Object[] o2 = {"SpringBoot", "0books", 6};
    Object[] o3 = {"SpringCloud", "0books", 7};*/

    Object[] o1 = {5};
    Object[] o2 = {6};
    Object[] o3 = {7};
    batchArgs.add(o1);
    batchArgs.add(o2);
    batchArgs.add(o3);

    //bookService.batchAddBooks(batchArgs);
    //bookService.batchUpdateBooks(batchArgs);
    bookService.batchDeleteBooks(batchArgs);
  }

  @Test
  public void testTransacion() {
    //PlatformTransactionManager;
    ApplicationContext context =
        new ClassPathXmlApplicationContext("beanAnnoTransaction.xml");
    UserService service = context.getBean("userService", UserService.class);
    service.accountMoney();
  }

  @Test
  public void testXMLTransacion() {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("beanXMLTransaction.xml");
    UserService service = context.getBean("userService", UserService.class);
    service.accountMoney();
  }

  @Test
  public void testTransacionWithoutXMLFile() {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(TxConfig.class);
    UserService service = context.getBean("userService", UserService.class);
    service.accountMoney();
  }

  @Test
  public void testGenericApplicationContext() {
    GenericApplicationContext ctx = new GenericApplicationContext();
    ctx.refresh();
    ctx.registerBean("userLog", UserLog.class, () -> new UserLog());
    UserLog log = (UserLog) ctx.getBean("userLog");
    System.out.println(log);
  }
}
