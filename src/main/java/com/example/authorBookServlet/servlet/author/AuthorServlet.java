package com.example.authorBookServlet.servlet.author;

import com.example.authorBookServlet.manager.AuthorManager;
import com.example.authorBookServlet.model.Author;
import com.example.authorBookServlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/authors")
public class AuthorServlet extends HttpServlet {
    private AuthorManager authorManager = new AuthorManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> all = authorManager.getAll();
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("authors",all);
        req.setAttribute("user",user);

        req.getRequestDispatcher("WEB-INF/author/author.jsp").forward(req,resp);
    }
}
