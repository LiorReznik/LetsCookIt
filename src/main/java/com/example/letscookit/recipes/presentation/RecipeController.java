package com.example.letscookit.recipes.presentation;

import com.example.letscookit.recipes.business.Recipe;
import com.example.letscookit.recipes.business.RecipeForJson;
import com.example.letscookit.recipes.business.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @PostMapping("/new")
    public Map<String, Integer> setRecipe(@Valid @RequestBody Recipe recipe) {
        int id = this.recipeService.save(recipe);
        return Map.of("id",id);
    }
    @GetMapping("/{id}")
    public RecipeForJson getRecipe(@PathVariable int id){
        return this.recipeService.getRecipeStringFormat(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        this.recipeService.delete(id);
    }


}
