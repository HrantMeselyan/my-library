package com.example.authorBookServlet.servlet.book;

import com.example.authorBookServlet.manager.AuthorManager;
import com.example.authorBookServlet.manager.BookManager;
import com.example.authorBookServlet.manager.UserManager;
import com.example.authorBookServlet.model.Author;
import com.example.authorBookServlet.model.Book;
import com.example.authorBookServlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();
    private AuthorManager authorManager = new AuthorManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookManager.getById(id);
        List<Author> all = authorManager.getAll();
        req.setAttribute("authors", all);
        req.setAttribute("book", book);
        req.getRequestDispatcher("WEB-INF/book/updateBook.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String picName = req.getParameter("picName");
        int price = Integer.parseInt(req.getParameter("price"));
        Author author = authorManager.getById(authorId);
        User user = (User) req.getSession().getAttribute("user");
        Book book = new Book(bookId, title, description, price, picName, author, user);
        bookManager.update(book);
        resp.sendRedirect("/books");
    }
}

