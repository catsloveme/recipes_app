package app.recipes.menu;

import app.recipes.menu.chats.FindAllChats;
import app.recipes.menu.chats.Register;
import app.recipes.menu.chats.Unregister;
import app.recipes.menu.recipes.*;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MenuImp {
    private static boolean exitButton = false;
    private static final Map<Integer, MenuCommand> menu = new TreeMap<>();

    static {
        menu.put(0, () -> exitButton = true);
        menu.put(1, new Register());
        menu.put(2, new Unregister());
        menu.put(3, new FindAllChats());
        menu.put(4, new AddRecipe());
        menu.put(5, new FindAllRecipe());
        menu.put(6, new FindRecipeByCategory());
        menu.put(7, new UpdateRecipe());
        menu.put(8, new DeleteRecipe());
    }

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        do {
            printMenuChoices();
            Integer choice = scanner.nextInt();
            if (menu.containsKey(choice)) {
                menu.get(choice).run();
            } else {
                System.out.println("Choose one command that represents in menu ");
            }

        } while (!exitButton);
    }

    private void printMenuChoices() {
        System.out.println("----------------");
        System.out.println("Select your choice : ");
        menu.forEach((k, v) -> System.out.println(k + " - " + v.getTitle()));
    }
}
