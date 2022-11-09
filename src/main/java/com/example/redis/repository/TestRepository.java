package com.example.redis.repository;

import com.example.redis.domain.Person;
import com.example.redis.service.TestService;
import com.example.redis.service.Utils;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TestRepository {

  private final RedisTemplate<String, Person> redisTemplate;

  public Person generateNew(Integer timeout) {
    Person person = Utils.generatePerson();
    if (timeout != null)
      redisTemplate.opsForValue().setIfAbsent(person.getId(), person, Duration.ofSeconds(timeout));
    else
      redisTemplate.opsForValue().setIfAbsent(person.getId(), person);

    return redisTemplate.opsForValue().get(person.getId());
  }

  public Person findPersonById(String id) {
    return redisTemplate.opsForValue().get(id);
  }

  public List<Person> findAll(Integer startIndex, Integer endIndex) {
//    System.out.println(">> " + startIndex);
//    System.out.println(">> " + endIndex);
//
//    System.out.println(redisTemplate.opsForHash().get("Person:", "1"));
//    System.out.println("#1" +redisTemplate.opsForList().range("4*", startIndex, endIndex));
////    System.out.println(redisTemplate.opsForList().range());
//
////
//    return redisTemplate.opsForList().range("*", startIndex, endIndex);
    return null;
  }

  public Person saveNewPerson(Person person) {
    return saveNewPerson(person, null);
  }

  public Person saveNewPerson(Person person, Integer timeout) {
    if (timeout != null)
      redisTemplate.opsForValue().setIfAbsent(person.getId(), person, Duration.ofSeconds(timeout));
    else
      redisTemplate.opsForValue().setIfAbsent(person.getId(), person);

    return redisTemplate.opsForValue().get(person.getId());
  }

  public Person updatePerson(Person person) {
    redisTemplate.opsForValue().getAndSet(person.getId(), person);
    return redisTemplate.opsForValue().get(person.getId());
  }

  public Boolean deletePerson(String id) {
    return redisTemplate.delete(id);
  }
}
