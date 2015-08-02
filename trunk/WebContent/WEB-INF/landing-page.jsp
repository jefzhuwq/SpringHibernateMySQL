<%@ include file="/WEB-INF/views/common.inc" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Framework application</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="css/bootstrap.min.css"/>">
	
	<%@page import="main.java.controller.LoginController"%>
	<%@page import="main.java.form.LoginForm"%>
	
</head>

<body style="margin:200px 0px; padding:0px;">
	<c:set var="formName"><%=LoginController.LOGIN_FORM%></c:set>
	<a href="signup">Sign up</a>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span4 offset4">
				
				<form:form action="login" commandName="${formName}" class="form-horizontal well">
					<table style="width:100%">
						<tr>
							<td width="30%" align="center" style="padding:10px"><label>Username</label></td>
							<td width="70%"><input type="text" placeholder="Type username here..."/></td>
						</tr>
						<tr>
							<td align="center" style="padding:10px"><label>Password</label></td>
							<td><input type="password" placeholder="Type password here..."/></td>
						</tr>
						<tr>
							<td></td>
							<td style="padding-top:10px">
								<input type="submit" value="Login" class="btn btn-primary">
							</td>
						</tr>
					</table>
				</form:form>
				
			</div>
		</div>
	</div>
	
</body>
</html>