package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    //Class for establishing a connection with the database

    //Connection singleton
    private static Connection con = null;

    public static Connection getConnection() {
        return con;
    }

    //Static code block for instantiating the connection
    static {

        String url = "jdbc:postgresql://localhost:5432/AP_DB";
        String user = "root";
        String pass = "root";

        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }




}
