package com.airwatch.jdbc_assignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ABhat on 18 Aug 2014 - 18/08/14.
 */
public class MetadataOperations {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/world";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        MetadataOperations operations = new MetadataOperations();
        operations.getMetadata(url);
    }

    public void getMetadata(String url) {
        try {
            Connection connection = DriverManager.getConnection(url, "airwatch", "airwatch");
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet result = metaData.getTables(null, null, null, null);
            List<String> tables = new ArrayList<>();
            while (result.next())
                tables.add(result.getString(3));
            for (String table : tables) {
                System.out.println("Table : " + table + "\nColumns:");
                result = metaData.getColumns(null, null, table, null);
                while (result.next())
                    System.out.println(result.getString(4));
                System.out.println("\nPrimary Keys:");
                result = metaData.getPrimaryKeys(null, null, table);
                while (result.next())
                    System.out.println(result.getString(4));
                System.out.println("=================");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//        Table : city
//        Columns:
//        ID
//        Name
//        CountryCode
//        District
//        Population
//
//        Primary Keys:
//        ID
//        =================
//        Table : country
//        Columns:
//        Code
//        Name
//        Continent
//        Region
//        SurfaceArea
//        IndepYear
//        Population
//        LifeExpectancy
//        GNP
//        GNPOld
//        LocalName
//        GovernmentForm
//        HeadOfState
//        Capital
//        Code2
//
//        Primary Keys:
//        Code
//        =================
//        Table : countrylanguage
//        Columns:
//        CountryCode
//        Language
//        IsOfficial
//        Percentage
//
//        Primary Keys:
//        CountryCode
//        Language
//        =================