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
            Statement statement = connection.createStatement();

//           PreparedStatement statement = connection.prepareStatement("UPDATE employee SET salary=5000000.00 WHERE name='Terisa'");

//            ResultSet resultSet = statement.executeQuery("SELECT SUM(salary) FROM employee WHERE gender = 'M' GROUP BY gender ");


            ResultSet resultSet = statement.executeQuery(" SELECT avg(salary)  FROM `employee` ");

            while (resultSet.next()) {
//              System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getString(5));
                System.out.println("Sum of the all  salary " + resultSet.getDouble("avg(salary)"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

            connection.close();
        }
    }


}



