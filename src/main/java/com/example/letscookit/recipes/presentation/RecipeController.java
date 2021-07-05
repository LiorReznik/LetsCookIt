package com.example.letscookit.recipes.presentation;

import com.example.letscookit.recipes.business.Recipe;
import com.example.letscookit.recipes.business.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @PostMapping("/new")
    public Map<String, Integer> setRecipe(@Valid @RequestBody Recipe recipe) {
        int id = this.recipeService.save(recipe);
        return Map.of("id", id);
    }

    @GetMapping("/{id}")
    public Map<String, ?> getRecipe(@PathVariable int id) {
        return this.recipeService.getRecipeEndPointFormat(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        this.recipeService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @Valid @RequestBody Recipe recipe) {
        this.recipeService.update(id, recipe);
    }

    @GetMapping("/search")
    public List<Map<String, ?>> searchByCategoryOrName(@RequestParam("category") Optional<String> category,
                                                       @RequestParam("name") Optional<String> name) {
        this.checkNumOfParams(category, name);
        if (category.isPresent()) {
            return this.recipeService.searchByCategory(category.get());
        }
        return this.recipeService.searchByName(name.get());
    }

    private void checkNumOfParams(Optional<String> category, Optional<String> name) {
        if ((category.isEmpty() && name.isEmpty()) || (category.isPresent() && name.isPresent())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "you should pass category or name");
        }
    }


}
