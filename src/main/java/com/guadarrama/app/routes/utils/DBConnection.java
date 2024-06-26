package com.guadarrama.app.routes.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String url = "jdbc:oracle:thin:@//127.0.0.1:1521/xe";
    private static String username = "SYSTEM";
    private static String password = "root";

    //methods:
    //Method to link database to Oracle Server
    public static Connection getInstance(){
        try {
            return DriverManager.getConnection(url, username, password);
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
