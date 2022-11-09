package com.example.redis.domain;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address implements Serializable {
  private String street;
  private String city;
  private String state;
  private String zipcode;
}
