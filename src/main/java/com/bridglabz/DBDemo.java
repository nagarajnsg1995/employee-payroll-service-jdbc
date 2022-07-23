package com.bridglabz;

import java.sql.*;

public class DBDemo {
    public static void main(String[] args) throws SQLException {
        System.out.println("welcome to employee-payroll mysql");

        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";

        String userName = "root";

        String password = "Nsg@1995";

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, userName, password);

            PreparedStatement statement = connection.prepareStatement("UPDATE employee SET salary=5000000.00 WHERE name='Terisa'");
            statement.executeUpdate();


             ResultSet resultSet = statement.executeQuery("SELECT *FROM employee ");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

            connection.close();
        }
    }

    private static class preparedStatement {
    }
}



