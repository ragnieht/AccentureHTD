package com.accenture.control;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.model.Model;

public class AddResultMVC extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String tempId = req.getParameter("id");
		
		if (tempId.length() == 0) {
			res.sendRedirect("/addResultMV/invalidId.html");
		}
		else {
			int id = Integer.parseInt(tempId);
			String name = req.getParameter("name");
			int marks1 = Integer.parseInt(req.getParameter("marks1"));
			int marks2 = Integer.parseInt(req.getParameter("marks2"));
			int marks3 = Integer.parseInt(req.getParameter("marks3"));
			Model m = new Model(id, name, marks1, marks2, marks3);
			int rows = m.addResult(); 
			
			if(rows == 0) {
				res.sendRedirect("/addResultMV/failure.html");
			}
			else {
				res.sendRedirect("/addResultMV/success.html");
			}
		}
	}
}
