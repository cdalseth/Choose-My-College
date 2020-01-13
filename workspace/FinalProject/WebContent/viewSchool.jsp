<%@page language="java" import="java.util.*"%>
<%@include file="verifyLogin.jsp"%>

<% UserUI userUI = (UserUI) session.getAttribute("userUI");
	String schoolName = request.getParameter("schoolName");
	University univ = userUI.viewSchoolInfo(schoolName);
	ArrayList<String> emphases = univ.getEmphases();

%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>viewSchool.html</title>
</head>
<body>
	<form method="get" action="viewSchool.html" name="viewSchool"></form>
	<br>
	<table style="text-align: left; width: 686px; height: 497px;"
		border="1" cellpadding="2" cellspacing="2">
		<tbody>
			<tr>
				<td style="vertical-align: top;">SCHOOL<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="schoolName" value="<% univ.getName(); %>"><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">STATE<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="state" value="<% univ.getState(); %>"><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">LOCATION<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="location" value="<% univ.getLocation(); %>"></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">CONTROL<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="control" value="<% univ.getControl(); %>"><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">NUMBER OF STUDENTS<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="numStudents" value="<% univ.getNumStudents(); %>"><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">% FEMALE<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="perFemale" value="<% univ.getPercentFemale(); %>"><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">SAT VERBAL<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="satVerbal" value="<% univ.getSatVerbal(); %>"><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">SAT MATH<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="satMath" value="<% univ.getSatMath(); %>"><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">EXPENSES<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="expenses" value="<% univ.getExpenses(); %>"><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">% FINANCIAL AID<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="perFinancialAid" value="<% univ.getFinancialAid(); %>"><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">NUMBER OF APPLICANTS<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="numApplicants" value="<% univ.getNumApplicants(); %>"><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">% ADMITTED<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="perAdmitted" value="<% univ.getPercentAdmitted(); %>"><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">% ENROLLED<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="perEnrolled" value="<% univ.getPercentEnrolled(); %>"><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">ACADEMIC SCALE (1-5)<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="academicScale" value="<% univ.getAcademicScale(); %>"><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">SOCIAL SCALE (1-5)<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="socialScale" value="<% univ.getSocialScale(); %>"><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">QUALITY OF LIFE SCALE (1-5)<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="qualityScale" value="<% univ.getLifeScale(); %>"><br></td>
			</tr>
			<% for(int i =0; i<emphases.size();i++){%>
			<tr>
				<td style="vertical-align: top;">EMPHASES<br>
				</td>
				<td style="vertical-align: top;"><input readonly="readonly"
					name="emphases" value="<% emphases.get(i); %>"><br></td>
			</tr>
			<% }%>
		</tbody>
	</table>
	<br>
</body>
</html>
