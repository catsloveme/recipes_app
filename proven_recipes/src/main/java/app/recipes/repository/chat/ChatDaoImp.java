package app.recipes.repository.chat;

import app.recipes.entity.Chat;
import app.recipes.repository.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChatDaoImp implements ChatDao {
    private final Connection connection = DatabaseConnector.getConnection();

    @Override
    public Boolean register(String author, Long chat_id) {
        boolean isRegister = false;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into chats (chat_id, author) values (?,?)");
            ps.setLong(1, chat_id);
            ps.setString(2, author);

            isRegister = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRegister;
    }

    @Override
    public Boolean unregister(Long id) {
        boolean isUnregister = false;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from chats where chat_id = ?");
            ps.setLong(1, id);

            isUnregister = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUnregister;
    }

    @Override
    public List<Chat> findAll() {
        List<Chat> chats = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "select * from chats");

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Chat chat = new Chat();
                chat.setId(result.getLong(1));
                chat.setAuthor(result.getString(2));

                chats.add(chat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chats;

    }
}
