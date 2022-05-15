package DAO;

import models.User;

import java.sql.SQLException;
import java.util.List;

public interface FriendDAO {
    public List<User> getFriends(String name) throws SQLException;
    public int addFriend(String userName, String friendName) throws SQLException;
}
