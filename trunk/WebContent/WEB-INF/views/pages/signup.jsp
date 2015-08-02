<%@ include file="/WEB-INF/views/common.inc" %>

<%@page import="main.java.controller.SignupController"%>
<%@page import="main.java.form.SignupForm"%>
	
<div class="container">
<script>
$().ready(function() {
	$("#signupForm").validate({
		rules: {
			username: {
				required: true,
				email: true
			},
			password: {
				required: true,
				minlength: 5
			},
			confirm_password: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			
			
			agree: "required"
		},
		messages: {
			firstname: "Please enter your firstname",
			lastname: "Please enter your lastname",
			username: {
				required: "Please enter a username",
				minlength: "Your username must consist of at least 2 characters"
			},
			password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long"
			},
			confirm_password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long",
				equalTo: "Please enter the same password as above"
			},
			email: "Please enter a valid email address",
			agree: "Please accept our policy"
		}
	});
});
</script>


	<br/><br/><br/>

	<div class="container">  
		<h2>Sign up</h2>
	</div>
	<c:set var="formName"><%=SignupController.SIGNUP_FORM%></c:set>
	<form:form id="signupForm" action="signup" commandName="${formName}" class="form-horizontal well">
		User Name
		<div>
			<input type="text" minlength="5" name="username" id="username" required />
		</div>
		Password
		<div>
			<input type="password" minlength="8" name="password" id="password" required />
		</div>
		Confirm Password
		<div>
			<input type="password" minlength="8" name="confirm_password" id="confirm_password" required />
		</div>
		<br>
		<div>
			<label for="agree">Please agree to our policy</label>
			<input type="checkbox" class="checkbox" id="agree" name="agree">
		</div>
		<div>
			<button type="submit" class="ui-state-default ui-corner-all ui-state-hover" name="websubmit" id="u_0_9">Sign Up</button>
		</div>
	</form:form>
</div>

<script>
	
</script>