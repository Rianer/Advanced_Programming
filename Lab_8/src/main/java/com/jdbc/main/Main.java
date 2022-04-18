package com.jdbc.main;

import com.jdbc.dao.PostgresSQLCountryDAO;
import com.jdbc.models.Country;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {
        Country country = new Country();
        country.setId(2);
        country.setName("Germany");
        country.setContinent("Europe");
        country.setCode("+49");

        PostgresSQLCountryDAO countryDAO = new PostgresSQLCountryDAO();

        countryDAO.addCountry(country);

        Country newCountry = countryDAO.getCountry(2);

        System.out.println(newCountry);
    }
}
