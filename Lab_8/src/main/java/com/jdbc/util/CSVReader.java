package com.jdbc.util;

import com.jdbc.dao.PostgresSQLDAO;
import com.jdbc.models.City;
import com.jdbc.models.Continent;
import com.jdbc.models.Country;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {
    //Class used to read and store data from a CSV file
    //required data format:
    //CountryName,CapitalName,CapitalLatitude,CapitalLongitude,CountryCode,ContinentName
    private List<List<String>> records = new ArrayList<>();
    private PostgresSQLDAO dao = new PostgresSQLDAO();

    public void processCSV(String path) throws SQLException{
        parseCSVFile(path);
        saveData();
    }

    private void parseCSVFile(String path){
        //Reads CSV document by line and stores information in a table
        boolean first = true;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if(!first){
                    records.add(Arrays.asList(values));
                    /*System.out.println(records);
                    records.clear();*/
                }
                first = false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void saveData() throws SQLException {
        //For all read fields, stores corresponding data in the database
        for(List<String> parser : records){
            Continent continent = new Continent();
            continent.setName(parser.get(5));
            //System.out.println(continent);

            Country country = new Country();
            country.setName(parser.get(0));
            country.setContinent(continent.getName());
            country.setCode(parser.get(4));
            //System.out.println(country);

            City city = new City();
            city.setName(parser.get(1));
            city.setCountry(country.getName());
            city.setLatitude(parser.get(2));
            city.setLongitude(parser.get(3));
            city.setCapital(true);
            //System.out.println(capital);

            if(!dao.isDataPresent("continents","name",continent.getName())){
                dao.addContinent(continent);
            }
            if(!dao.isDataPresent("countries", "name", country.getName())){
                dao.addCountry(country);
            }
            if(!dao.isDataPresent("cities","name", city.getName())){
                dao.addCity(city);
            }
        }
    }



}
