package com.guiduzera.santanderdevweek2023.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.guiduzera.santanderdevweek2023.domain.model.User;
import com.guiduzera.santanderdevweek2023.domain.repository.UserRepository;
import com.guiduzera.santanderdevweek2023.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);

        return user;
    }

    @Override
    public User createUser(User user) {
        var userExists = userRepository.findByName(user.getName());
        
        if (userExists != null) {
            throw new RuntimeException("User already exists");
        }

        return userRepository.save(user);
    }
    
}
