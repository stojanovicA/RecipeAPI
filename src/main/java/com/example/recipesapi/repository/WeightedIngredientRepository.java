package com.example.recipesapi.repository;

import com.example.recipesapi.entity.WeightedIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightedIngredientRepository extends JpaRepository<WeightedIngredient,Long> {
}
