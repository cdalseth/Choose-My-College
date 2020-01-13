<%@ page import="Project.*" import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>manageUniv</title>
</head>
<% 
	DBController dbController = new DBController();
	ArrayList<String> allSchools = dbController.getAllUniversities();%>
<body>
		<a href="addUniv.jsp"><b>Add New University</b></a><br><br>
		<table style="text-align: left; width: 1553px; height: 324px;"
			border="1" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top;"><small>SCHOOL<br>
					</small></td>
					<td style="vertical-align: top;"><small>STATE<br>
					</small></td>
					<td style="vertical-align: top;"><small>LOCATION<br>
					</small></td>
					<td style="vertical-align: top;"><small>CONTROL<br>
					</small></td>
					<td style="vertical-align: top;"><small># OF STUDENTS<br>
					</small></td>
					<td style="vertical-align: top;"><small>% FEMALE<br>
					</small></td>
					<td style="vertical-align: top;"><small>SAT VERBAL<br>
					</small></td>
					<td style="vertical-align: top;"><small>SAT MATH<br>
					</small></td>
					<td style="vertical-align: top;"><small>EXPENSES<br>
					</small></td>
					<td style="vertical-align: top;"><small>% WITH
							FINANCIAL ADD<br>
					</small></td>
					<td style="vertical-align: top;"><small># OF
							APLLICANTS<br>
					</small></td>
					<td style="vertical-align: top;"><small>% ADMITTED<br>
					</small></td>
					<td style="vertical-align: top;"><small>% ENROLLED<br>
					</small></td>
					<td style="vertical-align: top;"><small>ACADEMIC SCALE<br>
					</small></td>
					<td style="vertical-align: top;"><small>SOCIAL SCALE<br>
					</small></td>
					<td style="vertical-align: top;"><small>QUALITY OF
							LIFE<br>
					</small></td>
					<td style="vertical-align: top;"><small>EDIT<br>
					</small></td>
				</tr>
				<%	for(String schoolName: allSchools){ 
						University school = dbController.getUniversity(schoolName);%>
				<tr>

					<td style="vertical-align: top;"><br><%=school.getName()%></td>
					<td style="vertical-align: top;"><br><%=school.getState()%></td>
					<td style="vertical-align: top;"><br><%=school.getLocation() %></td>
					<td style="vertical-align: top;"><br><%=school.getControl()%></td>
					<td style="vertical-align: top;"><br><%=school.getNumStudents() %></td>
					<td style="vertical-align: top;"><br><%=school.getPercentFemale()%></td>
					<td style="vertical-align: top;"><br><%=school.getSatVerbal()%></td>
					<td style="vertical-align: top;"><br><%=school.getSatMath()%></td>
					<td style="vertical-align: top;"><br><%=school.getExpenses()%></td>
					<td style="vertical-align: top;"><br><%=school.getFinancialAid()%></td>
					<td style="vertical-align: top;"><br><%=school.getNumApplicants()%></td>
					<td style="vertical-align: top;"><br><%=school.getPercentAdmitted()%></td>
					<td style="vertical-align: top;"><br><%=school.getPercentEnrolled()%></td>
					<td style="vertical-align: top;"><br><%=school.getAcademicScale()%></td>
					<td style="vertical-align: top;"><br><%=school.getSocialScale()%></td>
					<td style="vertical-align: top;"><br><%=school.getLifeScale()%></td>
					<td style="vertical-align: top;"><br>
					<form method="post" action="editUniv.jsp" name="Edit">
						<input name="Edit" value="Edit" type="submit"> 
						<input name="schoolName" value="<%=school.getName()%>" type="hidden">
					</form>
					</td>
				</tr>
				<%}%>
			</tbody>
		</table>
		<br>
</body>
</html>