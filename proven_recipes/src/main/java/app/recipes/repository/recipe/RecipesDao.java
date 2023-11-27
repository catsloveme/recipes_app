package app.recipes.repository.recipe;

import app.recipes.entity.Recipe;

import java.util.List;

public interface RecipesDao {
    Boolean addRecipe(Recipe recipe, Long chat_id);

    List<Recipe> findAll();

    List<Recipe> findByCategory(String category);

    Recipe findById(Long id);

    Boolean updateRecipe(Recipe recipe);

    Boolean deleteRecipe(Long id);


}
