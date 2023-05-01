package com.example.authorBookServlet.servlet;

import com.example.authorBookServlet.manager.BookManager;
import com.example.authorBookServlet.model.Book;
import com.example.authorBookServlet.model.Type;
import com.example.authorBookServlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            int id = user.getId();
            List<Book> all;
            if (user.getType() == Type.ADMIN) {
                all = bookManager.searchByNameForAdmin(name);
            } else {
                all = bookManager.searchByName(name, id);
            }
            req.setAttribute("books", all);
            req.getRequestDispatcher("WEB-INF/searchResult.jsp").forward(req, resp);
        }
    }
}
