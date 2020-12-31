package com.miltonlearn.factory;

import org.springframework.beans.factory.FactoryBean;
import com.miltonlearn.collection.Course;

public class MyBean implements FactoryBean<Course> {

  @Override
  public Course getObject() throws Exception {
    Course c = new Course();
    c.setName("test");
    return c;
  }

  @Override
  public Class<?> getObjectType() {
    return null;
  }

  @Override
  public boolean isSingleton() {
    return false;
  }
}
