package com.miltonlearn.transaction.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.miltonlearn.transaction")
@EnableTransactionManagement
public class TxConfig {
  @Bean
  public DruidDataSource getDruidDataSource() {
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    dataSource.setUrl("jdbc:mysql://remotemysql.com:3306/4tTI663KOk");
    dataSource.setUsername("4tTI663KOk");
    dataSource.setPassword("NETxtyhTVX");
    return dataSource;
  }

  @Bean
  public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
    JdbcTemplate template = new JdbcTemplate();
    template.setDataSource(dataSource);
    return template;
  }

  @Bean
  public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
    DataSourceTransactionManager mgr = new DataSourceTransactionManager();
    mgr.setDataSource(dataSource);
    return mgr;
  }
}
