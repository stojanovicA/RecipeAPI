package com.example.recipesapi.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, I>{

    Optional<T> findById(I id);

    List<T> findAll();

    T add(T object);

    void deleteById(I id);

    T update(T object);



}