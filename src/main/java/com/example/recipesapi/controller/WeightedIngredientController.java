package com.example.recipesapi.controller;


import com.example.recipesapi.dto.WeightedIngredientDTO;

import com.example.recipesapi.entity.Ingredient;
import com.example.recipesapi.entity.WeightedIngredient;
import com.example.recipesapi.service.IngredientService;
import com.example.recipesapi.service.WeightedIngredientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("weightedingredients" )
public class WeightedIngredientController {


    @Autowired
    WeightedIngredientService weightedIngredientService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IngredientService ingredientService;



    // weightedingredients/id

    @PutMapping("{id}")
    public ResponseEntity<WeightedIngredientDTO> edit(@PathVariable long id, @RequestBody WeightedIngredientDTO weightedIngredientDTO){
        WeightedIngredient weightedIngredient = weightedIngredientService.findById(id).get();
        Ingredient ingredient = ingredientService.findById(weightedIngredientDTO.getIngredientId()).get();

        weightedIngredient.setIngredient(ingredient);
        weightedIngredient.setValue(weightedIngredientDTO.getValue());
        weightedIngredient.setUnit((weightedIngredientDTO.getUnit()));
        return new ResponseEntity<>(modelMapper.map(weightedIngredientService.update(weightedIngredient),WeightedIngredientDTO.class),HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id){
        if(weightedIngredientService.findById(id).isEmpty()){
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        weightedIngredientService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping("{id}")
    public ResponseEntity<WeightedIngredientDTO> getOne(@PathVariable long id){

        WeightedIngredient weightedIngredient = weightedIngredientService.findById(id).get();

        return new ResponseEntity<>(modelMapper.map(weightedIngredient,WeightedIngredientDTO.class),HttpStatus.OK);


    }















}
