package DAO;

import models.Message;

import java.sql.SQLException;
import java.util.List;

public interface MessageDAO {
    public List<Message> getMessagesByReceiver(int userId) throws SQLException;
    public List<Message> getMessagesBySender(String name) throws SQLException;
    public int sendMessage(int userId, int receiverId, String message) throws SQLException;

    public int deleteReceivedMessages(String userName) throws SQLException;

    public int deleteSentMessages(int userId) throws SQLException;
}
