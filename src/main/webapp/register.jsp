<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ItSpace</title>
    <%@ include file="header.jsp" %>
<body class="register">
<%
    if (session.getAttribute("user") != null) {
        response.sendRedirect("/home");
    }
    String msg = (String) request.getAttribute("msg");
%>
<section>
    <div class="px-4 py-5 px-md-5 text-center text-lg-start" style="background-color: hsl(0, 0%, 96%)">
        <div class="container">
            <div class="row gx-lg-5 align-items-center">
                <div class="col-lg-6 mb-5 mb-lg-0">
                    <h1 class="my-5 display-3 fw-bold ls-tight">
                        The best code <br/>
                        <span class="text-primary">learning academy</span>
                    </h1>
                    <p style="color: hsl(217, 10%, 50.8%)">
                        Lorem ipsum dolor sit amet consectetur adipisicing elit.
                        Eveniet, itaque accusantium odio, soluta, corrupti aliquam
                        quibusdam tempora at cupiditate quis eum maiores libero
                        veritatis? Dicta facilis sint aliquid ipsum atque?
                    </p>
                </div>

                <div class="col-lg-6 mb-5 mb-lg-0">
                    <div class="card">
                        <div class="card-body py-5 px-md-5">
                            <form action="/register" method="post">
                                <%if (msg != null) {%>
                                <span class="incorrect-login"><%=msg%></span>
                                <%}%>
                                <div class="row">
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <label class="form-label">Name</label>
                                            <input type="text" placeholder="name" name="name" required
                                                   class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-4">
                                        <div class="form-outline">
                                            <label class="form-label">Surname</label>
                                            <input type="text" placeholder="surname" name="surname" required
                                                   class="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-outline mb-4">
                                    <label class="form-label">Email</label>
                                    <input type="email" placeholder="email" name="email" required class="form-control"/>
                                </div>
                                <div class="form-outline">
                                    <label class="form-label">Password</label>
                                    <input type="password" placeholder="password" name="password" required
                                           class="form-control"/>
                                </div>
                                <div class="d-flex justify-content-center mb-4">
                                    <button type="submit" class="btn btn-primary btn-block mb-4">
                                        Register
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
