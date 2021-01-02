package com.miltonlearn.test;

import com.miltonlearn.aop.User;
import com.miltonlearn.aopxml.Book;
import com.miltonlearn.config.AopConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspectJ {
  @Test
  public void testAOPAnnotation() {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("beanAspectJ.xml");
    System.out.println(context.toString());
    User user = context.getBean("user", User.class);
    user.add();
  }

  @Test
  public void testAOPXML() {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("beanAspectJ2.xml");
    System.out.println(context.toString());
    Book book = context.getBean("book", Book.class);
    book.buy();
  }

  @Test
  public void testAOPConfig() {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AopConfig.class);
    System.out.println(context.toString());

    User user = context.getBean("user", User.class);
    user.add();
  }
}
