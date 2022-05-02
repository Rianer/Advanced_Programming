package com.jdbc.models;

import com.jdbc.dao.ContinentDAO;

public class Continent {
    //Class to represent a model of a continent as stored in the DB
    private int id;
    private String name;

    public Continent(){
        this.id = -1;
        this.name = "Unknown";
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

    @Override
    public String toString() {
        return "Continent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
