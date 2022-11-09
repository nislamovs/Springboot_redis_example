package com.example.redis.service;

import com.example.redis.domain.Address;
import com.example.redis.domain.Person;
import com.github.javafaker.Faker;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class Utils {

  private static final Faker faker;

  static {
    faker = new Faker();
  }

  public static Person generatePerson() {
    return Person.builder()
        .id(UUID.randomUUID().toString().replaceAll("-", ""))
        .firstname(faker.name().firstName())
        .lastname(faker.name().lastName())
        .address(
            Address.builder()
                .city(faker.address().city())
                .state(faker.address().state())
                .street(faker.address().streetAddress())
                .zipcode(faker.address().zipCode())
                .build()
        ).build();
  }

}
