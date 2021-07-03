package com.example.letscookit.controller;

import com.example.letscookit.Recipe;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RecipeController {
    private Recipe recipe;
    @PostMapping("/recipe")
    public void setRecipe(@RequestBody Recipe recipe) {
        this.recipe = recipe;
    }
    @GetMapping("/recipe")
    public Recipe getRecipe(){
        return this.recipe;
    }


}
