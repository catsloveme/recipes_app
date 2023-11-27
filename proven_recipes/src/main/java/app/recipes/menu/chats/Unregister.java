package app.recipes.menu.chats;

import app.recipes.menu.MenuCommand;
import app.recipes.repository.chat.ChatDao;
import app.recipes.repository.chat.ChatDaoImp;

import java.util.Scanner;

public class Unregister implements MenuCommand {
    ChatDao chatDao = new ChatDaoImp();

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the id of the chat");
        Long chat_id = Long.parseLong(scanner.next());
        Boolean isRegister = chatDao.unregister(chat_id);
        if (isRegister) {
            System.out.println("Chat successfully unregistered");
        }
    }

    @Override
    public String getTitle() {
        return "unregister chat by id";
    }
}
