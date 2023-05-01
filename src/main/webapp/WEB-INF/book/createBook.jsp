<%@ page import="java.util.List" %>
<%@ page import="com.example.authorBookServlet.model.Author" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Book</title>
    <% List<Author> authors = (List<Author>) request.getAttribute("authors"); %>
    <%@ include file="../../header.jsp" %>
</head>
<body>
<h1>Add Book</h1>
<form action="/createBook" method="post" enctype="multipart/form-data" class="form-2 justify-content-center">
    <div class="form-row d-flex">
        <div class="form-group col-md-6">
            <label>Title</label>
            <input type="text" class="form-control" name="title" placeholder="title">
        </div>
        <div class="form-group col-md-6">
            <label>description</label>
            <input type="text" class="form-control" name="description" placeholder="description">
        </div>
    </div>
    <div class="form-row d-flex">
        <div class="form-group col-md-6">
            <label>Price</label>
            <input type="text" placeholder="price" name="price" class="form-control">
        </div>
        <div class="form-group col-md-6">
            <label>Authors</label>
            <select class="form-control" name="id">
                <option selected>Choose...</option>
                <%for (Author author : authors) {%>
                <option value="<%=author.getId()%>"><%=author.getName()%>
                </option>
                <%}%>
            </select>
        </div>
    </div>
    <div class="mb-3 input-img col-md-6">
        <input class="form-control" type="file" name="profilePic">
    </div>
    <div class="justify-content-center d-flex">
        <button type="submit" class="btn btn-primary d-flex justify-content-center">Add</button>
    </div>
</form>
</body>
</html>
