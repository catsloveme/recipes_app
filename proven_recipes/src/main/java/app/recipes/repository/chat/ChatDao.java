package app.recipes.repository.chat;

import app.recipes.entity.Chat;

import java.util.List;

public interface ChatDao {
    Boolean register(String author, Long chat);

    Boolean unregister(Long chat_id);

    List<Chat> findAll();

}
