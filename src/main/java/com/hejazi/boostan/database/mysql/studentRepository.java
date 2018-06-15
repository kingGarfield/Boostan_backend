package com.hejazi.boostan.database.mysql;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface studentRepository extends CrudRepository<Student , Integer> {
    Optional<Student> findByUsername(String username);
    Optional<Student> findByPassword(String password);
}
