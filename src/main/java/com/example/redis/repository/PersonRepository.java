package com.example.redis.repository;

import com.example.redis.domain.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {

  @Override
  List<Person> findAll();

  Optional<Person> findPersonById(String id);

}
