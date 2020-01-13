<%@page language="java" import="edu.csbsju.csci230.*"%>

<%
	UserController uController = new UserController();
	String uName = request.getParameter("Username");
	String pass = request.getParameter("Password");
	int loginResult = uController.login(uName, pass);
	if (loginResult == 0) {
		session.setAttribute("sess", uController);
		response.sendRedirect("Menu.jsp");
	}
	else if(loginResult == -1){
		response.sendRedirect("index.jsp?Error=1");
	}
	else if(loginResult == -2){
		response.sendRedirect("index.jsp?Error=2");
	}
	else{
		response.sendRedirect("index.jsp?Error=3");
	}
	
%>
