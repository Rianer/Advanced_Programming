package com.jdbc.models;

public class Country {
    //Class to represent a model of a city as stored in the DB
    private int id;
    private String name;
    private String continent;
    private String code;

    public Country() {
        this.name = "Unknown";
        this.continent = "Unknown";
        this.code = "--";
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

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
