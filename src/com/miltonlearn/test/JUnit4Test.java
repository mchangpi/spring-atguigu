package com.miltonlearn.test;

import com.miltonlearn.transaction.UserService;
import org.junit.Test; // JUnit4
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beanXMLTransaction.xml")
public class JUnit4Test {
  @Autowired
  private UserService userService; // from beanXMLTransaction.xml

  @Test
  public void TestAccount() {
    userService.accountMoney();
  }
}
