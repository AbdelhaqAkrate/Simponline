package com.ken.simplon;

import java.io.*;
import java.time.format.*;
import java.time.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
          String date = LocalDateTime.now().format(formatter);
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println(date);
        out.println("</body></html>");
    }

    public void destroy() {
    }
}