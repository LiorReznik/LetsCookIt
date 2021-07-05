package com.example.letscookit.recipes.business;

import com.example.letscookit.recipes.persistence.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;


    @Override
    public int save(Recipe recipe) {
        return this.recipeRepository.save(recipe).getID();
    }

    @Override
    public Map<String, ?> getRecipeEndPointFormat(int id) {
        Recipe o = this.recipeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Recipe with %d id does not exists", id)));
        //  return new RecipeForJson(o);
        return this.convertRecipeToMap(o);

    }

    private Map<String, ?> convertRecipeToMap(Recipe o) {
        return Map.of("name", o.getName(),
                "category", o.getCategory(),
                "description", o.getDescription(),
                "date", o.getDate().toString(),
                "directions", o.getDirections().stream().map(x -> x.getDirection()).collect(Collectors.toList()),
                "ingredients", o.getIngredients().stream().map(x -> x.getIngredient()).collect(Collectors.toList())
        );

    }

    @Override
    public Recipe getRecipe(int id) {
        return this.recipeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Recipe with %d id does not exists", id)));
    }


    @Override
    public void delete(int id) {
        if (this.recipeRepository.findById(id).isPresent()) {
            this.recipeRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Recipe with %d id does not exists", id));
        }
    }

    @Override
    @Transactional
    public void update(int id, Recipe recipe) {
        Recipe old = this.recipeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Recipe with %d id does not exists", id)));
        old.setName(recipe.getName());
        old.setCategory(recipe.getCategory());
        old.setDescription(recipe.getDescription());
        old.setIngredients(recipe.getIngredients());
        old.setDirections(recipe.getDirections());
    }

    public List<Map<String, ?>> searchByName(String name) {
        List<Recipe> recipes = this.recipeRepository.findAllByNameContainingIgnoreCaseOrderByDateDesc(name);
        return recipes.stream().map(x -> this.convertRecipeToMap(x)).collect(Collectors.toList());
    }

    public List<Map<String, ?>> searchByCategory(String category) {
        List<Recipe> recipes = this.recipeRepository.findAllByCategoryIgnoreCaseOrderByDateDesc(category);
        return recipes.stream().map(x -> this.convertRecipeToMap(x)).collect(Collectors.toList());
    }
}
