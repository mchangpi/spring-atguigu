package com.miltonlearn.test;

import com.miltonlearn.Book;
import com.miltonlearn.Order;
import com.miltonlearn.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
  @Test
  public void testUserAdd(){
    //ApplicationContext context =
    BeanFactory context =
        new ClassPathXmlApplicationContext("bean1.xml");
    System.out.println(context.toString());

    User user = context.getBean("userId", User.class);
    System.out.println(user.toString());
    user.add();
  }
  @Test
  public void testBook(){
    //ApplicationContext context =
    BeanFactory context =
        new ClassPathXmlApplicationContext("bean1.xml");
    System.out.println(context.toString());

    Book book = context.getBean("book", Book.class);
    System.out.println(book.toString());
    book.printInfo();
  }
  @Test
  public void testOrder(){
    //ApplicationContext context =
    BeanFactory context =
        new ClassPathXmlApplicationContext("bean1.xml");
    //System.out.println(context.toString());

    Order order = context.getBean("order", Order.class);
    System.out.println(order.toString());
    order.printOrder();
  }
}
