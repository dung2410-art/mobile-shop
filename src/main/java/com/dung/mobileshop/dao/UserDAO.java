/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dung.mobileshop.dao;

import com.dung.mobileshop.models.Product;
import com.dung.mobileshop.models.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Dung
 */
public class UserDAO {
    private static String dbURL = "jdbc:sqlserver://localhost\\INSTANCE2007";
    private static String dbUser = "sa";
    private static String dbPassword = "123456";
    
    public static User authenticate(String email, String password) {  
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());            
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM [PRJ301].[dbo].[User] WHERE "
                    + "email='"+email+"' AND "
                    + "password='"+password+"' "        
                    + "");
            resultSet.next();
            if(resultSet.getString("name")!=null){
                User newUser = new User(resultSet.getString("name"), resultSet.getInt("roleId"));  
                return newUser;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
