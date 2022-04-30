package com.jdbc.dao;

import com.jdbc.models.Continent;
import com.jdbc.models.Country;
import com.jdbc.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresSQLDAO implements CountryDAO, ContinentDAO{

    private final Connection con
            = DatabaseConnection.getConnection();

    private int generateId(String table) throws SQLException{
        int result = 1;
        String querry = "SELECT id FROM " + table + " ORDER BY id DESC limit 1";
        PreparedStatement ps = con.prepareStatement(querry);

        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            result = rs.getInt("id");
            result++;
        }
        return result;
    }

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

        if (check) {
            return country;
        }
        else
            return null;
    }

    @Override
    public Country getCountry(String name) throws SQLException {
        String sql = "select * from Countries where name= ?";
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

        if (check) {
            return country;
        }
        else
            return null;
    }

    @Override
    public int addCountry(Country country) throws SQLException {
        String querry = "SELECT id FROM continents WHERE name=?";
        PreparedStatement ps = con.prepareStatement(querry);
        ps.setString(1, country.getName());

        ResultSet rs = ps.executeQuery();
        if(!rs.next() && !country.getContinent().equals("Unknown")) {
            System.out.println("Error: No such continent in the database!\nContinent provided: " + country.getContinent() +"\nCountry not added!");
            return -1;
        }

        String sql = "INSERT INTO "
                + "public.\"countries\"(id, name, continent, code) "
                + "VALUES(?, ?, ?, ?)";
        ps = con.prepareStatement(sql);
        ps.setInt(1, generateId("countries"));
        ps.setString(2, country.getName());
        ps.setString(3, country.getContinent());
        ps.setString(4, country.getCode());

        return ps.executeUpdate();
    }

    @Override
    public Continent getContinent(int id) throws SQLException {
        String sql = "select * from continents where id= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        Continent continent = new Continent();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            continent.setId(rs.getInt("id"));
            continent.setName(rs.getString("name"));
        }

        if (check) {
            return continent;
        }
        else
            return null;
    }

    @Override
    public Continent getContinent(String name) throws SQLException {
        String sql = "select * from Countries where name= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);

        Continent continent = new Continent();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            continent.setId(rs.getInt("id"));
            continent.setName(rs.getString("name"));
        }

        if (check) {
            return continent;
        }
        else
            return null;
    }

    @Override
    public int addContinent(Continent continent) throws SQLException {
        String sql = "INSERT INTO "
                + "public.\"continents\"(id, name) "
                + "VALUES(?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, generateId("continents"));
        ps.setString(2, continent.getName());

        return ps.executeUpdate();
    }
}
