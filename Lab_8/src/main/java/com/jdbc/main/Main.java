package com.jdbc.main;

import com.jdbc.dao.PostgresSQLDAO;
import com.jdbc.models.Continent;
import com.jdbc.models.Country;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {

        PostgresSQLDAO sqlDAO = new PostgresSQLDAO();

        Country newCountry = new Country();
        newCountry.setName("Fake2");
        newCountry.setCode("+373");
        newCountry.setContinent("Fake");

        sqlDAO.addCountry(newCountry);

    }
}
