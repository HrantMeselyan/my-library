package com.example.authorBookServlet.servlet.book;

import com.example.authorBookServlet.Constants.SharedConstants;
import com.example.authorBookServlet.manager.BookManager;
import com.example.authorBookServlet.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/removeBook")
public class RemoveBookServlet extends HttpServlet {
    private BookManager bookManager = new BookManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookManager.getById(id);
        if (book != null) {
            if (book.getPicName() != null || !book.getPicName().equalsIgnoreCase("null")) {
                File file = new File(SharedConstants.UPLOAD_FOLDER + book.getPicName());
                if (file.exists()) {
                    file.delete();
                }
            }
            bookManager.removeById(id);
        }
        resp.sendRedirect("/books");
    }
}
