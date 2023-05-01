<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Author</title>
  <%@ include file="../../header.jsp" %>
<body>
<div class="m-bottom-60">
<h1>Add Author</h1>
</div>
<form action="/createAuthor" method="post" class="form">
  <div class="form-group">
    <input type="text" placeholder="name" name="name" class="form-control">
  </div>
  <div class="form-group">
    <input type="text" placeholder="surname" name="surname" class="form-control">
  </div>
  <div class="form-group">
    <input type="text" placeholder="email" name="email" class="form-control">
  </div>
  <div class="form-group">
    <input type="text" placeholder="age" name="age" class="form-control">
  </div>
  <button type="submit" class="btn btn-primary button">Add</button>
</form>
</body>
</html>
