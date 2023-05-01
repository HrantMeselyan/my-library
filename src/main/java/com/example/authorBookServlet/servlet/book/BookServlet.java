package com.example.authorBookServlet.servlet.book;

import com.example.authorBookServlet.manager.BookManager;
import com.example.authorBookServlet.model.Book;
import com.example.authorBookServlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Book> all = bookManager.getAll(user);
        req.setAttribute("books", all);
        req.getRequestDispatcher("WEB-INF/book/book.jsp").forward(req, resp);
    }
}
