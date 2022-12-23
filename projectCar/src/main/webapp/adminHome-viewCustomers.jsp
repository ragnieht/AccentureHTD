<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
This is Admin Home - View Customers
<%@ page import = "java.util.*" %>
<%@ page import = "com.projectcars.model.*" %>
<%
	ArrayList<CustomerDetails> details = (ArrayList<CustomerDetails>)session.getAttribute("al");
	out.println(details);
%>
</body>
</html>