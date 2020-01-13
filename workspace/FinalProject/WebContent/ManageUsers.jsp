<%@include file = "verifyLogin.jsp"%>
<%@page language="java" import="java.util.*,Project.*"%>
<html>
<head>
<title></title>
</head>
<body>

	<%
		UserUI userUI = (UserUI) session.getAttribute("userUI");
		AdminUI adminUI = (AdminUI) session.getAttribute("adminUI");
		DBController dbController = (DBController) session.getAttribute("dbController");
		Account currentU = dbController.getAccount(session.getAttribute("username").toString());
		String fullName = currentU.getFirstName() + " " + currentU.getLastName();
		out.print("Hello " + fullName);
		String[][] allUsers = adminUI.viewUsers();
	%>
	<table style="text-align: left; width: 100%;" border="1"
		cellpadding="2" cellspacing="2">
		<tbody>
			<tr align="center">

				<td colspan="8" rowspan="1" style="vertical-align: top;"><a
					href="Add.jsp">ADD A USER</a></td>

			</tr>
			<tr>
				<td style="vertical-align: top;">Edit</td>
				<td style="vertical-align: top; text-align: center;">Full name
				</td>
				<td style="vertical-align: top; text-align: center;">Username</td>
				<td style="vertical-align: top; text-align: center;">Password</td>
				<td style="vertical-align: top; text-align: center;">Type</td>
				<td style="vertical-align: top; text-align: center;">Status</td>
				<td style="vertical-align: top;">Delete</td>
			</tr>
			<% for(int i = 0; i<allUsers.length; i++){ %>
			<tr>
				<td style="vertical-align: top;">
					<form method="post" action="EditAdmin.jsp" name="Edit">
						<input name="Edit" value="Edit" type="submit"> <input
							name="Username" value="<%out.print(allUsers[i][2]);%>" type="hidden">
					</form>
				</td>
				<td style="vertical-align: top;"><%out.print(allUsers[i][2]);%></td>
				<td style="vertical-align: top;"><%out.print(allUsers[i][0]);%></td>
				<td style="vertical-align: top;"><%out.print(allUsers[i][1]);%></td>
				<td style="vertical-align: top;"><%out.print(allUsers[i][3]);%></td>
				<td style="vertical-align: top;"><%out.print(allUsers[i][4]);;%></td>
				<td style="vertical-align: top;">
					<form method="post" action="Delete.jsp" name="Delete">
						<input name="Delete" value="Delete" type="submit"> <input
							name="Username" value="<%out.print(allUsers[i][2]);%>" type="hidden">
					</form>
				</td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>

