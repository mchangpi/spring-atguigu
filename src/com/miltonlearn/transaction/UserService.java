package com.miltonlearn.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
  @Autowired
  private UserCall userCall;

  public void accountMoney() {
    userCall.reduceMoney();
    int i = 1 / 0; // rollback if exception occurs
    userCall.addMoney();
  }
}
