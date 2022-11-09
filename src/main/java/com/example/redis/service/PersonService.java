package com.example.redis.service;

import static com.example.redis.service.Utils.generatePerson;
import static java.lang.String.format;

import com.example.redis.domain.Person;
import com.example.redis.domain.PersonNotFoundException;
import com.example.redis.repository.PersonRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonRepository personRepository;

  public Person saveRandomPerson() {
    return personRepository.save(generatePerson());
  }

  public Person getById(String id) {
    return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(format("Person by id [%s] was not found.", id)));
  }

  public List<Person> findAll() {
    return personRepository.findAll();
  }

  public Person saveNewPerson(Person person) {
    return personRepository.save(person);
  }

  public Person editExistingPerson(Person person) {
    return personRepository.save(person);
  }

  public void deletePersonById(String id) {
    if (personRepository.existsById(id))
      personRepository.deleteById(id);
    else
      throw new PersonNotFoundException(format("Person by id [{0}] was not found.", id));
  }
}
