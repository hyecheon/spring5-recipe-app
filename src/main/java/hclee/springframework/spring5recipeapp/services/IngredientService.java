package hclee.springframework.spring5recipeapp.services;

import hclee.springframework.spring5recipeapp.commands.IngredientCommand;
import hclee.springframework.spring5recipeapp.domain.Recipe;
import org.springframework.stereotype.Service;

@Service
public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand ingredientCommand);

    Recipe deleteById(Long recipeId, Long id);
}
