package com.example.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.capstone.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}