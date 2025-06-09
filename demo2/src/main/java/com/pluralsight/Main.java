package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Hello, World!");

        String connectionString = "jdbc:mysql://localhost:3306/sakila";
        String username = "root";
        String password = "yearup";


        Class.forName("com.mysql.cj.jdbc.Driver");


        Connection connection = DriverManager.getConnection(connectionString, username, password);


        Statement statement = connection.createStatement();


        String query = "SELECT city FROM city WHERE country_id = 103";
        ResultSet results = statement.executeQuery(query);


        while (results.next()) {
            String city = results.getString("city");
            System.out.println(city);
        }

        // 3.Close connection
        connection.close();
    }
}