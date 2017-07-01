<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
	<link href="<c:url value="/resources/css/lavish-bootstrap.css" />" rel="stylesheet">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<form:form method="POST" commandName="loginDetails" action="home.html">
			<div class="container">
				<h1>Address Book</h1>
				<p>A web application that utilises Spring MVC, CRUD functionality with H2 database and Bootstrap UI styling</p>
				<table class="horizontal-buttons">
					<tr>
						<td><a href="${pageContext.request.contextPath}/getEntryPage.html" class="btn btn-lg btn-primary preview-link" >Search For Entry</a></td>
						<td><a href="${pageContext.request.contextPath}/allEntriesPage.html" class="btn btn-lg btn-primary preview-link">Get All Entries</a></td>
						<td><a href="${pageContext.request.contextPath}/addEntryPage.html" class="btn btn-lg btn-primary preview-link">Add Entry</a></td>
					</tr>
				</table>
			</div>
		</form:form>
	</div>
</body>
</html>