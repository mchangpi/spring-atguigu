package com.miltonlearn.service;

import com.miltonlearn.call.IUserCall;
import com.miltonlearn.call.UserCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component(value = "userService")
//@Repository(value = "userService")
//@Controller(value = "userService")
@Service(value = "userService")
public class UserService {
  @Autowired // byType
  @Qualifier(value = "userCallObj") // byName
  private UserCall userCall;

  public void setUserCall(UserCall userCall) {
    this.userCall = userCall;
  }

  public void add() {
    System.out.println("Service add...");
    if (null != userCall)
      userCall.update();
  }
}
