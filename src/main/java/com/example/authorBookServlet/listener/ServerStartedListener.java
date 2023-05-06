package com.example.authorBookServlet.listener;

import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;

@WebListener
public class ServerStartedListener implements ServletContextListener {

    public void contextInitialized(javax.servlet.ServletContextEvent sce) {
        System.out.println("Server started at " + new Date());
    }

    public void contextDestroyed(javax.servlet.ServletContextEvent sce) {
        System.out.println("Server destroyed at " + new Date());
    }
}
