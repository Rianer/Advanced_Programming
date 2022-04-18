package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static Connection con = null;

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

    public static Connection getConnection()
    {
        return con;
    }


}
