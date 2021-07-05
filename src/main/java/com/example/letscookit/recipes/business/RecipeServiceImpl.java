package com.example.letscookit.recipes.business;

import com.example.letscookit.recipes.persistence.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RecipeServiceImpl implements  RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;


    @Override
    public int save(Recipe recipe) {
        return this.recipeRepository.save(recipe).getID();
    }

    @Override
    public RecipeForJson getRecipeStringFormat(int id) {
        Recipe o = this.recipeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                       String.format("Recipe with %d id does not exists",  id)));
        return new RecipeForJson(o);

    }

    @Override
    public Recipe getRecipe(int id) {
        return this.recipeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Recipe with %d id does not exists",  id)));
    }


    @Override
    public void delete(int id) {
        if (this.recipeRepository.findById(id).isPresent()) {
            this.recipeRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Recipe with %d id does not exists",  id));
        }
    }
}
