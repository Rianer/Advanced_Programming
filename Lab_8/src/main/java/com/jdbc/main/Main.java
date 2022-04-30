package com.jdbc.main;

import com.jdbc.dao.PostgresSQLDAO;
import com.jdbc.models.Capital;
import com.jdbc.models.Continent;
import com.jdbc.models.Country;
import com.jdbc.util.CSVReader;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {

        PostgresSQLDAO sqlDAO = new PostgresSQLDAO();


        Continent continent = new Continent();
        continent.setName("Europe");

        Capital capital = new Capital();
        capital.setLongitude("long");
        capital.setLatitude("lat");
        capital.setCountry("Fake");
        capital.setName("FakeName");
        //sqlDAO.addCapital(capital);
        //sqlDAO.addContinent(continent);
        CSVReader reader = new CSVReader();
        reader.readCSV("src/main/resources/concap.csv");

    }
}
