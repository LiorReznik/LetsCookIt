package com.example.letscookit.recipes.business;


import com.example.letscookit.users.business.User;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "Recipe name cannot be empty.")
    private String name;
    @NotBlank(message = "Recipe description cannot be empty.")
    private String description;
    @NotBlank(message = "Recipe category cannot be empty.")
    private String category;
    @UpdateTimestamp
    private LocalDateTime date;
    @NotEmpty(message = "The recipe should contain at least one ingredient")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private List<Ingredient> ingredients;
    @NotEmpty(message = "The recipe should contain at least one direction")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private List<Direction> directions;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private User user;

    protected Recipe() {
    }


    public Recipe(String name, String description, String category, LocalDateTime date, List<Ingredient> ingredients, List<Direction> directions, User user) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.date = date;
        this.ingredients = ingredients;
        this.directions = directions;
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Integer getId() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}