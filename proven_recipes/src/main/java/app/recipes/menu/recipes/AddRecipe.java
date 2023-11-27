package app.recipes.menu.recipes;

import app.recipes.entity.Recipe;
import app.recipes.menu.MenuCommand;
import app.recipes.repository.recipe.RecipesDao;
import app.recipes.repository.recipe.RecipesDaoImp;

import java.util.Scanner;

public class AddRecipe implements MenuCommand {
    RecipesDao recipesDao = new RecipesDaoImp();

    @Override
    public void run() {
        Boolean isAdding = recipesDao.addRecipe(getRecipe(), getChatId());
        if (isAdding) {
            System.out.println("Recipe saved");
        }
    }

    @Override
    public String getTitle() {
        return "add new recipe";
    }

    public Recipe getRecipe() {
        Scanner scanner = new Scanner(System.in);

        Recipe recipe = new Recipe();
        System.out.println("Enter the name of the recipe");
        recipe.setName(scanner.next());

        System.out.println("Enter the description of the recipe");
        recipe.setDescription(scanner.next());

        System.out.println("Enter the image of the recipe");
        recipe.setImage(scanner.next());

        System.out.println("Enter the category of the recipe");
        recipe.setCategory(scanner.next());
        return recipe;
    }

    public Long getChatId() {
        System.out.println("Enter the id of the chat");
        Scanner scanner = new Scanner(System.in);
        return Long.valueOf(scanner.next());
    }
}
