package com.example.recipesapi.service;


import com.example.recipesapi.entity.User;

import java.util.Optional;

public interface UserService extends CrudService<User,Long>{

    public Optional<User>  findByEmail(String email);
}
