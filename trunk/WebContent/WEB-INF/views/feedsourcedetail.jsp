<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Success</title>
</head>

<br/>
<br/>
<br/>
<br/>
<div>
<table>
	<tr>
	<td>ID</td>
	<td>desc</td>
	<td>tag</td>
	</tr>
	<tr>
		<td>${feedSource.getId()}</td>
		<td>${feedSource.getDescription()}</td>
		<td>
			<c:forEach var="tag" items="${feedSource.getTags()}">
				${tag} 
				<a href="deletetag?id=${feedSource.getId()}&op=delete&tag=${tag}">x</a>, 
			</c:forEach>
		</td>
	</tr>
</table>

<form:form action="feedsourcedetail?id=${feedSource.getId()}" commandName="addTagForm" method="post"  class="form-horizontal well">
	<table style="width:100%">
		<tr>
			<td width="30%" align="center" style="padding:10px"><label>tag name</label></td>
			<td width="70%"><form:input path="tagname" /></td>
		</tr>
		<tr>
			<td style="padding-top:10px">
				<input type="submit" value="Add Tag" class="btn btn-primary">
			</td>
		</tr>
	</table>
</form:form>
</div>
</html>