package com.algonquin.gamehub.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Database Schema
    // CREATE DATABASE loggy DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
    // CREATE TABLE logs (uuid CHAR(40) NOT NULL PRIMARY KEY, title CHAR(128),
    // content TEXT, createTimestamp Date);

    private static final String dbUser = "root";
    private static final String dbPassword = "root";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/users";

    public static Connection getConnectionToDatabase() {
        Connection connection = null;
        
        try {
        	//Class.forName("com.mysql.jdbc.Driver");
        	connection = DriverManager.getConnection(CONN_STRING, dbUser, dbPassword);
        }catch (SQLException e) {
        	e.printStackTrace();
        } //catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
        return connection;
    }

}

