package com.example.authorBookServlet.filter;


import com.example.authorBookServlet.model.Type;
import com.example.authorBookServlet.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/updateAuthor","/createAuthor","/removeAuthor"})
public class UserAuthorAction implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
         User user = (User) session.getAttribute("user");
        if (user.getType() == Type.USER) {
            response.sendRedirect("/");
        } else {
            filterChain.doFilter(request,response);
        }
    }
}
