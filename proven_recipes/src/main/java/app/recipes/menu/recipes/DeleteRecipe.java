package app.recipes.menu.recipes;

import app.recipes.menu.MenuCommand;
import app.recipes.repository.recipe.RecipesDao;
import app.recipes.repository.recipe.RecipesDaoImp;

import java.util.Scanner;

public class DeleteRecipe implements MenuCommand {
    RecipesDao recipesDao = new RecipesDaoImp();

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Employee id which your want to update");
        Long id = Long.parseLong(scanner.next());
        Boolean isDeleted = recipesDao.deleteRecipe(id);
        if (isDeleted) {
            System.out.println("recipe removed");
        }
    }

    @Override
    public String getTitle() {
        return "delete recipe by id";
    }


}
