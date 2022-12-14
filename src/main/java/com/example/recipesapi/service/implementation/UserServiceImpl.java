package com.example.recipesapi.service.implementation;

import com.example.recipesapi.entity.User;
import com.example.recipesapi.repository.UserRepository;
import com.example.recipesapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(User object) {

        object.setPassword(passwordEncoder.encode(object.getPassword()));
        return userRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User update(User object) {
        return userRepository.save(object);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
