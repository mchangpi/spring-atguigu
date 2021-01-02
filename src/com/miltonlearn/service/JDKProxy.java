package com.miltonlearn.service;

import com.miltonlearn.call.IUserCall;
import com.miltonlearn.call.UserCall;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
  public static void main(String[] args) {
    Class[] interfaces = {IUserCall.class};
    /*
    Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
      }
    });*/
    UserCall userCall = new UserCall();
    IUserCall ucInstance = (IUserCall) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserCallProxy(userCall));
    int addResult = ucInstance.add(1, 2);
    System.out.println("Add results " + addResult);
  }
}

class UserCallProxy implements InvocationHandler {
  private Object obj;

  public UserCallProxy(Object obj) {
    this.obj = obj;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("Before method " + method.getName() +
        " args " + Arrays.toString(args));
    Object results = method.invoke(obj, args);
    System.out.println("After method " + obj);

    return results;
  }
}
