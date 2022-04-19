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
    public static ArrayList<Product> getProducts() {
        ArrayList<Product> productsList = new ArrayList<Product>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            String dbURL = "jdbc:sqlserver://localhost\\INSTANCE2007";
            String user = "sa";
            String pass = "123456";
            conn = DriverManager.getConnection(dbURL, user, pass);
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM PRJ301.dbo.product");
            while(resultSet.next()){
                Product newProduct = new Product();
                newProduct.setDescription(resultSet.getString("description"));
                newProduct.setName(resultSet.getString("name"));
                newProduct.setBrand(resultSet.getString("brand"));
                newProduct.setModel(resultSet.getString("model"));
                newProduct.setSize(resultSet.getString("size"));
                newProduct.setPrice(Integer.parseInt(resultSet.getString("price")));
                newProduct.setQuantity(Integer.parseInt(resultSet.getString("quantity")));
                productsList.add(newProduct);
                System.out.println(newProduct.getName());
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
