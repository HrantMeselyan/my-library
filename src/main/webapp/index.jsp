<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ItSpace</title>
    <%@ include file="header.jsp" %>
<body>
<%
    if (session.getAttribute("user") != null) {
        response.sendRedirect("/home");
    }
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
                            <form action="/login" method="post">
                                <div class="row">
                                    <div class="form-outline mb-4">
                                        <label class="form-label">Email</label>
                                        <input type="email" placeholder="email" name="email" class="form-control"/>
                                    </div>
                                    <div class="form-outline">
                                        <label class="form-label">Password</label>
                                        <input type="password" name="password" placeholder="password"
                                               class="form-control"/>
                                    </div>
                                    <div class="form-outline">
                                        <%String msg = (String) session.getAttribute("msg");%>
                                        <%if (msg != null) {%>
                                        <span class="incorrect-login"><%=msg%></span>
                                        <%
                                        session.removeAttribute("msg");
                                        }%>
                                    </div>
                                    <div class="d-flex justify-content-center mb-4">
                                        <button type="submit" class="btn btn-primary btn-block mb-4">
                                            Sign up
                                        </button>
                                    </div>
                                </div>
                            </form>
                            <a href="/register.jsp">Register</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
