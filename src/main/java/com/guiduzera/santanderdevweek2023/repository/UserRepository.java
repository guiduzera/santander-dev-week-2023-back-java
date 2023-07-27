package com.guiduzera.santanderdevweek2023.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guiduzera.santanderdevweek2023.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
