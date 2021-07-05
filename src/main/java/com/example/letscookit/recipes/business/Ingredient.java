package com.example.letscookit.recipes.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient {
    private @Id @GeneratedValue Integer id;
    private String ingredient;

    public Ingredient(String ingredient) {
        this.ingredient = ingredient;
    }

    protected Ingredient() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }


}
