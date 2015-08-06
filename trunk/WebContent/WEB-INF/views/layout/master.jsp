<%@ include file="/WEB-INF/views/common.inc"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<tiles:insertAttribute name="title" ignore="true" />

<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>">
<%-- <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap-responsive.min.css"/>"> --%>
<%-- <link rel="stylesheet" type="text/css" href="<c:url value="/css/jquery-ui.css"/>"> --%>
<%-- <link rel="stylesheet" type="text/css" href="<c:url value="/css/flexigrid.css"/>"> --%>
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
</head>

<body>
<%-- 	<script type="text/javascript" src="<c:url value="/js/jquery-1.8.1.min.js"/>"></script> --%>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
<%-- 	<script type="text/javascript" src="<c:url value="/js/jquery-ui.js"/>"></script> --%>
<%-- 	<script type="text/javascript" src="<c:url value="/js/jquery.validate.js"/>"></script> --%>
<%-- 	<script type="text/javascript" src="<c:url value="/js/jstree.js"/>"></script> --%>
<%-- 	<script type="text/javascript" src="<c:url value="/js/flexigrid.js"/>"></script> --%>

	<tiles:insertAttribute name="header" />
	<div class="container">
		<tiles:insertAttribute name="body" />
	</div>
	<tiles:insertAttribute name="footer" />


</body>
</html>