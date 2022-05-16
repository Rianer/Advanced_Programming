package DAO;

import models.User;

import java.sql.SQLException;

public interface UserDAO {
    public int addUser(String name) throws SQLException;
    public User getUser(int id) throws SQLException;
    public User getUser(String name) throws SQLException;

    public int deleteUser(int id) throws SQLException;
}
