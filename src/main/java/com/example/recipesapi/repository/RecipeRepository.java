package com.example.recipesapi.repository;

import com.example.recipesapi.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {

    public List<Recipe> findByUser_Id(long id);


}
