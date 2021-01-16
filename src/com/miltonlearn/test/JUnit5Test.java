package com.miltonlearn.test;

import com.miltonlearn.transaction.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:beanXMLTransaction.xml")
@SpringJUnitConfig(locations = "classpath:beanXMLTransaction.xml")
public class JUnit5Test {
  @Autowired
  private UserService userService;

  @Test
  public void TestAccount() {
    userService.accountMoney();
  }
}
