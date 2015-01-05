package com.airwatch.jdbc_assignment;

import java.sql.*;

/**
 * Created by ABhat on 18 Aug 2014 - 18/08/14.
 */
public class SakilaProcedures {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/sakila";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        SakilaProcedures sakilaProcedures = new SakilaProcedures();
        int count = sakilaProcedures.executeProcedure("film_in_stock", url);
        if (count == -1)
            System.out.println("Film not in stock");
        else
            System.out.println(count + " copies of the film are available");

    }

    public int executeProcedure(String procedure, String url) {
        int count = -1;
        try {
            Connection connection = DriverManager.getConnection(url, "airwatch", "airwatch");
            PreparedStatement statement = connection.prepareStatement("SELECT film_id FROM FILM WHERE title=?");

            statement.setString(1, "ACADEMY DINOSAUR");
            ResultSet result = statement.executeQuery();

            int filmid = 0;
            while (result.next())
                filmid = result.getInt("film_id");

            String sqlStatement = "CALL " + procedure + "(?,?,?)";
            CallableStatement callableStatement = connection.prepareCall(sqlStatement);
            callableStatement.setInt(1, filmid);
            callableStatement.setInt(2, 1);
            callableStatement.registerOutParameter(3, Types.INTEGER);

            callableStatement.executeUpdate();
            count = callableStatement.getInt(3);

            callableStatement.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;

    }
}
