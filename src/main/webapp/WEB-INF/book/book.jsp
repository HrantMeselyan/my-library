<%@ page import="java.util.List" %>
<%@ page import="com.example.authorBookServlet.model.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
        <% List<Book> books = (List<Book>) request.getAttribute("books"); %>
    <%@ include file="../../header.jsp" %>
<body>
<h1 class="main-title">Books</h1>
<main class="main">
    <div class="row">
        <div class="col-md-6">
            <form action="/search" method="post" class="form-group">
                <div class="search form-row d-flex">
                    <div class="form-group search-form-group col-md-6">
                        <input type="text" placeholder="search book" name="name" class="form-control">
                    </div>
                    <div class="form-group search-form-group col-md-4">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <a href="/createBook" class="float-right">
                <button type="button" class="btn btn-primary">Add</button>
            </a>
        </div>
    </div>
    <table id="customers">
        <tr>
            <th>image</th>
            <th>id</th>
            <th>title</th>
            <th>description</th>
            <th>price</th>
            <th>author</th>
            <th>action</th>
        </tr>
        <% if (books != null && !books.isEmpty()) { %>
        <%for (Book book : books) { %>
        <tr>
            <%if(book.getPicName() == null || book.getPicName() == "null") {%>
            <td class="align-center"><a href=""><img src="../../img/default-image.webp" class="table-img"></a>
            </td>
            <% } else {%>
            <td class="align-center">
                <a href="/getImage?picName=<%=book.getPicName()%>"><img src="/getImage?picName=<%=book.getPicName()%>"
                                                                        class="table-img"></a>
            </td>
            <%}%>
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
            <td class="action"><a href="/removeBook?id=<%=book.getId()%>"><img src="../../img/trash.svg" alt=""></a>
                |
                <a href="/updateBook?id=<%=book.getId()%>"><img src="../../img/update.svg"></a></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</main>
</body>
</html>
