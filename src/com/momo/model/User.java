package com.momo.model;

import java.sql.Timestamp;
import java.util.Date;

public class User {
  private Integer id;
  private String fullName;
  private Gender gender;
  private String location;
  private Timestamp dateCreated;
  private Timestamp dateModified;

  public User() {}

  public User(String fullName, Gender gender, String location) {
    this.fullName = fullName;
    this.gender = gender;
    this.location = location;
    this.dateCreated = new Timestamp(new Date().getTime());
    this.dateModified = this.dateCreated;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Timestamp getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Timestamp dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Timestamp getDateModified() {
    return dateModified;
  }

  public void setDateModified(Timestamp dateModified) {
    this.dateModified = dateModified;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", fullName='" + fullName + '\'' +
        ", gender=" + gender +
        ", location='" + location + '\'' +
        ", dateCreated=" + dateCreated +
        ", dateModified=" + dateModified +
        '}';
  }
}
