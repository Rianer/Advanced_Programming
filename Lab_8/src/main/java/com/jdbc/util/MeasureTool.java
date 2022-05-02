package com.jdbc.util;

import com.jdbc.dao.PostgresSQLDAO;
import com.jdbc.models.City;
import java.sql.SQLException;



public class MeasureTool{
    //Class used to measure distances between 2 cities in KM

    private class Coordinates{
        //As the name implies, this class stores the information about the coordinates of a city
        public double latitude;
        public double longitude;

        public Coordinates(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public Coordinates(String latitude, String longitude) {
            this.latitude = Double.parseDouble(latitude);
            this.longitude = Double.parseDouble(longitude);
        }

        public void transformToRadians(){
            latitude = latitude/(180/Math.PI);
            longitude = longitude/(180/Math.PI);
        }

        @Override
        public String toString() {
            return "Coordinates{" +
                    "latitude=" + latitude +
                    ", longitude=" + longitude +
                    '}';
        }
    }

    public double calculateDistance(String firstCity, String secondCity) throws SQLException {
        //firstCity, seconCity - 2 strings corresponding to the names of each city as found in the DB
        //Calculates the distance between firstCity's coordinates and secondCity's coordinates
        //Returns the distance in KM between the 2 cities
        //Returns -1 if firstCity was not identified in the database
        //Returns -2 if secondCity was not identified in the database
        PostgresSQLDAO dao = new PostgresSQLDAO();

        if(!dao.isDataPresent("cities", "name", firstCity)){
            System.out.println("No city found: " + firstCity + "!");
            return -1;
        }
        if(!dao.isDataPresent("cities", "name", secondCity)){
            System.out.println("No city found: " + secondCity + "!");
            return -2;
        }

        City first = dao.getCity(firstCity);
        City second = dao.getCity(secondCity);

        Coordinates origin = new Coordinates(first.getLatitude(), first.getLongitude());
        Coordinates destination = new Coordinates(second.getLatitude(), second.getLongitude());

        origin.transformToRadians();
        destination.transformToRadians();

        double distance = 3963 * Math.acos(
                (Math.sin(origin.latitude) * Math.sin(destination.latitude))
                + Math.cos(origin.latitude)  * Math.cos(destination.latitude)
                        * Math.cos(destination.longitude - origin.longitude)
        );

        distance = 1.609344 * distance; //get distance in KM

        return distance;
    }
}
