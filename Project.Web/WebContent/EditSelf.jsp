<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>EditSelf</title>
</head>
<body>
<form action="EditAction.jsp" name="UserInfo">
  <table style="text-align: left; width: 778px; height: 195px;" border="1" cellpadding="2" cellspacing="2">
    <tbody>
      <tr>
        <td style="vertical-align: top;">First Name<br>
        </td>
        <td style="vertical-align: top;"><input name="firstName"><br>
        </td>
      </tr>
      <tr>
        <td style="vertical-align: top;">Last Name<br>
        </td>
        <td style="vertical-align: top;"><input name="lastName"><br>
        </td>
      </tr>
      <tr>
        <td style="vertical-align: top;">Username<br>
        </td>
        <td style="vertical-align: top;"><input readonly="readonly" name="username"><br>
        </td>
      </tr>
      <tr>
        <td style="vertical-align: top;">Password<br>
        </td>
        <td style="vertical-align: top;"><input name="password"><br>
        </td>
      </tr>
      <tr>
        <td style="vertical-align: top;">Type<br>
        </td>
        <td style="vertical-align: top;"><input readonly="readonly" name="type"><br>
        </td>
      </tr>
    </tbody>
  </table>
  <input name="submit" value="Submit Changes" type="submit">&nbsp;&nbsp;&nbsp; <input name="reset" value="Reset" type="reset"><br>
</form>


</body></html>