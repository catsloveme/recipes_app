package app.recipes.menu.recipes;

import app.recipes.menu.MenuCommand;
import app.recipes.repository.recipe.RecipesDao;
import app.recipes.repository.recipe.RecipesDaoImp;

import java.util.Scanner;

public class FindRecipeByCategory implements MenuCommand {
    RecipesDao recipesDao = new RecipesDaoImp();

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the category of the recipe");
        System.out.println(recipesDao.findByCategory(scanner.next()));
    }

    @Override
    public String getTitle() {
        return "find recipe by category";
    }


}
