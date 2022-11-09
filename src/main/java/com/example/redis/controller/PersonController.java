package com.example.redis.controller;


import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import com.example.redis.domain.Person;
import com.example.redis.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class PersonController {

  private final PersonService redisService;

  @RequestMapping(value = "/person/saverand", method = {RequestMethod.GET, RequestMethod.POST})
  public ResponseEntity addRandomPerson() {
    return ok(redisService.saveRandomPerson());
  }

  @GetMapping("/person/{id}")
  public ResponseEntity getPersonById(@PathVariable("id") String id) {
    return ok(redisService.getById(id));
  }

  @GetMapping("/person/all")
  public ResponseEntity getAllPersons() {
    return ok(redisService.findAll());
  }

  @PostMapping("/person")
  public ResponseEntity addNewPerson(@RequestBody Person person) {
    return  ok(redisService.saveNewPerson(person));
  }

  @PutMapping("/person/{id}")
  public ResponseEntity editExistingPerson(@PathVariable("id") String id, @RequestBody Person person) {
    return  ok(redisService.editExistingPerson(person.toBuilder().id(id).build()));
  }

  @DeleteMapping("/person/{id}")
  public ResponseEntity deletePerson(@PathVariable("id") String id) {
    redisService.deletePersonById(id);
    return noContent().build();
  }
}
