<%@page language="java" import="Project.*"%>

<%
	UserUI userUI = new UserUI();
	LoginUI loginUI = new LoginUI();
	AdminUI adminUI = new AdminUI();
	DBController dbController = new DBController();
	String uName = request.getParameter("Username");
	String pass = request.getParameter("Password");
	int loginResult = loginUI.Login(uName, pass);
	char loggedInStatus = 'n';
	if (loginResult == 0) {
		session.setAttribute("userUI", userUI);
		session.setAttribute("loginUI", loginUI);
		session.setAttribute("adminUI", adminUI);
		session.setAttribute("dbController", dbController);
		session.setAttribute("username",uName);
		String loggedIn = loginUI.getLoggedIn();
		loggedInStatus = dbController.getAccount(loggedIn).getType();
		if(loggedInStatus==('U')||loggedInStatus==('u')){
			response.sendRedirect("userMenu.jsp");
		}
		else{
			response.sendRedirect("adminMenu.jsp");
		}
	}
	else if(loginResult == 1){
		response.sendRedirect("index.jsp?Error=1");
	}
	else if(loginResult == 2){
		response.sendRedirect("index.jsp?Error=2");
	}
	else{
		response.sendRedirect("index.jsp?Error=3");
	}
	
%>
