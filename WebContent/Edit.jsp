<%@page language="java" import="edu.csbsju.csci230.*,java.util.*"%>
<html>
<head>
<%@include file="verifyLogin.jsp"%>
<title>Edit User Form</title>
</head>
<body>
	<br> Edit User form:
	<br>
	<br>

	<%
		UserController uc = (UserController) session.getAttribute("sess");
		String specificUsername = request.getParameter("Username");
		User specificUser = uc.getSpecificUser(specificUsername);
		out.println("Edit user : " + request.getParameter("Username"));
	%>
	<form method="post" action="Edit_action.jsp" name="editUser">
		<br>
		<table style="text-align: left; width: 266px; height: 228px;"
			border="1">
			<tbody>
				<tr>
					<td style="vertical-align: top;">First Name<br>
					</td>
					<td style="vertical-align: top;"><input name="FirstName"
						value="<%out.print(specificUser.getfName());%>"><br></td>
				</tr>
				<tr>
				<tr>
					<td style="vertical-align: top;">Last Name<br>
					</td>
					<td style="vertical-align: top;"><input name="LastName"
						value="<%out.print(specificUser.getlName());%>"><br></td>
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
				</tr>
				<tr>
					<td style="vertical-align: top;">Status<br>
					</td>
					<td style="vertical-align: top;"><input name="Status"
						value="<%out.print(specificUser.getStatus());%>"></td>
				</tr>

				<tr>
					<td style="vertical-align: top;"><input value="Edit"
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

