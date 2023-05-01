package com.example.authorBookServlet.manager;

import com.example.authorBookServlet.db.DbConnectionProvider;
import com.example.authorBookServlet.model.Book;
import com.example.authorBookServlet.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private final Connection connection = DbConnectionProvider.getInstance().getConnection();
    private final AuthorManager authorManager = new AuthorManager();


    public List<Book> getAll(User user) {
        List<Book> bookList = new ArrayList<>();
        int id = user.getId();
        String sql = "SELECT * FROM book WHERE user_id = ? OR ? = 'ADMIN'";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1,id);
            ps.setString(2, user.getType().toString());
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                bookList.add(getBookFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }


    public void save(Book book) {
        String sql = "INSERT INTO book(title,description,price,author_id,img,user_id)Values(?,?,?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getDescription());
            ps.setInt(3, book.getPrice());
            ps.setInt(4, book.getAuthor().getId());
            ps.setString(5, book.getPicName());
            ps.setInt(6, book.getUser_id());
            ps.executeUpdate();
            System.out.println("Book Inserted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book getById(int id) {
        String sql = "SELECT * from book where id  = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return getBookFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void removeById(int bookId) {
        String sql = "DELETE FROM book WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, bookId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Book book) {
        String sql = "UPDATE book SET title = ?, description = ?,price = ?,author_id = ? where id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getDescription());
            ps.setInt(3, book.getPrice());
            ps.setInt(4, book.getAuthor().getId());
            ps.setInt(5, book.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> searchByName(String name) {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * from book where title LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                bookList.add(getBookFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    private Book getBookFromResultSet(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setTitle(resultSet.getString("title"));
        book.setDescription(resultSet.getString("description"));
        book.setPrice(resultSet.getInt("price"));
        book.setAuthor(authorManager.getById(resultSet.getInt("author_id")));
        book.setPicName(resultSet.getString("img"));
        return book;
    }
}
