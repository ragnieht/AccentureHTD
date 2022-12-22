import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddResult extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		try {
    		Driver d = new com.mysql.jdbc.Driver();
    		DriverManager.registerDriver(d);
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_acc_db","root","root");
    		    		
    		int id = Integer.parseInt(req.getParameter("inputId"));
    		String name = req.getParameter("inputName");
    		int mark1 = Integer.parseInt(req.getParameter("inputMark1"));
    		int mark2 = Integer.parseInt(req.getParameter("inputMark2"));
    		int mark3 = Integer.parseInt(req.getParameter("inputMark3"));    		
    		
    		String ps = "insert into student values (?,?,?,?,?)";
    		PreparedStatement pstmt = con.prepareStatement(ps);
    		pstmt.setInt(1, id);
    		pstmt.setString(2, name);
    		pstmt.setInt(3, mark1);
    		pstmt.setInt(4, mark2);
    		pstmt.setInt(5, mark3);    		
    		    		    	
    		int rows = pstmt.executeUpdate();
    		PrintWriter out = res.getWriter();    		
    		if (rows > 0) {
    			out.println("Student details added successfully");
    		} else {
    			out.println("Failed to add student details");
    		}
    		System.out.println(rows);
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}
}
