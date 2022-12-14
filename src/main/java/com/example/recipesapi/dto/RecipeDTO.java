package com.example.recipesapi.dto;


import com.example.recipesapi.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {

    private long id;

    private String name;

    private String description;

    private List<WeightedIngredientDTO> weightedIngredients = new ArrayList<>();

    public RecipeDTO() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WeightedIngredientDTO> getWeightedIngredients() {
        return weightedIngredients;
    }

    public void setWeightedIngredientDTO(List<WeightedIngredientDTO> weightedIngredientDTO) {
        this.weightedIngredients = weightedIngredientDTO;
    }
}


