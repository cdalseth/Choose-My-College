<%@page language="java" import="Project.*"%>

<%LoginUI loginUI = (LoginUI) session.getAttribute("loginUI"); 
if(loginUI.getLoggedIn().equals("")){
	response.sendRedirect("index.jsp?Error=4");
	return;
}%>