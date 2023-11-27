package app.recipes.menu.recipes;

import app.recipes.menu.MenuCommand;
import app.recipes.repository.recipe.RecipesDao;
import app.recipes.repository.recipe.RecipesDaoImp;

public class FindAllRecipe implements MenuCommand {
    RecipesDao recipesDao = new RecipesDaoImp();

    @Override
    public void run() {

        recipesDao.findAll().forEach(System.out::println);
    }

    @Override
    public String getTitle() {
        return "find all recipes";
    }


}
