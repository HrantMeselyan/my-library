package com.example.authorBookServlet.filter;

import com.example.authorBookServlet.model.Type;
import com.example.authorBookServlet.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/removeBook", "/updateBook"})
public class UserUpdateDeleteFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (request.getParameter("userId") == null) {
            response.sendRedirect("/");
        } else if (user.getId() != Integer.parseInt(request.getParameter("userId")) && user.getType() != Type.ADMIN) {
            response.sendRedirect("/");
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
