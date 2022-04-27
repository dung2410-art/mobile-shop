/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.dung.mobileshop.controllers;

import com.dung.mobileshop.dao.UserDAO;
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
@WebServlet(name="AuthenController",
            urlPatterns = {"/login",
                           "/logout",
                           "/register"})
public class AuthenController extends HttpServlet {

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
        String userPath = request.getServletPath();
        if (userPath.equals("/login")) {
            // TODO: Implement 
        }else  if (userPath.equals("/logout")) {            
            HttpSession session=request.getSession();              
            session.removeAttribute("username");
            session.removeAttribute("userrole");
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
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
        User user = UserDAO.authenticate(request.getParameter("email"),
                request.getParameter("password"));
        // if addToCart action is called
        if (user != null) {            
            HttpSession session=request.getSession();  
            session.setAttribute("username", user.getName());
            session.setAttribute("userrole", user.getRole());
            response.sendRedirect("/mobileshop");
        } else {            
            request.setAttribute("errorMessage", "Either email or password was incorrect!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request,response);
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
