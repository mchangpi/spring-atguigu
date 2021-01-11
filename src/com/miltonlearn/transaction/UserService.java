package com.miltonlearn.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, timeout = -1, readOnly = false)
public class UserService {
  @Autowired
  private UserCall userCall;

  public void accountMoney() {
    userCall.reduceMoney();
    int i = 1 / 0; // rollback if exception occurs
    userCall.addMoney();
  }
}
