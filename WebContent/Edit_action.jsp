<%@include file="verifyLogin.jsp"%>

<%@page language="java" import="edu.csbsju.csci230.*,java.util.*"%>

<%
	UserController uc = (UserController) session.getAttribute("sess");

	String specificUsername = request.getParameter("Username");
	User specificUser = uc.getSpecificUser(specificUsername);
	String fName = request.getParameter("FirstName");
	String lName = request.getParameter("LastName");
	String uName = request.getParameter("Username");
	String password = request.getParameter("Password");
	char type = request.getParameter("Type").charAt(0);
	char status = request.getParameter("Status").charAt(0);
	User u = new User(fName, lName, uName, password, type, status);
	uc.editUser(u);
	response.sendRedirect("Menu.jsp");
%>