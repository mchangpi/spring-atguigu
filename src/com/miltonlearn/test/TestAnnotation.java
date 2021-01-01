package com.miltonlearn.test;

import com.miltonlearn.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
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
}
