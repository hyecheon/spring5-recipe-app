package hclee.springframework.spring5recipeapp.repository;

import hclee.springframework.spring5recipeapp.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
