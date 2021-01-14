package com.miltonlearn.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLog {
  private static final Logger log = LoggerFactory.getLogger(UserLog.class);

  public static void main(String[] args) {
    log.info("Hello log4j");
    log.warn("Hello log4j");
  }
}
