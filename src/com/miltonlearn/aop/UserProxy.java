package com.miltonlearn.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserProxy {
  @Before(value = "execution(* com.miltonlearn.aop.User.add(..))")
  public void before() {
    System.out.println("UserProxy before...");
  }

  @After(value = "execution(* com.miltonlearn.aop.User.add(..))")
  public void after() {
    System.out.println("UserProxy after...");
  }

  @AfterReturning(value = "execution(* com.miltonlearn.aop.User.add(..))")
  public void afterReturn() {
    System.out.println("UserProxy after returning...");
  }

  @AfterThrowing(value = "execution(* com.miltonlearn.aop.User.add(..))")
  public void afterThrow() {
    System.out.println("UserProxy after throwing...");
  }

  @Around(value = "execution(* com.miltonlearn.aop.User.add(..))")
  public void around(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("UserProxy around before...");
    pjp.proceed();
    System.out.println("UserProxy around after...");
  }
}
