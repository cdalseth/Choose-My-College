<%@include file="verifyLogin.jsp"%>

<%@page language="java" import="Project.*,java.util.*"%>

<%
	UserUI userUI = (UserUI) session.getAttribute("userUI");
	DBController dbController = (DBController) session.getAttribute("dbController");

	String specificUsername = request.getParameter("Username");
	Account specificUser = dbController.getAccount(specificUsername);
	String fName = request.getParameter("FirstName");
	String lName = request.getParameter("LastName");
	String uName = request.getParameter("Username");
	String password = request.getParameter("Password");
	char type = request.getParameter("Type").charAt(0);
	dbController.editAccount(fName, lName, uName, password, type, 'Y');
	response.sendRedirect("userMenu.jsp");
%>