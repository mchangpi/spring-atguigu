package com.miltonlearn.jdbc;

import com.miltonlearn.jdbc.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

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

  @Override
  public Book find(int id) {
    String sql = "select * from book where id=?";
    Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
    return book;
  }

  @Override
  public List<Book> all() {
    String sql = "select * from book";
    List<Book> bookList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
    return bookList;
  }

  @Override
  public void batchAdd(List<Object[]> args) {
    String sql = "insert into book values(?,?,?)";
    int[] ints = jdbcTemplate.batchUpdate(sql, args);
    System.out.println("Batch Add: " + Arrays.toString(ints));
  }

  @Override
  public void batchUpdate(List<Object[]> args) {
    String sql = "update book set name=?, status=? where id=?";
    int[] ints = jdbcTemplate.batchUpdate(sql, args);
    System.out.println("Batch Update: " + Arrays.toString(ints));
  }

  @Override
  public void batchDelete(List<Object[]> args) {
    String sql = "delete from book where id=?";
    int[] ints = jdbcTemplate.batchUpdate(sql, args);
    System.out.println("Batch Delete: " + Arrays.toString(ints));
  }
}