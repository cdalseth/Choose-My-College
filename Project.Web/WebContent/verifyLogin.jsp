<%@page language="java" import="edu.csbsju.csci230.*"%>

<%UserController uController = (UserController) session.getAttribute("sess"); 
if(uController==null || !uController.isLoggedIn()){
	response.sendRedirect("index.jsp?Error=4");
	return;
}%>