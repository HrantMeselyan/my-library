package com.example.authorBookServlet.servlet;

import com.example.authorBookServlet.manager.UserManager;
import com.example.authorBookServlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserManager userManager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = userManager.getByEmailAndPassword(email, password);
        HttpSession session = req.getSession();
        if (user != null) {
            session.setAttribute("user", user);
            resp.sendRedirect("/home");
        } else {
            session.setAttribute("msg","Username or Password incorrect");
            resp.sendRedirect("/");
        }
    }
}
