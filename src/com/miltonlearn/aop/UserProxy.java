package com.miltonlearn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class UserProxy {
  @Pointcut(value = "execution(* com.miltonlearn.aop.User.add(..))")
  private void pointdemo() {
  }

  @Before(value = "pointdemo()")
  public void before() {
    System.out.println("UserProxy before...");
  }

  @After(value = "pointdemo()")
  public void after() {
    System.out.println("UserProxy after...");
  }

  @AfterReturning(value = "pointdemo()")
  public void afterReturn() {
    System.out.println("UserProxy after returning...");
  }

  @AfterThrowing(value = "pointdemo()")
  public void afterThrow() {
    System.out.println("UserProxy after throwing...");
  }

  @Around(value = "pointdemo()")
  public void around(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("UserProxy around before...");
    pjp.proceed();
    System.out.println("UserProxy around after...");
  }
}
