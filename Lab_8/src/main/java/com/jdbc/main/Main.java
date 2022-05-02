package com.jdbc.main;

import com.jdbc.dao.PostgresSQLDAO;
import com.jdbc.models.Capital;
import com.jdbc.models.Continent;
import com.jdbc.models.Country;
import com.jdbc.util.CSVReader;
import com.jdbc.util.MeasureTool;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {

        PostgresSQLDAO sqlDAO = new PostgresSQLDAO();

        CSVReader reader = new CSVReader();
        reader.readCSV("src/main/resources/concap.csv");

        MeasureTool mt = new MeasureTool();
        System.out.println(mt.calculateDistance("Paris", "Lisbon"));

    }
}
