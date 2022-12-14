package com.example.recipesapi.service;

import com.example.recipesapi.dto.RecipeDTO;
import com.example.recipesapi.entity.Recipe;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface RecipeService extends CrudService<Recipe,Long>{

    public List<Recipe> findByUserId(long id);


}
