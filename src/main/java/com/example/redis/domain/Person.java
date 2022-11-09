package com.example.redis.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@RedisHash(value = "Person", timeToLive = 600)
//@RedisHash(value = "Person")

//Serializable needed only for usage with redisTemplate
public class Person implements Serializable {

  private String id;

  @Indexed
  private String firstname;

  private String lastname;

  private Address address;

  @TimeToLive
  private Long timeout;
}
