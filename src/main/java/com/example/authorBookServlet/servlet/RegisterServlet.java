package com.example.authorBookServlet.servlet;

import com.example.authorBookServlet.manager.UserManager;
import com.example.authorBookServlet.model.User;
import com.example.authorBookServlet.util.EmailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserManager userManager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String msg = "";
        if (name == null || name.trim().equals("")) {
            msg += "name is required ";
        }
        if (surname == null || surname.trim().equals("")) {
            msg += "surname is required ";
        }
        if (email == null || email.trim().equals("")) {
            msg += "email is required ";
        } else if (!EmailUtil.patternMatches(email)) {
            msg += "email format is required ";
        }
        if (password == null || password.trim().equals("")) {
            msg += "password is required ";
        } else if (password.length() < 6) {
            msg += "password length must be more than 6";
        }
        if (msg.equals("")) {
            User user = userManager.getByEmail(email);
            if (user == null) {
                userManager.save(User.builder()
                        .name(name)
                        .surname(surname)
                        .email(email)
                        .password(password)
                        .build());
            }
            resp.sendRedirect("/");
        } else {
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}
