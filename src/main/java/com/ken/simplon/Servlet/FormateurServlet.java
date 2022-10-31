package com.ken.simplon.Servlet;
import com.ken.simplon.Service.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
@WebServlet("/formateur")
public class FormateurServlet extends HttpServlet {

    private FormateurServices formateurService = new FormateurServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
    

