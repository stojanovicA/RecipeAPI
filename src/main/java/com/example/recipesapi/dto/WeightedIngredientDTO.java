package com.example.recipesapi.dto;


import com.example.recipesapi.entity.WeightedIngredient;

public class WeightedIngredientDTO {

    private long id;

    private double value;

    private String unit;

    private long ingredientId;

    public WeightedIngredientDTO(long id, double value, String unit, Long ingredientId) {
        this.id = id;
        this.value = value;
        this.unit = unit;
        this.ingredientId = ingredientId;
    }

    public WeightedIngredientDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }



    public static WeightedIngredientDTO toDTO(WeightedIngredient weightedIngredient){
        WeightedIngredientDTO weightedIngredientDTO = new WeightedIngredientDTO();
        weightedIngredientDTO.setId(weightedIngredient.getId());
        weightedIngredientDTO.setValue(weightedIngredient.getValue());
        weightedIngredientDTO.setUnit(weightedIngredient.getUnit());
        weightedIngredientDTO.setIngredientId(weightedIngredient.getRecipe().getId());

        return weightedIngredientDTO;

    }
}
