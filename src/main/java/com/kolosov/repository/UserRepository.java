package com.kolosov.repository;

import com.kolosov.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    com.kolosov.model.User findByUsername(String username);
}
