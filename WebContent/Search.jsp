<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>schoolSearchMenu</title>
</head>
<body>
	<form method="post" action="searchResult.html" name="SearchMenu">
		&nbsp; <b>Search Menu</b><br>   
		<table style="text-align: left; width: 892px; height: 566px;"
			border="1" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top;">by SCHOOL NAME<br>
					</td>
					<td style="vertical-align: top;"><label>contains </label><input
						name="schoolName"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by STATE<br>
					</td>
					<td style="vertical-align: top;"><label>contains <input
							name="state"></label><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by LOCATION<br>
					</td>
					<td style="vertical-align: top;"><input name="location"><label>(SUBURBAN,
							URBAN, SMALL-CITY) </label><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by CONTROL<br>
					</td>
					<td style="vertical-align: top;"><input name="control"><label>(PRIVATE,
							STATE, CITY)</label><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by NUMBER OF STUDENTS<br>
					</td>
					<td style="vertical-align: top;"><label>between </label><input
						name="numStudentsLow"><label> and</label> <input
						name="numStudentsHigh"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by % FEMALE<br>
					</td>
					<td style="vertical-align: top;"><label>between </label><input
						name="perFemaleLow"><label> and</label> <input
						name="perFemaleHigh"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by SAT VERBAL<br>
					</td>
					<td style="vertical-align: top;"><label>between </label><input
						name="satVerbalLow"><label> and</label> <input
						name="satVerbalHigh"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by SAT MATH<br>
					</td>
					<td style="vertical-align: top;"><label>between </label><input
						name="satMathLow"><label> and</label> <input
						name="satMathHigh"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by EXPENSES<br>
					</td>
					<td style="vertical-align: top;"><label>between </label><input
						name="expensesLow"><label> and</label> <input
						name="expensesHigh"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by % FINANCIAL AID<br>
					</td>
					<td style="vertical-align: top;"><label>between </label><input
						name="perFALow"><label> and</label> <input
						name="perFAHigh"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by NUMBER OF APPLICANTS<br>
					</td>
					<td style="vertical-align: top;"><label>between </label><input
						name="numApplicantsLow"><label> and</label> <input
						name="numApplicantsHigh"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by % ADMITTED<br>
					</td>
					<td style="vertical-align: top;"><label>between </label><input
						name="perAdmittedLow"><label> and</label> <input
						name="perAdmittedHigh"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by % ENROLLED<br>
					</td>
					<td style="vertical-align: top;"><label>between </label><input
						name="perEnrolledLow"><label> and</label> <input
						name="perEnrolledHigh"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by ACADEMIC SCALE (1-5)<br>
					</td>
					<td style="vertical-align: top;"><label>between </label><input
						name="academicScaleLow"><label> and</label> <input
						name="academicScaleHigh"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by SOCIAL SCALE (1-5)<br>
					</td>
					<td style="vertical-align: top;"><label>between </label><input
						name="socialScaleLow"><label> and</label> <input
						name="socialScaleHigh"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by QUALITY OF LIFE SCALE
						(1-5)<br>
					</td>
					<td style="vertical-align: top;"><label>between </label><input
						name="lifeScaleLow"><label> and</label> <input
						name="lifeScaleHigh"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top;">by EMPHASES<br>
					</td>
					<td style="vertical-align: top;"><label>contains
							either<br> <input name="emphases1"><br> <input
							name="emphases2"><br> <input name="emphases3"><br>
							<input name="emphases4"><br> <input name="emphases5"><br>
					</label></td>
				</tr>
			</tbody>
		</table>
		<br> <br> <input name="submitResults"
			value="Search For Schools" type="submit">&nbsp;&nbsp;&nbsp; <input
			name="searchReset" value="Reset Form" type="reset"><br>
	</form>
	<br>
	<br>
</body>
</html>
