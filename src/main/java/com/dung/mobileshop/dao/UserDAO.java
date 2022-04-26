/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dung.mobileshop.dao;

import com.dung.mobileshop.models.Product;
import com.dung.mobileshop.models.User;
import java.sql.Connection;
import java.sql.DriverManager;
<<<<<<< HEAD
=======
import java.sql.PreparedStatement;
>>>>>>> 1747be2 (add user)
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Dung
 */
public class UserDAO {
<<<<<<< HEAD
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
=======

    private static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=PRJ301";
    private static String dbUser = "sa";
    private static String dbPassword = "123";
    private static PreparedStatement pstmt = null;
    private static Connection conn = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    public static User authenticate(String email, String password) {

        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM [PRJ301].[dbo].[User] WHERE "
                    + "email='" + email + "' AND "
                    + "password='" + password + "' "
                    + "");
            resultSet.next();
            if (resultSet.getString("name") != null) {
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

    public static ArrayList<User> getUsers() {

        ArrayList<User> userlist = new ArrayList<User>();
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM [PRJ301].[dbo].[User]");
            while (resultSet.next()) {
                User newUser = new User();
                newUser.setId(Integer.parseInt(resultSet.getString("id")));
                newUser.setName(resultSet.getString("name"));
                newUser.setRole(Integer.parseInt(resultSet.getString("role")));
                newUser.setEmail(resultSet.getString("email"));
                newUser.setPhone(resultSet.getString("phone"));
                newUser.setAddress(resultSet.getString("address"));
                newUser.setPassword(resultSet.getString("password"));
                userlist.add(newUser);
                //System.out.println(newProduct.getName());
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

        return userlist;
    }

    public static ArrayList<User> getUserById(String id) {
         ArrayList<User> userlist = new ArrayList<User>();
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM [PRJ301].[dbo].[User] WHERE id=" + id + "");
            while (resultSet.next()) {
                User newUser = new User();
                newUser.setId(Integer.parseInt(resultSet.getString("id")));
                newUser.setName(resultSet.getString("name"));
                newUser.setRole(Integer.parseInt(resultSet.getString("role")));
                newUser.setEmail(resultSet.getString("email"));
                newUser.setPhone(resultSet.getString("phone"));
                newUser.setAddress(resultSet.getString("address"));
                newUser.setPassword(resultSet.getString("password"));
                userlist.add(newUser);
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
        return userlist;
    }
    
    public static User getUserById(int id) { 
        
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());            
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM [PRJ301].[dbo].[User] WHERE id='"+id+"'");
            resultSet.next();
            if(resultSet.getString("name")!=null){
                User newUser = new User();
                newUser.setId(Integer.parseInt(resultSet.getString("id")));
                newUser.setName(resultSet.getString("name"));
                newUser.setRole(Integer.parseInt(resultSet.getString("role")));
                newUser.setEmail(resultSet.getString("email"));
                newUser.setPhone(resultSet.getString("phone"));
                newUser.setAddress(resultSet.getString("address"));
                newUser.setPassword(resultSet.getString("password"));
>>>>>>> 1747be2 (add user)
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
<<<<<<< HEAD
=======
    
    public static boolean updateUserByID(User user) {  
        boolean result = false;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());            
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            pstmt = conn.prepareStatement(
                    "UPDATE [PRJ301].[dbo].[User] SET [name] = ?,"
                            + "[roleId] = ?,"
                            + "[phone] = ?,"
                            + "[email] = ?,"
                            + "[address] = ?,"
                            + "[password] = ? WHERE id =?");
            pstmt.setString(1, user.getName());
            pstmt.setInt(2, user.getRole());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getAddress());
            pstmt.setString(6, user.getPassword());
            pstmt.setInt(7, user.getId());
            result = pstmt.executeUpdate() > 0;
            return result;
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
        return false;
    }
>>>>>>> 1747be2 (add user)
}
