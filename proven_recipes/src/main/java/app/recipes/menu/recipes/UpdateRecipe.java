package app.recipes.menu.recipes;

import app.recipes.entity.Recipe;
import app.recipes.menu.MenuCommand;
import app.recipes.repository.recipe.RecipesDao;
import app.recipes.repository.recipe.RecipesDaoImp;

import java.util.Scanner;

public class UpdateRecipe implements MenuCommand {
    RecipesDao recipesDao = new RecipesDaoImp();

    @Override
    public void run() {
        Recipe recipe = getRecipe();
        Boolean isUpdated = recipesDao.updateRecipe(recipe);
        if (isUpdated) {
            System.out.println("recipe updated");
        }
    }

    @Override
    public String getTitle() {
        return "update recipe";
    }

    public Recipe getRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input recipes id which your want to update");
        Long id = Long.parseLong(scanner.next());

        Recipe oldRecipe = recipesDao.findById(id);
        System.out.println("Enter the name of the recipe (input \\\"old\\\" for the old value)");
        String value = scanner.next();
        if (!value.equals("old")) {
            oldRecipe.setName(value);
        }
        System.out.println("Enter the description of the recipe (input \\\"old\\\" for the old value)");
        value = scanner.next();
        if (!value.equals("old")) {
            oldRecipe.setDescription(value);
        }
        System.out.println("Enter the image of the recipe (input \\\"old\\\" for the old value)");
        value = scanner.next();
        if (!value.equals("old")) {
            oldRecipe.setImage(value);
        }

        System.out.println("Enter the category of the recipe (input \\\"old\\\" for the old value)");
        value = scanner.next();
        if (!value.equals("old")) {
            oldRecipe.setCategory(value);
        }
        return oldRecipe;
    }

}
