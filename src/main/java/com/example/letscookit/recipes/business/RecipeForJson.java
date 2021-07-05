package com.example.letscookit.recipes.business;

import java.util.List;
import java.util.stream.Collectors;

//TODO: rethink!
public class RecipeForJson {
    private String name;

    private String description;

    private List<String> ingredients;

    private List<String> directions;

    public RecipeForJson(Recipe r) {
        this.name = r.getName();
        this.description = r.getDescription();
        this.ingredients = r.getIngredients().stream().map(x->x.getIngredient()).collect(Collectors.toList());
        this.directions = r.getDirections().stream().map(x->x.getDirection()).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getDirections() {
        return directions;
    }
}
