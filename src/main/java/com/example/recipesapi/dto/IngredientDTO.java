package com.example.recipesapi.dto;

import com.example.recipesapi.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class IngredientDTO {

    private long id;

    private String name;


    public IngredientDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public IngredientDTO () {

    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static IngredientDTO toDTO(Ingredient ingredient){
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setid(ingredient.getid());
        ingredientDTO.setName(ingredient.getName());
        return ingredientDTO;

    }

    public static List<IngredientDTO> toDTO(List<Ingredient> ingredients){
        List<IngredientDTO> ingredientDTOS = new ArrayList<>();
        for(Ingredient ingredient: ingredients){
            ingredientDTOS.add(toDTO(ingredient));
        }
        return ingredientDTOS;

    }


}
