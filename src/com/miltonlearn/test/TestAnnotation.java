package com.miltonlearn.test;

import com.miltonlearn.aop.User;
import com.miltonlearn.config.AnnotationConfig;
import com.miltonlearn.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
  @Test
  public void testUserService() {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("beanAnnotation.xml");
    System.out.println(context.toString());

    UserService us = context.getBean("userService", UserService.class);
    System.out.println(us.toString());
    us.add();
  }

  @Test
  public void testConfig() {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AnnotationConfig.class);
    System.out.println(context.toString());

    UserService us = context.getBean("userService", UserService.class);
    System.out.println(us.toString());
    us.add();
  }

  @Test
  public void testAOP() {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("beanAspectJ.xml");
    System.out.println(context.toString());
    User user = context.getBean("user", User.class);
    user.add();
  }
}
