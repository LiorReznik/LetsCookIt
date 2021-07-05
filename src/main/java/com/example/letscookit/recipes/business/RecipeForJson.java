package com.example.letscookit.recipes.business;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Deprecated
//TODO: rethink!
public class RecipeForJson {
    private final String name;

    private final String description;
    private final LocalDateTime date;
    private final List<String> ingredients;

    private final List<String> directions;

    public RecipeForJson(Recipe r) {
        System.out.println(r.getDate());
        System.out.println(r.getDate());
        this.name = r.getName();
        this.date = r.getDate();
        this.description = r.getDescription();
        this.ingredients = r.getIngredients().stream().map(x -> x.getIngredient()).collect(Collectors.toList());
        this.directions = r.getDirections().stream().map(x -> x.getDirection()).collect(Collectors.toList());
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
