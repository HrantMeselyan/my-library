<%@ page import="java.util.List" %>
<%@ page import="com.example.authorBookServlet.model.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
        <%List<Book> books = (List<Book>) request.getAttribute("books");%>
    <%@ include file="../header.jsp" %>
<body>
<h1 class="main-title">Result:</h1>
<div class="table">
    <table id="customers">
        <tr>
            <th>id</th>
            <th>title</th>
            <th>description</th>
            <th>price</th>
            <th>author</th>
            <th>action</th>
        </tr>
        <% if (books != null) { %>
        <%for (Book book : books) {%>
        <tr>
            <td><%=book.getId()%>
            </td>
            <td><%=book.getTitle()%>
            </td>
            <td><%=book.getDescription()%>
            </td>
            <td><%=book.getPrice()%>
            </td>
            <td><%=book.getAuthor().getName()%>
            </td>
            <td class="action"><a href="/removeBook?id=<%=book.getId()%>"><img src="../../img/trash.svg" alt=""></a> |
                <a href="/updateBook?id=<%=book.getId()%>"><img src="../../img/update.svg"></a></td>
        </tr>
        <%}%>
        <%}%>
    </table>
    <a href="/createBook" class=" d-flex flex-row-reverse">
        <button type="button" class="btn btn-primary">Add</button>
    </a>
</div>
</body>
</html>
