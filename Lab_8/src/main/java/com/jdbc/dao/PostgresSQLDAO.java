package com.jdbc.dao;

import com.jdbc.models.City;
import com.jdbc.models.Continent;
import com.jdbc.models.Country;
import com.jdbc.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresSQLDAO implements CountryDAO, ContinentDAO, CityDAO {

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

    public boolean isDataPresent(String table, String column, String value) throws SQLException{
        boolean found = false;
        String querry = "SELECT " + column + " FROM " + table + " WHERE " + column + "=?";
        PreparedStatement ps = con.prepareStatement(querry);
        ps.setString(1, value);

        ResultSet rs = ps.executeQuery();
        found = rs.next();
        return found;
    }

    private String getCountryCode(String country) throws SQLException{
        String querry = "SELECT code FROM countries WHERE name = " + country;
        PreparedStatement ps = con.prepareStatement(querry);


        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return rs.getString("code");
        }
        return "NULL";
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
        /*String querry = "SELECT id FROM continents WHERE name=?";
        PreparedStatement ps = con.prepareStatement(querry);
        ps.setString(1, country.getName());

        ResultSet rs = ps.executeQuery();
        if(!rs.next() ) { //&& !country.getContinent().equals("Unknown")
            System.out.println("Error: No such continent in the database!\nContinent provided: " + country.getContinent() +"\nCountry not added!");
            return -1;
        }*/
        if(!isDataPresent("continents", "name", country.getContinent())){
            System.out.println("Error: No such continent in the database!\nContinent provided: " + country.getContinent() +"\nCountry not added!");
            return -1;
        }
        String sql = "INSERT INTO "
                + "public.\"countries\"(id, name, continent, code) "
                + "VALUES(?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
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
        String sql = "select * from continents where name= ?";
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

    @Override
    public int addCity(City city) throws SQLException {

        String sql = "INSERT INTO public.cities(id,name,country,longitude,latitude, capital) VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, generateId("cities"));
        ps.setString(2, city.getName());
        ps.setString(3, city.getCountry());
        ps.setString(4, city.getLongitude());
        ps.setString(5, city.getLatitude());
        ps.setBoolean(6, city.getCapital());

        return ps.executeUpdate();
    }

    @Override
    public City getCity(String cityName) throws SQLException{
        String sql = "select * from cities where name= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cityName);

        City city = new City();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            city.setId(rs.getInt("id"));
            city.setName(rs.getString("name"));
            city.setCountry(rs.getString("country"));
            city.setLatitude(rs.getString("latitude"));
            city.setLongitude(rs.getString("longitude"));
            city.setCapital(rs.getBoolean("capital"));
        }

        if (check) {
            return city;
        }
        else
            return null;
    }

    @Override
    public City getCity(int id) throws SQLException{
        String sql = "select * from cities where id= ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        City city = new City();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            city.setId(rs.getInt("id"));
            city.setName(rs.getString("name"));
            city.setCountry(rs.getString("country"));
            city.setLatitude(rs.getString("latitude"));
            city.setLongitude(rs.getString("longitude"));
            city.setCapital(rs.getBoolean("capital"));
        }

        if (check) {
            return city;
        }
        else
            return null;
    }
}
