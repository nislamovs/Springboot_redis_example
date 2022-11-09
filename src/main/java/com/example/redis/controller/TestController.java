package com.example.redis.controller;

import static org.springframework.http.ResponseEntity.ok;

import com.example.redis.domain.Person;
import com.example.redis.service.TestService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/v1/test")
@RestController
@RequiredArgsConstructor
public class TestController {

  private final TestService testService;

  @RequestMapping(value = "/generate", method = {RequestMethod.GET, RequestMethod.POST})
  public ResponseEntity generate(@RequestParam(value = "timeout", required = false) Integer timeout) {
    return ok(testService.generate(timeout));
  }

  @GetMapping("/person/{id}")
  public ResponseEntity getById(@PathVariable(value = "id") String id) {
    return ok(testService.getById(id));
  }

  @GetMapping("/person")
  public ResponseEntity getAll(@RequestParam(value = "start", required = false, defaultValue = "0") Integer start,
                               @RequestParam(value = "end", required = false, defaultValue = "5") Integer end) {
    return ok(testService.findAll(start, end));
  }

  @PostMapping("/person")
  public ResponseEntity createNewPerson(@RequestParam(value = "timeout", required = false) Integer timeout, @RequestBody Person person) {
    return ok(testService.savePerson(person, timeout));
  }

  @PutMapping("/person/{id}")
  public ResponseEntity editPerson(@PathVariable(value = "id") String id, @RequestBody Person person) {
    return ok(testService.updatePerson(person.toBuilder().id(id).build()));
  }

  @DeleteMapping("/person/{id}")
  public ResponseEntity deletePerson(@PathVariable(value = "id") String id) {
    return ok(testService.deletePerson(id));
  }
}
