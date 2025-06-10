package com.pluralsight;

import java.sql.*;

public class Northwind {

    public void displayProducts() throws SQLException, ClassNotFoundException {
        String connectionString = "jdbc:mysql://localhost:3306/northwind";
        String username = "root";
        String password = "yearup";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(connectionString, username, password);


        Statement statement = connection.createStatement();

        String query = "SELECT productID, productName, unitPrice, unitsInStock FROM products";
        ResultSet results = statement.executeQuery(query);

        // Header
        System.out.printf("%-5s %-30s %-10s %-10s%n", "ID", "Name", "Price", "Stock");
        System.out.println("-------------------------------------------------------------");

        while (results.next()) {
            int id = results.getInt("productID");
            String name = results.getString("productName");
            double price = results.getDouble("unitPrice");
            int stock = results.getInt("unitsInStock");

            System.out.printf("%-5d %-30s $%-9.2f %-10d%n", id, name, price, stock);
        }

        connection.close();
    }
}