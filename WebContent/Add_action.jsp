<%@page language="java" import="edu.csbsju.csci230.*,java.util.*"%>

<%UserController uc = (UserController) session.getAttribute("sess");
	String fName = request.getParameter("FirstName");
	String lName = request.getParameter("LastName");
	String uName = request.getParameter("Username");
	String pass = request.getParameter("Password");
	char type = request.getParameter("Type").charAt(0);
	char status = request.getParameter("Status").charAt(0);
	User user = new User(fName,lName,uName,pass,type,status);
	uc.addUser(user);
	int loginResult = uc.login(uName, pass);
	
		response.sendRedirect("Menu.jsp");
	
	%>