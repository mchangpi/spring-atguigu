package com.miltonlearn.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserCall implements IUserCall {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public void addMoney() {
    String sql = "update account set money=money-? where username=?";
    jdbcTemplate.update(sql, 100, "lucy");

  }

  @Override
  public void reduceMoney() {
    String sql = "update account set money=money+? where username=?";
    jdbcTemplate.update(sql, 100, "mary");
  }
}
