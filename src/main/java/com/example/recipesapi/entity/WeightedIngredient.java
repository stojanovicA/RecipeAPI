package com.example.recipesapi.entity;

import javax.persistence.*;

@Entity
public class WeightedIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name="value_ingredient")
    private double value;

    private String unit;

    @ManyToOne
    private Ingredient ingredient;

    @ManyToOne
    private Recipe recipe;

    public WeightedIngredient(long id, double value, String unit, Ingredient ingredient, Recipe recipe) {
        this.id = id;
        this.value = value;
        this.unit = unit;
        this.ingredient = ingredient;
        this.recipe = recipe;
    }

    public WeightedIngredient() {
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

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }


}
