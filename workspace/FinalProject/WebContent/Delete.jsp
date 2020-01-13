<%@include file = "verifyLogin.jsp"%>
<%@page language="java" import="edu.csbsju.csci230.*,java.util.*"%>

<%
UserController uc = (UserController) session.getAttribute("sess");

   String specificUsername = request.getParameter("Username");
   User specificUser = uc.getSpecificUser(specificUsername);
   uc.deleteUser(specificUser);
   response.sendRedirect("Menu.jsp");
%>