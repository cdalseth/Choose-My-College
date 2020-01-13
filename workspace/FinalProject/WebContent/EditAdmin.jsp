<%@page language="java" import="Project.*,java.util.*"%>
<html>
<head>
<%@include file="verifyLogin.jsp"%>
<title>Edit User Form</title>
</head>
<body>
	<br>
	<br>
	<br>

	<%
		AdminUI adminUI = (AdminUI) session.getAttribute("adminUI");
		DBController dbController = (DBController) session.getAttribute("dbController");
		String specificUsername = session.getAttribute("username").toString();
		Account specificUser = dbController.getAccount(specificUsername);
	%>
	<form method="post" action="EditAdminAction.jsp" name="EditAdmin">
		<br>
		<table style="text-align: left; width: 266px; height: 228px;"
			border="1">
			<tbody>
				<tr>
					<td style="vertical-align: top;">First Name<br>
					</td>
					<td style="vertical-align: top;"><input name="FirstName"
						value="<%out.print(specificUser.getFirstName());%>"><br></td>
				</tr>
				<tr>
				<tr>
					<td style="vertical-align: top;">Last Name<br>
					</td>
					<td style="vertical-align: top;"><input name="LastName"
						value="<%out.print(specificUser.getLastName());%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Username<br>
					</td>
					<td style="vertical-align: top;"><input name="Username"
						value="<%out.print(specificUser.getUsername());%>" readonly></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Password<br>
					</td>
					<td style="vertical-align: top;"><input name="Password"
						value="<%out.print(specificUser.getPassword());%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">Type<br>
					</td>
					<td style="vertical-align: top;"><input name="Type"
						value="<%out.print(specificUser.getType());%>"></td>

				<tr>
					<td style="vertical-align: top;"><input value="Edit User"
						name="Edit" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td style="vertical-align: top;"><input value="Reset"
						name="Reset" type="reset"></td>
				</tr>
			</tbody>
		</table>
		<br>
	</form>
	<br>
</body>
</html>

