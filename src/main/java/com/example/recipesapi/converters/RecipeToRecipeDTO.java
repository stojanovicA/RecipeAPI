package com.example.recipesapi.converters;


import com.example.recipesapi.dto.RecipeDTO;
import com.example.recipesapi.dto.WeightedIngredientDTO;
import com.example.recipesapi.entity.Recipe;
import com.example.recipesapi.entity.WeightedIngredient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeToRecipeDTO implements Converter<Recipe,RecipeDTO> {

    @Autowired
    ModelMapper modelMapper;


    @Override
    public RecipeDTO convert(Recipe source) {
        return modelMapper.map(source, RecipeDTO.class);
    }

    public List<RecipeDTO> convert(List<Recipe> recipes) {
        List<RecipeDTO> recipeDTOS = new ArrayList<>();
        for (Recipe recipe : recipes) {
            RecipeDTO recipeDTO = modelMapper.map(recipe, RecipeDTO.class);
            for (WeightedIngredient weightedIngredient : recipe.getWeightedIngredientSet()) {
                WeightedIngredientDTO weightedIngredientDTO = modelMapper.map(weightedIngredient, WeightedIngredientDTO.class);
                weightedIngredientDTO.setIngredientId(weightedIngredient.getIngredient().getid());
                recipeDTO.getWeightedIngredients().add(weightedIngredientDTO);

            }
            recipeDTOS.add(recipeDTO);

        }
        return recipeDTOS;
    }

}