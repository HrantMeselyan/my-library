package com.example.authorBookServlet.servlet.book;

import com.example.authorBookServlet.constant.SharedConstants;
import com.example.authorBookServlet.manager.AuthorManager;
import com.example.authorBookServlet.manager.BookManager;
import com.example.authorBookServlet.manager.UserManager;
import com.example.authorBookServlet.model.Author;
import com.example.authorBookServlet.model.Book;
import com.example.authorBookServlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/createBook")
@MultipartConfig(
        maxFileSize = 1024 * 1024 * 5, //5mb
        maxRequestSize = 1024 * 1024 * 10,
        fileSizeThreshold = 1024 * 1024
)
public class CreateBookServlet extends HttpServlet {
    private AuthorManager authorManager = new AuthorManager();
    private BookManager bookManager = new BookManager();
    private UserManager userManager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> all = authorManager.getAll();
        req.setAttribute("authors", all);
        req.getRequestDispatcher("WEB-INF/book/createBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Book book = new Book();
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int price = Integer.parseInt(req.getParameter("price"));
        int id = Integer.parseInt(req.getParameter("id"));
        Part profilePicPart = req.getPart("profilePic");
        String picName = null;
        if (profilePicPart != null && profilePicPart.getSize() > 0) {
            picName = System.nanoTime() + "_" + profilePicPart.getSubmittedFileName();
            profilePicPart.write(SharedConstants.UPLOAD_FOLDER + picName);
        }
        Author author = authorManager.getById(id);
        book.setTitle(title);
        book.setPicName(picName);
        book.setDescription(description);
        book.setPrice(price);
        book.setAuthor(author);
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        book.setUser(userManager.getById(user.getId()));
        bookManager.save(book);
        resp.sendRedirect("/books");
    }
}
