package com.ken.simplon.Servlet;
import com.ken.simplon.Service.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;


public class AdminServlet extends HttpServlet {


    private AdminServices adminService = new AdminServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
    

