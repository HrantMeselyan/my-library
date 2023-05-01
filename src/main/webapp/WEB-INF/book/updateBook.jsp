<%@ page import="java.util.List" %>
<%@ page import="com.example.authorBookServlet.model.Book" %>
<%@ page import="com.example.authorBookServlet.model.Author" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Book</title>
        <% Book book = (Book) request.getAttribute("book");%>
        <%List<Author> authors = (List<Author>) request.getAttribute("authors");%>
    <%@ include file="../../header.jsp" %>
<body>
<h1>Update Book</h1>
<form action="/updateBook" method="post" class="form-2 justify-content-center">
    <input type="hidden" name="bookId" value="<%=book.getId()%>">
    <div class="form-row d-flex">
        <div class="form-group col-md-6">
            <label>Title</label>
            <input type="text" class="form-control" name="title" value="<%=book.getTitle()%>">
        </div>
        <div class="form-group col-md-6">
            <label>Description</label>
            <input type="text" class="form-control" name="description" value="<%=book.getDescription()%>">
        </div>
    </div>
    <div class="form-row d-flex">
        <div class="form-group col-md-6">
            <label>Price</label>
            <input type="text" value="<%=book.getPrice()%>" name="price" class="form-control">
        </div>
        <div class="form-group col-md-6">
            <label>Authors</label>
            <select class="form-control" name="authorId">
                <option selected>Choose...</option>
                <%for (Author author : authors) {%>
                <option value="<%=author.getId()%>"><%=author.getName()%>
                </option>
                <%}%>
            </select>
        </div>
    </div>
    <div class="justify-content-center d-flex">
        <button type="submit" class="btn btn-primary d-flex justify-content-center">Add</button>
    </div>
</form>
</body>
</html>
