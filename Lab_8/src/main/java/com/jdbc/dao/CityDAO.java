package com.jdbc.dao;

import com.jdbc.models.City;

import java.sql.SQLException;

public interface CityDAO {
    public int addCity(City city) throws SQLException;

    public City getCity(String capitalName) throws SQLException;

    public City getCity(int id) throws SQLException;
}
