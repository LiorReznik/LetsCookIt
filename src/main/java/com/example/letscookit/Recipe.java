package com.example.letscookit;

import java.util.List;

public class Recipe {
    private static int counter = 0;
    private final int ID = counter++;
    private String name;
    private String description;
    private List<String> ingredients;
    private List<String> directions;

    public Recipe() {
    }

    public Recipe(String name, String description, List<String> ingredients, List<String> directions) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
    }
    public int getID() {
        return this.ID;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getDirections() {
        return this.directions;
    }

    public void setDirections(List<String> directions) {
        this.directions = directions;
    }

    public void addDirection(String direction) {
        this.directions.add(direction);
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }
}

