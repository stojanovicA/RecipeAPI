package com.example.recipesapi.service.implementation;

import com.example.recipesapi.entity.WeightedIngredient;
import com.example.recipesapi.repository.WeightedIngredientRepository;

import com.example.recipesapi.service.WeightedIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeightedIngredientServiceImpl implements WeightedIngredientService {

    @Autowired
    WeightedIngredientRepository weightedIngredientRepository;


    @Override
    public Optional<WeightedIngredient> findById(Long id) {
        return weightedIngredientRepository.findById(id);
    }

    @Override
    public List<WeightedIngredient> findAll() {
        return weightedIngredientRepository.findAll();
    }

    @Override
    public WeightedIngredient add(WeightedIngredient object) {
        return weightedIngredientRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        weightedIngredientRepository.deleteById(id);

    }

    @Override
    public WeightedIngredient update(WeightedIngredient object) {



        return weightedIngredientRepository.save(object);
    }
}
