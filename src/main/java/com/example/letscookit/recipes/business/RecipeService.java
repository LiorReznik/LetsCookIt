package com.example.letscookit.recipes.business;

import java.util.List;
import java.util.Map;

public interface RecipeService {
    int save(Recipe recipe);

    Map<String, ?> getRecipeEndPointFormat(int id);

    Recipe getRecipe(int id);

    void delete(int id);

    void update(int id, Recipe recipe);

    List<Map<String, ?>> searchByName(String name);

    List<Map<String, ?>> searchByCategory(String category);


}


