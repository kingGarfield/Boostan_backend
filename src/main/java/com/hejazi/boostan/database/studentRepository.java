package com.hejazi.boostan.database;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface studentRepository extends CrudRepository<Student , Long> {
    Optional<Student> findByUsername(String username);
    Optional<Student> findByPasswordOrderByUsername(Student var1);
}
