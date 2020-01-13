<%@include file="verifyLogin.jsp"%>
<%@page language="java" import="Project..*,java.util.*"%>
<html>
<head>
<title></title>
</head>
<body>

	<%
		UserController uc = (UserController) session.getAttribute("sess");
		User currentU = uc.getCurrentUser();
		String name = currentU.getfName();
		out.print("Hello User " + name);
		ArrayList<User> allUsers = new ArrayList<User>();
		allUsers = uc.getAllUsers();
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
			<% for(int i = 0; i<allUsers.size(); i++){ %>
			<tr>
				<td style="vertical-align: top;">
					<form method="post" action="Edit.jsp" name="Edit">
						<input name="Edit" value="Edit" type="submit"> <input
							name="Username" value="<%= (allUsers.get(i)).getUsername() %>"
							type="hidden">
					</form>
				</td>
				<td style="vertical-align: top;">
					<%out.print(allUsers.get(i).getFullName());%>
				</td>
				<td style="vertical-align: top;">
					<%out.print(allUsers.get(i).getUsername());%>
				</td>
				<td style="vertical-align: top;">
					<%out.print(allUsers.get(i).getPassword());%>
				</td>
				<td style="vertical-align: top;">
					<%out.print(allUsers.get(i).getType());%>
				</td>
				<td style="vertical-align: top;">
					<%out.print(allUsers.get(i).getStatus());%>
				</td>
				<td style="vertical-align: top;">
					<form method="post" action="Delete.jsp" name="Delete">
						<input name="Delete" value="Delete" type="submit"> <input
							name="Username" value="<%= (allUsers.get(i)).getUsername() %>"
							type="hidden">
					</form>
				</td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>

