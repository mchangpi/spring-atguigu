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
    int update = jdbcTemplate.update(sql, args);
    System.out.println("Book " + Arrays.toString(args) + " affected row " + update);
  }

  @Override
  public void update(Book book) {
    String sql = "update book set name=?, status=? where id=?";
    Object[] args = {book.getName(), book.getStatus(), book.getId()};
    int update = jdbcTemplate.update(sql, args);
    System.out.println("Update Book " + Arrays.toString(args) + " affected row " + update);
  }

  @Override
  public void delete(int id) {
    String sql = "delete from book where id=?";
    int update = jdbcTemplate.update(sql, id);
    System.out.println("Delete Book " + " affected row " + update);
  }

  @Override
  public int count() {
    String sql = "select count(*) from book";
    return jdbcTemplate.queryForObject(sql, Integer.class);
  }
}
