package com.example.recipesapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    

    public Ingredient(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Ingredient () {

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
}
