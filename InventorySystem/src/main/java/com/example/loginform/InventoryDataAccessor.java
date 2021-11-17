package com.example.loginform;

import java.sql.Connection ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
import java.sql.Statement ;
import java.sql.ResultSet ;

import java.util.List ;
import java.util.ArrayList ;

/**
 * This class is used to access the SQL database that is hosted locally.
 */
public class InventoryDataAccessor {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "grocery_store_inventory_subsystem";
        String databaseUser = "root";
        String databasePassword = "MYSQL3560!";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);


        } catch (Exception e) {
            System.out.println("Oops error");
            e.printStackTrace();
        }

        return databaseLink;
    }
}