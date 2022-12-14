package com.example.recipesapi.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "recipe")
    private Set<WeightedIngredient> weightedIngredientSet = new HashSet<>();

    public Recipe(long id, String name, String description, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.user = user;
    }

    public Recipe() {
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

    public User getUserEntity() {
        return user;
    }

    public void setUserEntity(User user) {
        this.user = user;
    }

    public Set<WeightedIngredient> getWeightedIngredientSet() {
        return weightedIngredientSet;
    }

    public void setWeightedIngredientSet(Set<WeightedIngredient> weightedIngredientSet) {
        this.weightedIngredientSet = weightedIngredientSet;
    }
}
