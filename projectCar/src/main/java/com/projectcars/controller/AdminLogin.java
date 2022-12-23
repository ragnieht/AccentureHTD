package com.projectcars.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projectcars.model.Admin;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String inputUn = req.getParameter("inputUn");
		String inputPw = req.getParameter("inputPw");
		Admin a = new Admin(inputUn,inputPw);
//		System.out.println(inputUn + " " + inputPw);
//		System.out.println(a.getUsername() + " " + a.getPassword());
//		System.out.println(a.validateAdmin());
		String status = a.validateAdmin();	
		
		switch(status) {
			case "invalidUn" :
				resp.sendRedirect("adminInvalidUn.html");
				break;
			case "invalidPw" :
				resp.sendRedirect("adminInvalidPw.html");
				break;
			case "success" :
				resp.sendRedirect("adminHome.html");				
				break;
			default :
				resp.sendRedirect("adminLogin.html");
				break;
		}			
	}
}
