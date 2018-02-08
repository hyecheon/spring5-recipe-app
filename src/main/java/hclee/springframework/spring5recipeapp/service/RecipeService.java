package hclee.springframework.spring5recipeapp.service;

import hclee.springframework.spring5recipeapp.commands.RecipeCommand;
import hclee.springframework.spring5recipeapp.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    public Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
