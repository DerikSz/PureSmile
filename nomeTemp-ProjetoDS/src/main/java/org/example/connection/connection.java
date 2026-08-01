package org.example.connection;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class connection {
    Dotenv dotenv = Dotenv.load();

    final String driver = "com.mysql.jdbc.Driver";
    final String url = "jdbc:mysql://127..0.0.1/clients";
    final String user = dotenv.get("DB_MYSQLROOTUSERNAME");
    final String password = dotenv.get("DB_MYSQLROOTPASSWORD");
    private Connection connectionDB;
    public Statement statement;
    public ResultSet resultSet;

    public boolean connection () {
        boolean isConnected = true;
        try {
            Class.forName(driver);
            connectionDB = DriverManager.getConnection("url", user, password);
            System.out.println("DB connection started");

        }catch(ClassNotFoundException e){
            System.out.println("Invalid Drive");
            e.printStackTrace();
        }
        catch (SQLException e) {
            System.out.println("Invalid URL");
            e.printStackTrace();
            isConnected = false;
        }
        return isConnected;
    }

    public void desconnection(){
        try{
         connectionDB.close();
            System.out.println("DB Connection Closed.");
        }catch(SQLException e){
            System.out.println("DB Connection not found");
            e.printStackTrace();
        }
    }
    public void SQLexe(String sqlCommand){
        try{
          statement = connectionDB.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
          resultSet = statement.executeQuery(sqlCommand);
        }catch(SQLException e){
            System.out.println("SQL command invalid!");
            e.printStackTrace();
        }
    }

    public String getPassword() {
        return password;
    }
}