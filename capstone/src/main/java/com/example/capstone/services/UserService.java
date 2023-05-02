package com.example.capstone.services;

import org.springframework.stereotype.Service;
import com.example.capstone.entities.User;
import com.example.capstone.repositories.UserRepository;
import java.util.List;

@Service
public class UserService {
    
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
