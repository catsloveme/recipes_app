package app.recipes.repository.recipe;

import app.recipes.entity.Chat;
import app.recipes.entity.Recipe;
import app.recipes.repository.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipesDaoImp implements RecipesDao {
    private final Connection connection = DatabaseConnector.getConnection();

    @Override
    public Boolean addRecipe(Recipe recipe, Long chat_id) {
        boolean isAdding = false;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into recipes (name, image, description, category, chat_id ) values (?, ?, ?, ?, ?)");
            ps.setString(1, recipe.getName());
            ps.setString(2, recipe.getImage());
            ps.setString(3, recipe.getDescription());
            ps.setString(4, recipe.getCategory());
            ps.setLong(5, chat_id);

            isAdding = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdding;
    }

    @Override
    public List<Recipe> findAll() {
        List<Recipe> recipes = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "select * from recipes inner join chats on chats.chat_id = recipes.chat_id  ");

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(result.getLong(1));
                recipe.setName(result.getString(2));
                recipe.setImage(result.getString(3));
                recipe.setDescription(result.getString(4));
                recipe.setCategory(result.getString(5));
                Chat chat = new Chat();
                chat.setId(result.getLong(7));
                chat.setAuthor(result.getString(9));
                recipe.setChat(chat);

                recipes.add(recipe);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    @Override
    public List<Recipe> findByCategory(String category) {
        List<Recipe> recipes = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "select * from recipes inner join chats on chats.chat_id = recipes.chat_id where category=? ");
            ps.setString(1, category);

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(result.getLong(1));
                recipe.setName(result.getString(2));
                recipe.setImage(result.getString(3));
                recipe.setDescription(result.getString(4));
                recipe.setCategory(result.getString(5));
                Chat chat = new Chat();
                chat.setId(result.getLong(7));
                chat.setAuthor(result.getString(9));
                recipe.setChat(chat);

                recipes.add(recipe);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    public Recipe findById(Long id) {
        Recipe recipe = new Recipe();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "select * from recipes inner join chats on chats.chat_id = recipes.chat_id where recipes.recipe_id=? ");
            ps.setLong(1, id);

            ResultSet result = ps.executeQuery();
            while (result.next()) {

                recipe.setId(result.getLong(1));
                recipe.setName(result.getString(2));
                recipe.setImage(result.getString(3));
                recipe.setDescription(result.getString(4));
                recipe.setCategory(result.getString(5));
                Chat chat = new Chat();
                chat.setId(result.getLong(7));
                chat.setAuthor(result.getString(9));
                recipe.setChat(chat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipe;
    }

    @Override
    public Boolean updateRecipe(Recipe recipe) {
        boolean isUpdating = false;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "update recipes set name=?, image=?, description=?, category=?, chat_id=? where recipe_id = ?");
            ps.setString(1, recipe.getName());
            ps.setString(2, recipe.getImage());
            ps.setString(3, recipe.getDescription());
            ps.setString(4, recipe.getCategory());
            ps.setLong(5, recipe.getChat().getId());
            ps.setLong(6, recipe.getId());

            isUpdating = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdating;


    }

    @Override
    public Boolean deleteRecipe(Long id) {
        boolean isDeleted = false;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from recipes where recipe_id =?");
            ps.setLong(1, id);

            isDeleted = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
}
