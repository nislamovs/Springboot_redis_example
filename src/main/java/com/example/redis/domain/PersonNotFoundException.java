package com.example.redis.domain;

public class PersonNotFoundException extends RuntimeException {

  public PersonNotFoundException(String msg) {
    super(msg);
  }

  public PersonNotFoundException(String msg, Throwable t) {
    super(msg, t);
  }
}
