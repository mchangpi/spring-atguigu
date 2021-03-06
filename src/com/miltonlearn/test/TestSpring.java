package com.miltonlearn.test;

import com.miltonlearn.Book;
import com.miltonlearn.Order;
import com.miltonlearn.User;
import com.miltonlearn.bean.Employee;
import com.miltonlearn.collection.Course;
import com.miltonlearn.collection.Student;
import com.miltonlearn.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
  @Test
  public void testUserAdd() {
    //ApplicationContext context =
    BeanFactory context =
        new ClassPathXmlApplicationContext("beanXML.xml");
    System.out.println(context.toString());

    User user = context.getBean("userId", User.class);
    System.out.println(user.toString());
    user.add();
  }

  @Test
  public void testBook() {
    //ApplicationContext context =
    BeanFactory context =
        new ClassPathXmlApplicationContext("beanXML.xml");
    System.out.println(context.toString());

    Book book = context.getBean("book", Book.class);
    System.out.println(book.toString());
    book.printInfo();
  }

  @Test
  public void testOrder() {
    //ApplicationContext context =
    BeanFactory context =
        new ClassPathXmlApplicationContext("beanXML.xml");
    //System.out.println(context.toString());

    Order order = context.getBean("order", Order.class);
    System.out.println(order.toString());
    order.printOrder();
  }

  @Test
  public void testExternalBean() {
    //ApplicationContext context =
    BeanFactory context =
        new ClassPathXmlApplicationContext("beanXMLref.xml");
    //System.out.println(context.toString());

    UserService us = context.getBean("userService", UserService.class);
    System.out.println(us.toString());
    us.add();
  }

  @Test
  public void testInnerBean() {
    //ApplicationContext context =
    BeanFactory context =
        //new ClassPathXmlApplicationContext("beanXMLInner.xml");
        new ClassPathXmlApplicationContext("beanXMLRef_2.xml");

    Employee emp = context.getBean("emp", Employee.class);
    System.out.println(emp.toString());
    emp.printInfo();
  }

  @Test
  public void testCollection() {
    BeanFactory context =
        //new ClassPathXmlApplicationContext("beanXMLInner.xml");
        new ClassPathXmlApplicationContext("beanXMLCollection.xml");

    Student student = context.getBean("student", Student.class);
    student.printCourses();
    Book book1 = context.getBean("book", Book.class);
    Book book2 = context.getBean("book", Book.class);
    System.out.println("book1 " + book1);
    System.out.println("book2 " + book2);
    book1.printInfo();
  }

  @Test
  public void testFactoryBean() {
    BeanFactory context =
        //new ClassPathXmlApplicationContext("beanXMLInner.xml");
        new ClassPathXmlApplicationContext("beanXMLFactoryBean.xml");

    Course c = context.getBean("mybean", Course.class);
    System.out.println(c);
  }

  @Test
  public void testBeanLifeCycle() {
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("beanXMLLifeCycle.xml");

    Order order = context.getBean("order", Order.class);
    System.out.println(order + " 4. Get bean instance ");
    context.close();
  }

  @Test
  public void testAutoWire() {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("beanXMLAutoWire.xml");

    Employee emp = context.getBean("emp", Employee.class);
    emp.printInfo();
  }
}
