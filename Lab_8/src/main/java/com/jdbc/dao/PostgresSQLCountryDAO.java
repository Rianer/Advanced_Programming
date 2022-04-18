package com.jdbc.dao;

import com.jdbc.models.Country;
import com.jdbc.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresSQLCountryDAO implements CountryDAO{

    static Connection con
            = DatabaseConnection.getConnection();
    @Override
    public Country getCountry(int id) throws SQLException {
        String sql = "select * from countries where id= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        Country country = new Country();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            country.setId(rs.getInt("id"));
            country.setName(rs.getString("name"));
            country.setContinent(rs.getString("continent"));
            country.setCode(rs.getString("code"));
        }

        if (check == true) {
            return country;
        }
        else
            return null;
    }

    @Override
    public Country getCountry(String name) throws SQLException {
        String sql = "select * from Countries where id= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);

        Country country = new Country();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            country.setId(rs.getInt("id"));
            country.setName(rs.getString("name"));
            country.setContinent(rs.getString("continent"));
            country.setCode(rs.getString("code"));
        }

        if (check == true) {
            return country;
        }
        else
            return null;
    }

    @Override
    public int addCountry(Country country) throws SQLException {
        String sql = "INSERT INTO "
                + "public.\"countries\"(id, name, continent, code) "
                + "VALUES(?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, country.getId());
        ps.setString(2, country.getName());
        ps.setString(3, country.getContinent());
        ps.setString(4, country.getCode());

        return ps.executeUpdate();
    }
}
