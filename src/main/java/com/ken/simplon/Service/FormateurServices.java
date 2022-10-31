package com.ken.simplon.Service;
import java.io.IOException;
import java.util.List;

import com.ken.simplon.Dao.HibrnateFormateurDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class FormateurServices {
    HibrnateFormateurDao formateurDao = new HibrnateFormateurDao();

    //Create a method for formateur login
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(formateurDao.login(email, password)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard page");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("keep him in login page");
            dispatcher.forward(request, response);
        }
    }

    //Create a method for create a brief
    public void createBrief(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String context = request.getParameter("context");
        int deadline = Integer.parseInt(request.getParameter("deadline"));
        formateurDao.createBrief(title, context, deadline);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard page");
        dispatcher.forward(request, response);
    }

    //Create a method for assigning a brief to an promo
    public void assignBriefToApprenant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idBrief = Long.parseLong(request.getParameter("idBrief"));
        Long idPromo = Long.parseLong(request.getParameter("idPromo"));
        formateurDao.assignBriefToPromo(idBrief, idPromo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard page");
        dispatcher.forward(request, response);
    }
    
    //Create a method for assigning a apprenant to a promo
    public void assignPromoToApprenant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idApprenant = Long.parseLong(request.getParameter("idApprenant"));
        Long idPromo = Long.parseLong(request.getParameter("idPromo"));
        formateurDao.assignPromoToApprenant(idApprenant, idPromo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard page");
        dispatcher.forward(request, response);
    }

    //create a methode to validate apprenant brief
    public void validateBrief(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idLivrable = Long.parseLong(request.getParameter("idLivrable"));
        formateurDao.validateBriefOfApprenant(idLivrable);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard page");
        dispatcher.forward(request, response);
    }
}
