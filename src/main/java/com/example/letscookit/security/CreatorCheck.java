package com.example.letscookit.security;

import com.example.letscookit.recipes.business.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CreatorCheck {
    @Autowired
    private RecipeService recipeService;

    public boolean check(int id, UserDetails curUser) {
        System.out.println(this.recipeService.getRecipe(id).getUser());
        return this.recipeService.getRecipe(id).getUser().getEmail().equals(curUser.getUsername());
    }
}