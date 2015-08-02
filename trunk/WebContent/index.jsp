<%@ include file="/WEB-INF/views/common.inc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Pro</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
$(function() {
  $( "input[type=submit], a, button" )
    .button()
    .click(function( event ) {
      //event.preventDefault();
    });
});
</script>
<%@page import="main.java.controller.LoginController"%>
<%@page import="main.java.form.LoginForm"%>
</head>
<body>
	<c:set var="formName"><%=LoginController.LOGIN_FORM%></c:set>
	<form:form action="login" commandName="${formName}">
		<table style="width: 100%">
			<tr>
				<td width="30%" align="center" style="padding: 10px"><label>Username</label></td>
				<td width="70%"><input type="text"
					placeholder="Type username here..." /></td>
			</tr>
			<tr>
				<td align="center" style="padding: 10px"><label>Password</label></td>
				<td><input type="password" placeholder="Type password here..." /></td>
			</tr>
			<tr>
				<td></td>
				<td style="padding-top: 10px">
					<input type="submit" value="Login">
					<a href="signup">Sign up</a>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>