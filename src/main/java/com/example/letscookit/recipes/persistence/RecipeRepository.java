package com.example.letscookit.recipes.persistence;

import com.example.letscookit.recipes.business.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    List<Recipe> findAllByCategoryIgnoreCaseOrderByDateDesc(String category);

    List<Recipe> findAllByNameContainingIgnoreCaseOrderByDateDesc(String name);

}

