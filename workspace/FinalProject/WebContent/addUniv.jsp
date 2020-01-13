<%@ page import="Project.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>addUniv</title>
</head>
<body>
	<form method="post" action="addUnivAction.jsp" name="addUniversity">
		&nbsp;ADD UNIVERSITY<br>
		<table style="text-align: left; width: 494px; height: 485px;"
			border="1" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top;">SCHOOL NAME<br>
					</td>
					<td style="vertical-align: top;"><input name="schoolName"><br>
					</td>
				</tr>
				<tr>
					<td style="vertical-align: top;">STATE<br>
					</td>
					<td style="vertical-align: top;"><input name="state"
						value="-1"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">LOCATION<br>
					</td>
					<td style="vertical-align: top;"><input name="location"
						value="-1"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">CONTROL<br>
					</td>
					<td style="vertical-align: top;"><input name="control"
						value="-1"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">NUMBER OF STUDENTS<br>
					</td>
					<td style="vertical-align: top;"><input
						name="numberOfStudents" value="-1"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% FEMALE<br>
					</td>
					<td style="vertical-align: top;"><input name="percentFemale"
						value="-1"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT VERBAL<br>
					</td>
					<td style="vertical-align: top;"><input name="satVerbal"
						value="-1"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT MATH<br>
					</td>
					<td style="vertical-align: top;"><input name="satMath"
						value="-1"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">EXPENSES<br>
					</td>
					<td style="vertical-align: top;"><input name="expenses"
						value="-1"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% FINANCIAL AID<br>
					</td>
					<td style="vertical-align: top;"><input name="percentFA"
						value="-1"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">NUMBER OF APPLICANTS<br>
					</td>
					<td style="vertical-align: top;"><input
						name="numberOfApplicants" value="-1"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% ADMITTED<br>
					</td>
					<td style="vertical-align: top;"><input name="percentAdmitted"
						value="-1"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% ENROLLED<br>
					</td>
					<td style="vertical-align: top;"><input name="percentEnrolled"
						value="-1"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">ACADEMIC SCALE (1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="qualityAcademic"
						value="-1"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SOCIAL SCALE (1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="qualitySocial"
						value="-1"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">QUALITY OF LIFE (1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="qualityLife" value="-1"><br>
					</td>
				</tr>
				
				<% 	
					String emp1 = "";
					String emp2 = "";
					String emp3 = "";
					String emp4 = "";
					String emp5 = "";
					%>
				<!-- start of emphases -->
				<tr>
					<td style="vertical-align: top;">EMPHASES<br>
					</td>
					<td style="vertical-align: top;">
						<input name="emp1" value="<%=emp1%>"><br>
			 			<input name="emp2" value="<%=emp2%>"><br>
						<input name="emp3" value="<%=emp3%>"><br>
						<input name="emp4" value="<%=emp4%>"><br>
						<input name="emp5" value="<%=emp5%>"><br>
					</td>
				</tr>
				<!-- end of emphases -->
				<tr>
					<td style="vertical-align: top;"><input value="Reset"
						name="Reset" type="reset"><br></td>
					<td style="vertical-align: top;"><input name="submit"
						value="Submit" type="submit"><br></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>