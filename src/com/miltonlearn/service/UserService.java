package com.miltonlearn.service;

import com.miltonlearn.call.IUserCall;
import com.miltonlearn.call.UserCall;

public class UserService {
  private UserCall userCall;

  public void setUserCall(UserCall userCall) {
    this.userCall = userCall;
  }

  public void add(){
    System.out.println("Service add...");
    userCall.update();
  }
}
