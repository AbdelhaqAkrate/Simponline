package com.ken.simplon.Service;
import java.io.IOException;
import java.util.List;

import com.ken.simplon.Dao.HibrnateAdminDao;

import entity.AdminEntity;
import entity.PromotionEntity;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class AdminServices {
    private HibrnateAdminDao adminDao = new HibrnateAdminDao();

    //Create a method for admin login
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(adminDao.login(email, password)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard page");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("keep him in login page");
            dispatcher.forward(request, response);
        }
    }

    //Create a method for creating a formateur account
    public void createFormateurAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        adminDao.createFormateurAccount(fullName, email, password);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard page");
        dispatcher.forward(request, response);
    }

    //Create a method for creating an apprenant account
    public void createApprenantAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        adminDao.createApprenantAccount(fullName, email, password);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard page");
        dispatcher.forward(request, response);
    }

    //Create a method for creating a promo
    public void createPromo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        adminDao.createPromo(name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard page");
        dispatcher.forward(request, response);
    }

    //Create a method for assigning a formateur to a promo
    public void assignFormateurToPromo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idFormateur = Long.parseLong(request.getParameter("idFormateur"));
        Long idPromo = Long.parseLong(request.getParameter("idPromo"));
        adminDao.assignFormateurToPromo(idFormateur, idPromo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard page");
        dispatcher.forward(request, response);
    }

    //Create a method for getting all promos
    public void getAllPromos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PromotionEntity> promos = adminDao.getAllPromos();
        request.setAttribute("promos", promos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard page");
        dispatcher.forward(request, response);
    }
}
