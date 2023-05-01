package com.example.authorBookServlet.servlet;

import com.example.authorBookServlet.manager.BookManager;
import com.example.authorBookServlet.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/searchResult.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        if (name == null || name.equals("")) {
           resp.sendRedirect("/books");
        } else {
            List<Book> all = bookManager.searchByName(name);
            req.setAttribute("books", all);
            req.getRequestDispatcher("WEB-INF/searchResult.jsp").forward(req, resp);
        }
    }
}
