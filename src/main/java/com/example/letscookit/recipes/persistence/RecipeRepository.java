package com.example.letscookit.recipes.persistence;

import com.example.letscookit.recipes.business.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Integer> {
}
