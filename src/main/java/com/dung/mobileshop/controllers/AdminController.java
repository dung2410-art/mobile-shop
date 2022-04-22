/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.dung.mobileshop.controllers;

import com.dung.mobileshop.dao.ProductDAO;
import com.dung.mobileshop.dao.UserDAO;
import com.dung.mobileshop.models.Product;
import com.dung.mobileshop.models.User;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Dung
 */
@WebServlet(name="AdminController",
            urlPatterns = {"/admin",
                           "/admin/products",
                           "/admin/products/edit",
                           "/admin/transactions",                           
                           "/admin/user"})
public class AdminController extends HttpServlet {    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session=request.getSession();    
        if(session.getAttribute("userrole")==null || !session.getAttribute("userrole").toString().equals("1")){
            response.sendRedirect("/mobileshop/login");
            return;
        }        
        RequestDispatcher requestDispatcher = null;
        String userPath = request.getServletPath();
        if(userPath.equals("/admin/products")) {
            request.setAttribute("productList", ProductDAO.getProducts());
            requestDispatcher = getServletContext().getRequestDispatcher("/products-admin.jsp");
        }
        else if (userPath.equals("/admin/products/edit")) {
            String idString = request.getParameter("id");
            try{
                int id = Integer.parseInt(idString);
                Product prd = ProductDAO.getProductByID(id);
                request.setAttribute("productInfo",prd);
            }catch(Exception e){
                e.printStackTrace();
            }            
            requestDispatcher = getServletContext().getRequestDispatcher("/product-edit.jsp");
        }        
        else  if (userPath.equals("/admin")) {            
            requestDispatcher = getServletContext().getRequestDispatcher("/index-admin.jsp");
        }
        requestDispatcher.forward(request,response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = null;
        String userPath = request.getServletPath();
        if (userPath.equals("/admin/products/edit")) {
            String idString = request.getParameter("id");
            if(idString != null){
                String quantityString = request.getParameter("quantity");
                String priceString = request.getParameter("price");
                String name = request.getParameter("name");
                String size = request.getParameter("size");
                String model = request.getParameter("model");
                String brand = request.getParameter("brand");
                String description = request.getParameter("description");
                try{
                    int id = Integer.parseInt(idString);
                    int price = Integer.parseInt(priceString);
                    int quantity = Integer.parseInt(quantityString);                   
                    Product prd= new Product(id, name, model, price, brand, description, quantity, size);                   
                    //boolean result = ProductDAO.updateProductByID(prd);
                    if(!ProductDAO.updateProductByID(prd)){
                       
                    }
                    request.setAttribute("productInfo",prd);
                }catch(Exception e){
                    e.printStackTrace();
                    request.setAttribute("errorMessage", "There was a problem with input!");
                    requestDispatcher = getServletContext().getRequestDispatcher("/product-edit.jsp");
                    requestDispatcher.forward(request,response);
                    return;
                }            
                response.sendRedirect("/mobileshop/admin/products");
            }else{
                response.sendRedirect("/mobileshop/admin/products");
            }            
        }       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
