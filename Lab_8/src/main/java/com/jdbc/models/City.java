package com.jdbc.models;

public class City {
    //Class to represent a model of a city as stored in the DB
    private int id;
    private String name;
    private String latitude;
    private String longitude;
    private String country;
    private Boolean isCapital;

    public City(){
        this.country = "Unknown";
        this.name = "Unknown";
        this.latitude = "Unknown";
        this.longitude = "Unknown";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getCapital() {
        return isCapital;
    }

    public void setCapital(Boolean capital) {
        isCapital = capital;
    }

    @Override
    public String toString() {
        return "Capital{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
