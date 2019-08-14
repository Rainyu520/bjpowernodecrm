package com.bjpowernode.web.filter;

import com.bjpowernode.settings.domain.User;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;


        String path = request.getServletPath();
        if ("/settings/user/login.do".equals(path) || "/login.jsp".equals(path)){
            chain.doFilter(req, resp);
        }else {
            User user = (User) request.getSession().getAttribute("user");
            if (user != null){
                chain.doFilter(req, resp);
            }else {

                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }

        }



    }



}
