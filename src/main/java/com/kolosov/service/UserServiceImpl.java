package com.kolosov.service;

import com.kolosov.exception.UserAlreadyExistException;
import com.kolosov.model.User;
import com.kolosov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUser(User user) throws UserAlreadyExistException {
        if(emailExist(user.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: " +  user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private boolean emailExist(String email) {
        return findByEmail(email) != null;
    }
}
