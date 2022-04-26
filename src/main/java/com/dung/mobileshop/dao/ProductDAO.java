/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dung.mobileshop.dao;

import com.dung.mobileshop.helper.DBConnection;
import com.dung.mobileshop.models.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ProductDAO {
    private static String dbURL = "jdbc:sqlserver://localhost\\INSTANCE2007";
    private static String dbUser = "sa";
    private static String dbPassword = "123456";
    
    public static ArrayList<Product> getProducts() {
        ArrayList<Product> productsList = new ArrayList<Product>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());            
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM [PRJ301].[dbo].[Product]");
            while(resultSet.next()){
                Product newProduct = new Product();
                newProduct.setDescription(resultSet.getString("description"));
                newProduct.setName(resultSet.getString("name"));
                newProduct.setBrand(resultSet.getString("brand"));
                newProduct.setModel(resultSet.getString("model"));
                newProduct.setSize(resultSet.getString("size"));
                newProduct.setId(Integer.parseInt(resultSet.getString("id")));
                newProduct.setPrice(Integer.parseInt(resultSet.getString("price")));
                newProduct.setQuantity(Integer.parseInt(resultSet.getString("quantity")));
                productsList.add(newProduct);
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

        return productsList;
    }
    
    public static ArrayList<Product> getProductById(String id) {   
        ArrayList<Product> productsList = new ArrayList<Product>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());            
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            statement = conn.createStatement();
            //resultSet = statement.executeQuery("SELECT *  [PRJ301_moblieshop].[dbo].[Product] WHERE id="+id+"");
            resultSet = statement.executeQuery("SELECT * FROM [PRJ301].[dbo].[Product] WHERE id="+id+"");
            while(resultSet.next()){
                Product newProduct = new Product();
                newProduct.setDescription(resultSet.getString("description"));
                newProduct.setName(resultSet.getString("name"));
                newProduct.setBrand(resultSet.getString("brand"));
                newProduct.setModel(resultSet.getString("model"));
                newProduct.setSize(resultSet.getString("size"));
                newProduct.setId(Integer.parseInt(resultSet.getString("id")));
                newProduct.setPrice(Integer.parseInt(resultSet.getString("price")));
                newProduct.setQuantity(Integer.parseInt(resultSet.getString("quantity")));
                productsList.add(newProduct);
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
        return productsList;
    }
    
    public static ArrayList<Product> getProductByBrand(String brand) {  
        ArrayList<Product> productsList = new ArrayList<Product>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());            
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM [PRJ301].[dbo].[Product] WHERE lower(brand)='"+brand.toLowerCase()+"'");
            while(resultSet.next()){
                Product newProduct = new Product();
                newProduct.setDescription(resultSet.getString("description"));
                newProduct.setName(resultSet.getString("name"));
                newProduct.setBrand(resultSet.getString("brand"));
                newProduct.setModel(resultSet.getString("model"));
                newProduct.setSize(resultSet.getString("size"));
                newProduct.setId(Integer.parseInt(resultSet.getString("id")));
                newProduct.setPrice(Integer.parseInt(resultSet.getString("price")));
                newProduct.setQuantity(Integer.parseInt(resultSet.getString("quantity")));
                productsList.add(newProduct);
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
        return productsList;
    }
    
    public static ArrayList<Product> getProductByWildCard(String term) {   
        ArrayList<Product> productsList = new ArrayList<Product>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());            
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM [PRJ301].[dbo].[Product] "
                    + "WHERE lower(brand) LIKE '%"+term.toLowerCase()+"%' "
                    + "OR lower(description) LIKE '%"+term.toLowerCase()+"%' "
                    + "OR lower(model) LIKE '%"+term.toLowerCase()+"%' "
                    + "OR lower(price) LIKE '%"+term.toLowerCase()+"%' "
                    + "OR lower(name) LIKE '%"+term.toLowerCase()+"%' "
                    + "");
            while(resultSet.next()){
                Product newProduct = new Product();
                newProduct.setDescription(resultSet.getString("description"));
                newProduct.setName(resultSet.getString("name"));
                newProduct.setBrand(resultSet.getString("brand"));
                newProduct.setModel(resultSet.getString("model"));
                newProduct.setSize(resultSet.getString("size"));
                newProduct.setId(Integer.parseInt(resultSet.getString("id")));
                newProduct.setPrice(Integer.parseInt(resultSet.getString("price")));
                newProduct.setQuantity(Integer.parseInt(resultSet.getString("quantity")));
                productsList.add(newProduct);
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
        return productsList;
    }
}
