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

<div class="container" style="width: 80%; float: left">
<div id="users-contain" >
<table id="users" class="flexme1">
	<thead>
		<tr>
			<th>FeedSourceID</th>
			<th>Content</th>
			<th>Edit</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="feedSource" items="${feedSourceList}">
			<tr>
				<td>${feedSource.get("id")}</td>
				<td>${feedSource}</td>
				<td><a href='./feedsourcedetail?id=${feedSource.get("id")}'>edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</div>
</html>