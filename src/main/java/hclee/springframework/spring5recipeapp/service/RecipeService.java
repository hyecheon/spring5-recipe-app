package hclee.springframework.spring5recipeapp.service;

import hclee.springframework.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    public Set<Recipe> getRecipes();
}
