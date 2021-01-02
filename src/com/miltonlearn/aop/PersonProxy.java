package com.miltonlearn.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class PersonProxy {
  @Pointcut(value = "execution(* com.miltonlearn.aop.User.add(..))")
  private void pointdemo() {
  }

  @Before(value = "pointdemo()")
  public void before() {
    System.out.println("PersonProxy before...");
  }
}
