package com.jdbc.main;

import com.jdbc.dao.PostgresSQLDAO;
import com.jdbc.models.City;
import com.jdbc.models.Continent;
import com.jdbc.models.Country;
import com.jdbc.util.CSVReader;
import com.jdbc.util.MeasureTool;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {

        //instance of DAO
        PostgresSQLDAO sqlDAO = new PostgresSQLDAO();

        sqlDAO.clearTable("cities");
        sqlDAO.clearTable("continents");
        sqlDAO.clearTable("countries");

        //Dummy continent
        Continent fakeContinent = new Continent();
        fakeContinent.setName("FakeContinent");
        //Dummy country
        Country fakeCountry = new Country();
        fakeCountry.setName("FakeCountry");
        fakeCountry.setContinent("FakeContinent");
        fakeCountry.setCode("FC");
        //Dummy city
        City fakeCity = new City();
        fakeCity.setName("Fake City");
        fakeCity.setCountry("FakeCountry");
        fakeCity.setLongitude("20.662527");
        fakeCity.setLatitude("8.264567");
        fakeCity.setCapital(true);

        sqlDAO.addContinent(fakeContinent);
        sqlDAO.addCountry(fakeCountry);
        sqlDAO.addCity(fakeCity);

        //Accessing data from CSV file
        CSVReader reader = new CSVReader();
        reader.processCSV("src/main/resources/concap.csv");

        //Measuring distance between 2 cities
        MeasureTool mt = new MeasureTool();
        System.out.println(mt.calculateDistance("Paris", "Lisbon"));
        System.out.println(mt.calculateDistance("London", "Brasilia"));
        System.out.println(mt.calculateDistance("Fake City", "Unrecorded City"));
    }
}
