package com.example.letscookit.recipes.business;

public interface RecipeService {
    int save( Recipe recipe);
    RecipeForJson getRecipeStringFormat(int id);
    Recipe getRecipe(int id);
    void delete(int id);


}
