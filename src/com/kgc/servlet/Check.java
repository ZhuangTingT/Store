package com.kgc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgc.dao.UsersDAO;

public class Check extends HttpServlet 
{	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException 
	{
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
    	String passWord = request.getParameter("password");
    	UsersDAO usersDAO = new UsersDAO();
    	boolean log = usersDAO.loginCheck(name, passWord);
    	if(log)
    	{
    		response.sendRedirect("../servlet/FindGoods");
    	}
    	else
    	{
    		response.sendRedirect("../login.html");
    	}
	}

}
