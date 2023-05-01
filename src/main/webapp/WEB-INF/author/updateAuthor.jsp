<%@ page import="com.example.authorBookServlet.model.Author" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update Author</title>
  <%@ include file="../../header.jsp" %>
<body>
<%Author author = (Author) request.getAttribute("author");%>
<div class="m-bottom-60">
  <h1>Update Author</h1>
</div>
<form action="/updateAuthor" method="post" class="form">
  <input type="hidden" name="id" value="<%=author.getId()%>">
  <div class="form-group">
    <input type="text" value="<%=author.getName()%>" name="name" class="form-control">
  </div>
  <div class="form-group">
    <input type="text" value="<%=author.getSurname()%>" name="surname" class="form-control">
  </div>
  <div class="form-group">
    <input type="text" value="<%=author.getEmail()%>" name="email" class="form-control">
  </div>
  <div class="form-group">
    <input type="text" value="<%=author.getAge()%>" name="age" class="form-control">
  </div>
  <button type="submit" class="btn btn-primary button">Update</button>
</form>
</body>
</html>
