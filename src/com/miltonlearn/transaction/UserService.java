package com.miltonlearn.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserCall userCall;

  public void accountMoney() {
    userCall.reduceMoney();
    userCall.addMoney();
  }
}
