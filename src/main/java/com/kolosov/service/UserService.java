package com.kolosov.service;

import com.kolosov.exception.UserAlreadyExistException;
import com.kolosov.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User registerNewUser(User user) throws UserAlreadyExistException;
    void deleteUser(User user);
    User findByEmail(String email);
}
