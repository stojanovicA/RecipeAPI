package com.example.recipesapi.service.implementation;

import com.example.recipesapi.entity.Ingredient;
import com.example.recipesapi.repository.IngredientRepository;
import com.example.recipesapi.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public Optional<Ingredient> findById(Long id) {
        return ingredientRepository.findById(id);
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient add(Ingredient object) {
        return ingredientRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public Ingredient update(Ingredient object) {
        return ingredientRepository.save(object);
    }
}
