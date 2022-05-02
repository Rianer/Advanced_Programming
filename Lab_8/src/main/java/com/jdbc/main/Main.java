package com.jdbc.main;

import com.jdbc.dao.PostgresSQLDAO;
import com.jdbc.models.City;
import com.jdbc.models.Country;
import com.jdbc.util.CSVReader;
import com.jdbc.util.MeasureTool;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {

        //instance of DAO
        PostgresSQLDAO sqlDAO = new PostgresSQLDAO();
        //Dummy country
        Country fakeCountry = new Country();
        fakeCountry.setName("FakeCountry");
        fakeCountry.setContinent("Africa");
        fakeCountry.setCode("FC");
        //Dummy city
        City fakeCity = new City();
        fakeCity.setName("Night City");
        fakeCity.setCountry("FakeCountry");
        fakeCity.setLongitude("20.662527");
        fakeCity.setLatitude("8.264567");
        fakeCity.setCapital(true);

        /*sqlDAO.addCountry(fakeCountry);
        sqlDAO.addCity(fakeCity);*/

        //Accessing data from CSV file
        CSVReader reader = new CSVReader();
        reader.processCSV("src/main/resources/concap.csv");

        //Measuring distance between 2 cities
        MeasureTool mt = new MeasureTool();
        System.out.println(mt.calculateDistance("Paris", "Lisbon"));

    }
}
