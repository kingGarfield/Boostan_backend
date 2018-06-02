package com.hejazi.boostan.database.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userSessionRepository extends CrudRepository<userSession , String> {
}
