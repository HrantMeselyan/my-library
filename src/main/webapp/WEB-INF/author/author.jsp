<%@ page import="java.util.List" %>

<%@ page import="com.example.authorBookServlet.model.Author" %>
<%@ page import="com.example.authorBookServlet.model.User" %>
<%@ page import="com.example.authorBookServlet.model.Type" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author</title>
        <% List<Author> authors = (List<Author>) request.getAttribute("authors");%>
        <%User user = (User) request.getAttribute("user");%>
    <%@ include file="../../header.jsp" %>
<body>
<h1 class="main-title">Authors</h1>
<div class="table">
    <table id="customers">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>surname</th>
            <th>email</th>
            <th>age</th>
            <%if (user.getType() == Type.ADMIN) {%>
            <th>action</th>
            <%}%>
        </tr>
        <% if (authors != null && !authors.isEmpty()) { %>
        <%for (Author author : authors) { %>
        <tr>
            <td><%=author.getId()%>
            </td>
            <td><%=author.getName()%>
            </td>
            <td><%=author.getSurname()%>
            </td>
            <td><%=author.getEmail()%>
            </td>
            <td><%=author.getAge()%>
            </td>
            <%if (user.getType() == Type.ADMIN) {%>
            <td class="action"><a href="/removeAuthor?id=<%=author.getId()%>"><img src="../../img/trash.svg"></a> |
                <a href="/updateAuthor?id=<%=author.getId()%>"><img src="../../img/update.svg"></a></td>
            <%}%>
        </tr>
        <%
                }
            }
        %>
    </table>
    <a href="/createAuthor" class="d-flex flex-row-reverse">
        <button type="button" class="btn btn-primary">Add</button>
    </a>
</div>

</body>
</html>
