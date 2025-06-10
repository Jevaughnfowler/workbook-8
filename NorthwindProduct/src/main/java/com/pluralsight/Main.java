package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        try {
            Northwind app = new Northwind();
            app.displayProducts();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}