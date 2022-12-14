package com.example.recipesapi.service.implementation;

import com.example.recipesapi.dto.RecipeDTO;
import com.example.recipesapi.dto.WeightedIngredientDTO;
import com.example.recipesapi.entity.Ingredient;
import com.example.recipesapi.entity.Recipe;
import com.example.recipesapi.entity.User;
import com.example.recipesapi.entity.WeightedIngredient;
import com.example.recipesapi.repository.RecipeRepository;
import com.example.recipesapi.service.IngredientService;
import com.example.recipesapi.service.RecipeService;
import com.example.recipesapi.service.UserService;
import com.example.recipesapi.service.WeightedIngredientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IngredientService ingredientService;

    @Autowired
    UserService userService;





    @Autowired
    WeightedIngredientService weightedIngredientService;




    @Override
    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe add(Recipe object) {
        return recipeRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);

    }

    @Override
    public Recipe update(Recipe object) {
        return recipeRepository.save(object);
    }


    @Override
    public List<Recipe> findByUserId(long id) {
        return recipeRepository.findByUser_Id(id);
    }

    /*@Override
    public Recipe add(RecipeDTO recipeDTO, UserDetails userDetails) {
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

        Recipe savedRecipe = recipeRepository.save(recipe);
        for(WeightedIngredient weightedIngredient: savedRecipe.getWeightedIngredientSet()){
            weightedIngredient.setRecipe(savedRecipe);
            weightedIngredientService.add(weightedIngredient);
        }



        return savedRecipe;
    }*/
}
