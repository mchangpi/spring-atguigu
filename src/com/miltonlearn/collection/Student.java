package com.miltonlearn.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
  private String[] courseArray;
  private List<String> courseList;
  private Map<String, String> courseMap;
  private Set<String> courseSet;
  private List<Course> courseObjList;

  public void setCourseArray(String[] courseArray) {
    this.courseArray = courseArray;
  }

  public void setCourseList(List<String> courseList) {
    this.courseList = courseList;
  }

  public void setCourseMap(Map<String, String> courseMap) {
    this.courseMap = courseMap;
  }

  public void setCourseSet(Set<String> courseSet) {
    this.courseSet = courseSet;
  }

  public void setCourseObjList(List<Course> courseObjList) {
    this.courseObjList = courseObjList;
  }

  public void printCourses() {
    System.out.println(Arrays.toString(courseArray));
    System.out.println(courseList);
    System.out.println(courseMap);
    System.out.println(courseSet);
    System.out.println(courseObjList);
  }
}
