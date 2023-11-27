package app.recipes.menu;

public interface MenuCommand {
    void run();

    default String getTitle() {
        return "finish";
    }

}
