package com.projectcars.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projectcars.model.*;

public class AdminHome extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer c = new Customer();
		ArrayList<CustomerDetails> detailsArrayList = c.viewCustomers();
				
		System.out.println("AdminHome Servlet" + " " + c.viewCustomers());
		
		HttpSession session = req.getSession(true);
		session.setAttribute("detailsArrayList",detailsArrayList);		
		resp.sendRedirect("adminHome-viewCustomers.jsp");		
	}
}
