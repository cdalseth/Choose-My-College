<%@ page import="Project.*" import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>editUniv</title>
</head>
<%
	DBController dbController = new DBController();
	University school = dbController.getUniversity(request.getParameter("schoolName"));
	%>
<body>
	<br>
	<form method="post" action="editUnivAction.jsp" name="editUniversity">
		&nbsp;EDIT UNIVERSITY<br>
		<table style="text-align: left; width: 490px; height: 480px;"
			border="1" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top;">SCHOOL NAME<br>
					</td>
					<td style="vertical-align: top;"><input readonly="readonly" name="schoolName" value="<%=school.getName()%>"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">STATE<br>
					</td>
					<td style="vertical-align: top;"><input name="state" value="<%=school.getState()%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">LOCATION<br>
					</td>
					<td style="vertical-align: top;"><input name="location" value="<%=school.getLocation()%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">CONTROL<br>
					</td>
					<td style="vertical-align: top;"><input name="control" value="<%=school.getControl()%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">NUMBER OF STUDENTS<br>
					</td>
					<td style="vertical-align: top;"><input name="numberOfStudents" value="<%=school.getNumStudents()%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% FEMALE<br>
					</td>
					<td style="vertical-align: top;"><input name="percentFemale" value="<%=school.getPercentFemale()%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT VERBAL<br>
					</td>
					<td style="vertical-align: top;"><input name="satVerbal" value="<%=school.getSatVerbal()%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SAT MATH<br>
					</td>
					<td style="vertical-align: top;"><input name="satMath" value="<%=school.getSatMath()%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">EXPENSES<br>
					</td>
					<td style="vertical-align: top;"><input name="expenses" value="<%=school.getExpenses()%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% FINANCIAL AID<br>
					</td>
					<td style="vertical-align: top;"><input name="percentFA" value="<%=school.getFinancialAid()%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">NUMBER OF APPLICANTS<br>
					</td>
					<td style="vertical-align: top;"><input name="numberOfApplicants" value="<%=school.getNumApplicants()%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% ADMITTED<br>
					</td>
					<td style="vertical-align: top;"><input name="percentAdmitted" value="<%=school.getPercentAdmitted()%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">% ENROLLED<br>
					</td>
					<td style="vertical-align: top;"><input name="percentEnrolled" value="<%=school.getPercentEnrolled()%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">ACADEMIC SCALE (1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="qualityAcademic" value="<%=school.getAcademicScale()%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">SOCIAL SCALE (1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="qualitySocial" value="<%=school.getSocialScale()%>"></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">QUALITY OF LIFE (1-5)<br>
					</td>
					<td style="vertical-align: top;"><input name="qualityLife" value="<%=school.getLifeScale()%>"><br>
					</td>
				</tr>
				
				<% 	
					ArrayList<String> emp = school.getEmphases();
					String emp1 = "";
					String emp2 = "";
					String emp3 = "";
					String emp4 = "";
					String emp5 = "";
					try{
						emp1 = emp.get(0);
						emp2 = emp.get(1);
						emp3 = emp.get(2);
						emp4 = emp.get(3);
						emp5 = emp.get(4);
					}
					catch(IndexOutOfBoundsException e){
						//just catch it, don't do anything with it
						}
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
		<br>
	</form>

</body>
</html>