package com.jdbc.util;

import com.jdbc.dao.PostgresSQLDAO;
import com.jdbc.models.Capital;
import java.sql.SQLException;



public class MeasureTool{

    private class Coordinates{
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
        PostgresSQLDAO dao = new PostgresSQLDAO();

        if(!dao.isDataPresent("capitals", "name", firstCity)){
            System.out.println("No city found: " + firstCity + "!");
            return -1;
        }
        if(!dao.isDataPresent("capitals", "name", secondCity)){
            System.out.println("No city found: " + secondCity + "!");
            return -2;
        }

        Capital first = dao.getCapital(firstCity);
        Capital second = dao.getCapital(secondCity);

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
