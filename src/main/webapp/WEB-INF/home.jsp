<%@ page import="com.example.authorBookServlet.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <%@ include file="../header.jsp" %>
<body>
<%User user = (User) session.getAttribute("user");%>

<div class="typewriterDiv m-top-40">
    <div class="typewriter">
        <h1 class="typewriter-h1">Welcome <%=user.getName()%>  <%=user.getSurname()%> To The ITSpaceAcademy</h1>
    </div>
</div>

<div class="m-top-40">
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="../img/carousel-1.jpg" alt="First slide">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Hello</h5>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis cum cumque </p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="../img/carousel-2.jpg" alt="Second slide">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Welcome</h5>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis cum cumque </p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="../img/carousel.jpg" alt="Third slide">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Welcome</h5>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis cum cumque </p>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" typeof="hidden" aria-hidden="true"></span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
        </a>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
