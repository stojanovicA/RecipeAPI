package com.example.recipesapi.controller;



import com.example.recipesapi.converters.RecipeDTOtoRecipe;
import com.example.recipesapi.converters.RecipeToRecipeDTO;
import com.example.recipesapi.converters.WeightedIngredientToWeightedIngredientDTO;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    WeightedIngredientService weightedIngredientService;


    @Autowired
    IngredientService ingredientService;

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeDTOtoRecipe recipeDTOtoRecipe;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @Autowired
    RecipeToRecipeDTO recipeToRecipeDTO;

    @Autowired
    WeightedIngredientToWeightedIngredientDTO weightedIngredientToWeightedIngredientDTO;

    @GetMapping
    public ResponseEntity<List<RecipeDTO>> getAll(@AuthenticationPrincipal UserDetails userDetails){

        //uradjeno

        List<Recipe> recipes =  recipeService.findByUserId(Long.valueOf(userDetails.getUsername()));
        return new ResponseEntity<>(recipeToRecipeDTO.convert(recipes), HttpStatus.OK );
        }


     @PostMapping
    public ResponseEntity<RecipeDTO> save(@RequestBody RecipeDTO recipeDTO,@AuthenticationPrincipal UserDetails userDetails){

       Recipe savedRecipe =recipeDTOtoRecipe.convert(recipeDTO,userDetails);


        return new ResponseEntity<>(modelMapper.map(savedRecipe,RecipeDTO.class),HttpStatus.CREATED);

     }

     @GetMapping("{id}")
    public ResponseEntity<RecipeDTO> findById(@PathVariable long id){
           Optional< Recipe> optionalRecipe = recipeService.findById(id);
         if(optionalRecipe.isEmpty()){
             return new ResponseEntity(HttpStatus.NOT_FOUND);
         }



        return new ResponseEntity<>(modelMapper.map(optionalRecipe.get(),RecipeDTO.class),HttpStatus.OK);

     }


     @GetMapping("{id}/weightedingredients")
    public  ResponseEntity<List<WeightedIngredientDTO>> findAll(@PathVariable long id){
         Optional< Recipe> optionalRecipe = recipeService.findById(id);
         if(optionalRecipe.isEmpty()){
             return new ResponseEntity(HttpStatus.NOT_FOUND);
         }
         List<WeightedIngredientDTO> weightedIngredientDTOS = new ArrayList<>();
         for(WeightedIngredient weightedIngredient: optionalRecipe.get().getWeightedIngredientSet()){
             weightedIngredientDTOS.add(modelMapper.map(weightedIngredient, WeightedIngredientDTO.class));
         }
         return  new ResponseEntity<>(weightedIngredientDTOS,HttpStatus.OK);




     }

     @PostMapping("{id}/weightedingredients")
    public ResponseEntity<WeightedIngredientDTO> save(@PathVariable long id, @RequestBody WeightedIngredientDTO weightedIngredientDTO){
         Optional< Recipe> optionalRecipe = recipeService.findById(id);
         if(optionalRecipe.isEmpty()){
             return new ResponseEntity(HttpStatus.NOT_FOUND);
         }

         Optional<Ingredient> optionalIngredient = ingredientService.findById(weightedIngredientDTO.getIngredientId());
         if(optionalIngredient.isEmpty()){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }


         WeightedIngredient weightedIngredient = modelMapper.map(weightedIngredientDTO, WeightedIngredient.class);

         Recipe recipe = optionalRecipe.get();
         weightedIngredient.setRecipe(recipe);
         weightedIngredient.setIngredient(optionalIngredient.get());

       //  zavrseno
            return new ResponseEntity<>(weightedIngredientToWeightedIngredientDTO
                    .convert(weightedIngredient),HttpStatus.CREATED);
    }





}
