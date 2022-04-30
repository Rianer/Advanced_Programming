package com.jdbc.dao;

import com.jdbc.models.Capital;

import java.sql.SQLException;

public interface CapitalDAO {
    public int addCapital(Capital capital) throws SQLException;

    public Capital getCapital(String capitalName) throws SQLException;

    public Capital getCapital(int id) throws SQLException;
}
