package app.recipes.menu.chats;

import app.recipes.menu.MenuCommand;
import app.recipes.repository.chat.ChatDao;
import app.recipes.repository.chat.ChatDaoImp;

public class FindAllChats implements MenuCommand {
    ChatDao chatDao = new ChatDaoImp();

    @Override

    public void run() {
        chatDao.findAll().forEach(System.out::println);
    }

    @Override
    public String getTitle() {
        return "find all chats";
    }
}
