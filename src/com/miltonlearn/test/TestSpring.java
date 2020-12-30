package com.miltonlearn.test;

import com.miltonlearn.Book;
import com.miltonlearn.Order;
import com.miltonlearn.User;
import com.miltonlearn.service.UserService;
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
  @Test
  public void testExternalBean(){
    //ApplicationContext context =
    BeanFactory context =
        new ClassPathXmlApplicationContext("bean2.xml");
    //System.out.println(context.toString());

    UserService us = context.getBean("userService", UserService.class);
    System.out.println(us.toString());
    us.add();
  }
}
