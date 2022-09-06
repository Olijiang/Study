package com.sc.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//监控在线人数

@WebListener
public class Listeners implements HttpSessionListener {

	private int stuNumbers=0;
	
    public Listeners() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  { 
         // TODO Auto-generated method stub
    	HttpSession session = event.getSession();
    	session.setAttribute("session", stuNumbers++);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
         // TODO Auto-generated method stub
    	HttpSession session = event.getSession();
    	session.setAttribute("session", stuNumbers--);
    }
	
}
