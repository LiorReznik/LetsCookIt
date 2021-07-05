package com.example.letscookit.recipes.business;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
@JsonIgnoreProperties(value={"id"})
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    @NotBlank(message = "Recipe name cannot be empty.")
    private String name;

    @NotBlank(message = "Recipe description cannot be empty.")
    private String description;

    @NotEmpty(message = "The recipe should contain at least one ingredient")
    @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name="recpie_id")
    private List<Ingredient> ingredients;

    @NotEmpty(message = "The recipe should contain at least one direction")
    @OneToMany(cascade = CascadeType.ALL)
    //  @JoinColumn(name="recpie_id")
    private List<Direction> directions;

    protected Recipe() {
    }

    public Recipe(String name, String description, List<Ingredient> ingredients, List<Direction> directions) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
    }
    public int getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Direction> getDirections() {
        return this.directions;
    }

    public void setDirections(List<Direction> directions) {
        this.directions = directions;
    }

    public void addDirection(Direction direction) {
        this.directions.add(direction);
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

}