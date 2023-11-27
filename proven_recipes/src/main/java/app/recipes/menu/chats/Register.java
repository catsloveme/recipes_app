package app.recipes.menu.chats;

import app.recipes.menu.MenuCommand;
import app.recipes.repository.chat.ChatDao;
import app.recipes.repository.chat.ChatDaoImp;

import java.util.Scanner;

public class Register implements MenuCommand {
    ChatDao chatDao = new ChatDaoImp();

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the chat");
        Long chat_id = Long.parseLong(scanner.next());
        System.out.println("Enter the author of the recipe");
        String author = scanner.next();
        Boolean isRegister = chatDao.register(author, chat_id);
        if (isRegister) {
            System.out.println("Chat successfully registered");
        }

    }

    @Override
    public String getTitle() {
        return "register chat by id";
    }
}
