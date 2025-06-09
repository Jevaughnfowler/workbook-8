package com.pluralsight;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String connectionString = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "yearup";

        // load the MySQL Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 1. open a connection to the database
        // use the database URL to point to the correct database
        Connection connection;
        connection = DriverManager.getConnection(connectionString, username, password);

        // create statement
        // the statement is tied to the open connection
        Statement statement = connection.createStatement();

        // 2. Execute your query

        String query = """
                SELECT
                productName
                FROM
                products""";
        ResultSet results = statement.executeQuery(query);

        // process the results
        while (results.next()) {
            String city = results.getString("productName");
            System.out.println(city);
        }
        //3. Close the connection
        connection.close();
    }
}