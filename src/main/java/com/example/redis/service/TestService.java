package com.example.redis.service;

import com.example.redis.domain.Person;
import com.example.redis.repository.TestRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

  private final TestRepository testRepository;

  public Person generate(Integer timeout) {
    return testRepository.generateNew(timeout);
  }

  public Person getById(String id) {
    return testRepository.findPersonById(id);
  }

    public List<Person> findAll(Integer startIndex, Integer endIndex) {
    return testRepository.findAll(startIndex, endIndex);
  }

  public Person savePerson(Person person, Integer timeout) {
    return testRepository.saveNewPerson(person, timeout);
  }

  public Person updatePerson(Person person) {
    return testRepository.updatePerson(person);
  }

  public Boolean deletePerson(String id) {
    return testRepository.deletePerson(id);
  }
}
