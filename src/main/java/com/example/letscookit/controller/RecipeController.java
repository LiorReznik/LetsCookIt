package com.example.letscookit.controller;

import com.example.letscookit.Recipe;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final Map<Integer, Recipe> recipes = new HashMap<>();

    @PostMapping("/new")
    public Map<String, Integer> setRecipe(@RequestBody Recipe recipe) {
        Integer id = recipe.getID();
        this.recipes.put(id, recipe);
        return Map.of("id", id);
    }

    @GetMapping("/{id}")
    public Map<String, ?> getRecipe(@PathVariable int id) {
        Recipe r = this.recipes.get(id);
        if (r == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return Map.of("name", r.getName(),
                "description", r.getDescription(),
                "ingredients", r.getIngredients(),
                "directions", r.getDirections()
        );
    }
    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable int id) {
        if (!this.recipes.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.recipes.remove(id);
    }
}
