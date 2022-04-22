/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dung.mobileshop.dao;

import com.dung.mobileshop.helper.DBConnection;
import com.dung.mobileshop.models.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    private static PreparedStatement pstmt = null;
    private static Connection conn = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    
    public static ArrayList<Product> getProducts() {
        ArrayList<Product> productsList = new ArrayList<Product>();        
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
    
    public static Product getProductByID(int id) { 
        
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());            
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM [PRJ301].[dbo].[Product] WHERE id='"+id+"'");
            resultSet.next();
            if(resultSet.getString("name")!=null){
                Product newProduct = new Product();
                newProduct.setDescription(resultSet.getString("description"));
                newProduct.setName(resultSet.getString("name"));
                newProduct.setBrand(resultSet.getString("brand"));
                newProduct.setModel(resultSet.getString("model"));
                newProduct.setSize(resultSet.getString("size"));
                newProduct.setId(Integer.parseInt(resultSet.getString("id")));
                newProduct.setPrice(Integer.parseInt(resultSet.getString("price")));
                newProduct.setQuantity(Integer.parseInt(resultSet.getString("quantity")));
                return newProduct;
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
    
    public static boolean updateProductByID(Product prd) {  
        boolean result = false;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());            
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            pstmt = conn.prepareStatement(
                    "UPDATE [PRJ301].[dbo].[Product] SET [name] = ?,"
                            + "[price] = ?,"
                            + "[size] = ?,"
                            + "[quantity] = ?,"
                            + "[description] = ?,"
                            + "[model] = ?,"
                            + "[brand] = ? WHERE id =?");
            pstmt.setString(1, prd.getName());
            pstmt.setInt(2, prd.getPrice());
            pstmt.setString(3, prd.getSize());
            pstmt.setInt(4, prd.getQuantity());
            pstmt.setString(5, prd.getDescription());
            pstmt.setString(6, prd.getModel());
            pstmt.setString(7, prd.getBrand());
            pstmt.setInt(8, prd.getId());
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
}
