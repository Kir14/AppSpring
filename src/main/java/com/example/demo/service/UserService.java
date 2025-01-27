package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User saveUser(User user) {
        for (Address address : user.addresses) {
            address.setUser(user);
        }
        return userRepository.save(user);
    }

    @Transactional()
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional()
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElse(null);

    }
}
