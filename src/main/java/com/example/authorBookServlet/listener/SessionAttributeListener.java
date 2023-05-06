package com.example.authorBookServlet.listener;

import com.example.authorBookServlet.model.User;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Date;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String id = event.getSession().getId();
        String attrName = event.getName();
        User attrValue = (User) event.getValue();
        if (attrName.equalsIgnoreCase("user")) {
            System.out.println("User with " + attrValue.getEmail() +
                    "email was sign in  at" + new Date() + "sessionId= " + id);
        }
    }
}