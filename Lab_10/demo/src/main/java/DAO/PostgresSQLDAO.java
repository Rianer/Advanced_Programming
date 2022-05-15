package DAO;

import models.Message;
import models.User;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgresSQLDAO implements FriendDAO, UserDAO, MessageDAO {

    private final Connection con = DatabaseConnection.getConnection();

    public boolean isDataPresent(String table, String column, String value) throws SQLException{
        boolean found = false;
        String querry = "SELECT " + column + " FROM " + table + " WHERE " + column + "=?";
        PreparedStatement ps = con.prepareStatement(querry);
        ps.setString(1, value);

        ResultSet rs = ps.executeQuery();
        found = rs.next();
        return found;
    }

    public void clearTable(String tableName) throws SQLException {
        String sql = "DELETE FROM " + tableName;
        PreparedStatement ps = con.prepareStatement(sql);
        ps.executeUpdate();
    }

    @Override
    public List<User> getFriends(String name) throws SQLException {
        List<User> friendsList = new ArrayList<>();
        if(!isDataPresent("users", "name", name)){
            return null;
        }
        User user = getUser(name);
        String query = "SELECT friend_id FROM friends WHERE user_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, user.getId());
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            friendsList.add(getUser(rs.getInt("friend_id")));
        }
        return friendsList;
    }

    @Override
    public int addFriend(String userName, String friendName) throws SQLException {
        if(!isDataPresent("users", "name", userName) || !isDataPresent("users", "name", friendName)){
            return -1;
        }
        if(userName.equals(friendName)) return -2;

        User user = getUser(userName);
        User friend = getUser(friendName);

        String query = "SELECT friend_id FROM friends WHERE user_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, user.getId());

        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            if(rs.getInt("friend_id") == friend.getId()) return -3;
        }

        String sql = "INSERT INTO friends(user_id, friend_id) VALUES (?,?)";
        ps = con.prepareStatement(sql);
        ps.setInt(1,user.getId());
        ps.setInt(2,friend.getId());

        return ps.executeUpdate();
    }

    @Override
    public List<Message> getMessagesByReceiver(int userId) throws SQLException {
        List<Message> messages = new ArrayList<>();
        String query = "SELECT * FROM messages WHERE user_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,userId);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Message message = new Message();
            message.setUserId(userId);
            message.setSenderId(rs.getInt("sender_id"));
            message.setMessage(rs.getString("message"));
            messages.add(message);
        }
        return messages;
    }

    @Override
    public List<Message> getMessagesBySender(String name) throws SQLException {
        List<Message> messages = new ArrayList<>();
        User sender = getUser(name);
        String query = "SELECT * FROM messages WHERE sender_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, sender.getId());
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Message message = new Message();
            message.setUserId(rs.getInt("user_id"));
            message.setSenderId(rs.getInt("sender_id"));
            message.setMessage(rs.getString("message"));
            messages.add(message);
        }
        return messages;
    }

    @Override
    public int sendMessage(int userId, int receiverId, String message) throws SQLException {

        String sql = "INSERT INTO messages(user_id, sender_id, message) values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,receiverId);
        ps.setInt(2,userId);
        ps.setString(3,message);

        return ps.executeUpdate();
    }

    @Override
    public int addUser(String name) throws SQLException {
        if(isDataPresent("users", "name", name)){
            return -1;
        }
        String sql = "INSERT INTO users(name) VALUES (?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);

        return ps.executeUpdate();
    }

    @Override
    public User getUser(int id) throws SQLException {
        String query = "SELECT * FROM users WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        User user = new User();
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            return user;
        }
        return null;
    }

    @Override
    public User getUser(String name) throws SQLException {
        String query = "SELECT * FROM users WHERE name = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        User user = new User();
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            return user;
        }
        return null;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            User user = new User(rs.getInt("id"), rs.getString("name"));
            users.add(user);
        }
        return users;
    }

    @Override
    public int deleteReceivedMessages(String userName) throws SQLException {
        User sender = getUser(userName);
        String sql = "DELETE FROM messages WHERE user_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, sender.getId());
        return ps.executeUpdate();
    }

    @Override
    public int deleteSentMessages(int userId) throws SQLException {
        String sql = "DELETE FROM messages WHERE sender_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, userId);
        return ps.executeUpdate();
    }
}
