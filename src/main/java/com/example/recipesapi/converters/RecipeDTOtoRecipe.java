package com.example.recipesapi.converters;

import com.example.recipesapi.dto.RecipeDTO;
import com.example.recipesapi.dto.WeightedIngredientDTO;
import com.example.recipesapi.entity.Ingredient;
import com.example.recipesapi.entity.Recipe;
import com.example.recipesapi.entity.User;
import com.example.recipesapi.entity.WeightedIngredient;
import com.example.recipesapi.service.IngredientService;
import com.example.recipesapi.service.RecipeService;
import com.example.recipesapi.service.UserService;
import com.example.recipesapi.service.WeightedIngredientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class RecipeDTOtoRecipe implements Converter<RecipeDTO, Recipe> {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    RecipeService recipeService;

    @Autowired
    UserService userService;

    @Autowired
    WeightedIngredientService weightedIngredientService;

    @Override
    public Recipe convert(RecipeDTO source) {
        return null;
    }

    public Recipe convert (RecipeDTO recipeDTO, UserDetails userDetails){
        Recipe recipe = modelMapper.map(recipeDTO, Recipe.class);
        for(WeightedIngredientDTO weightedIngredientDTO : recipeDTO.getWeightedIngredients()){
            WeightedIngredient weightedIngredient = new WeightedIngredient();
            weightedIngredient.setUnit(weightedIngredientDTO.getUnit());
            weightedIngredient.setValue(weightedIngredientDTO.getValue());
            long ingredientId = weightedIngredientDTO.getIngredientId();
            Ingredient ingredient = ingredientService.findById(ingredientId).get();
            weightedIngredient.setIngredient(ingredient);


            recipe.getWeightedIngredientSet().add(weightedIngredient);
        }
        User user = userService.findById(Long.valueOf(userDetails.getUsername())).get();

        recipe.setUserEntity(user);

        Recipe savedRecipe = recipeService.add(recipe);
        for(WeightedIngredient weightedIngredient: savedRecipe.getWeightedIngredientSet()){
            weightedIngredient.setRecipe(savedRecipe);
            weightedIngredientService.add(weightedIngredient);
        }



        return savedRecipe;
    }
}
