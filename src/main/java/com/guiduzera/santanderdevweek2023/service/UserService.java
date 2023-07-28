package com.guiduzera.santanderdevweek2023.service;

import com.guiduzera.santanderdevweek2023.domain.model.User;

public interface UserService {
    User findById(Long id);
    User createUser(User user);
}
