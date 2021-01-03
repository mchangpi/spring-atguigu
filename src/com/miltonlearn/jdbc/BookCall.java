package com.miltonlearn.jdbc;

import com.miltonlearn.jdbc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class BookCall implements IBookCall {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public void add(Book book) {
    String sql = "insert into book values(?,?,?)";
    Object[] args = {book.getId(), book.getName(), book.getStatus()};
    System.out.println("Book " + Arrays.toString(args));
    int update = jdbcTemplate.update(sql, args);
    System.out.println(update);
  }
}
