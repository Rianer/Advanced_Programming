package com.jdbc.dao;

import com.jdbc.models.Country;

import java.sql.SQLException;

public interface CountryDAO {
    public Country getCountry(int id) throws SQLException;

    public Country getCountry(String name) throws SQLException;

    public int addCountry(Country country) throws SQLException;



}
