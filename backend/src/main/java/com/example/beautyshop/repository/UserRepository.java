package com.example.beautyshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beautyshop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
