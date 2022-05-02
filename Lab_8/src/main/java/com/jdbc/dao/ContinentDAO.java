package com.jdbc.dao;

import com.jdbc.models.Continent;

import java.sql.SQLException;

public interface ContinentDAO {
    //DAO for continents

    public Continent getContinent(int id) throws SQLException;

    public Continent getContinent(String name) throws SQLException;

    public int addContinent(Continent continent) throws SQLException;
}
