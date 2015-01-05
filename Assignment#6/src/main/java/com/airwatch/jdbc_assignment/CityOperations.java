package com.airwatch.jdbc_assignment;

import java.sql.*;
import java.util.Random;

/**
 * Created by ABhat on 18 Aug 2014 - 18/08/14.
 */

public class CityOperations {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/world";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] citiesList = new String[]{"Airwatch", "VMWare", "EMC"};
        CityOperations operations = new CityOperations();
        operations.insertCities(citiesList, url);
        operations.queryCities(2000000, url);

    }

    public void queryCities(long population, String url) {
        String statement = "SELECT NAME FROM CITY WHERE POPULATION > ? AND COUNTRYCODE = ?";
        System.out.println("Cities with population > " + population + ":");
        try {
            Connection connection = DriverManager.getConnection(url, "airwatch", "airwatch");
            PreparedStatement queryStatement = connection.prepareStatement(statement);
            queryStatement.setLong(1, population);
            queryStatement.setString(2, "IND");
            ResultSet resultSet = queryStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                System.out.println(name);
            }

            queryStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCities(String[] cities, String url) {
        String insertStatement = "INSERT INTO CITY VALUES(?,?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection(url, "airwatch", "airwatch");
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
            connection.setAutoCommit(false);

            int i = 5000000;
            for (String city : cities) {
                preparedStatement.setInt(1, i++);
                preparedStatement.setString(2, city);
                preparedStatement.setString(3, "IND");
                preparedStatement.setString(4, "Karnataka");
                preparedStatement.setLong(5, new Random(System.currentTimeMillis()).nextInt(99999999));
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
            connection.commit();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
