package com.miltonlearn.service;

import com.miltonlearn.call.UserCall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//@Component(value = "userService")
//@Repository(value = "userService")
//@Controller(value = "userService")
@Service(value = "userService")
public class UserService {

  /* Injection for primitive types */
  @Value(value = "guestService")
  private String name;

  /* @Autowired @Qualifer are used together */
  @Autowired // byType
  @Qualifier(value = "userCallObj") // byName
  private UserCall userCall;

  /*
  @Resource(name = "userCallObj")
  private UserCall userCall;*/

  public void setUserCall(UserCall userCall) {
    this.userCall = userCall;
  }

  public void add() {
    System.out.println("Service add name " + name);
    if (null != userCall)
      userCall.update();
  }
}
