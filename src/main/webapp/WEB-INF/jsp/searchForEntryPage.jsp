<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<link href="<c:url value="/resources/css/lavish-bootstrap.css" />" rel="stylesheet">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search For Entry</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<form:form method="POST" commandName="addressBookEntry" action="getEntryPage.html"><!-- TODO what? -->
			<div class="container">
				<h1>Search For Entry</h1>
				<table>
					<tr>
						<td><input type="text" name="name" placeholder="name" value="${addressBookEntry.name}"/></td>
					</tr>
					<tr>
						<td><input type="text" name="surname" placeholder="surname" value="${addressBookEntry.surname}"/></td>
					</tr>
					<tr>
						<td><input type="text" name="address" placeholder="address" value="${addressBookEntry.address}"/></td>
					</tr>
					<tr>
						<td><input type="text" name="phoneNumber" placeholder="phoneNumber" value="${addressBookEntry.phoneNumber}"/></td>
					</tr>
					<tr>
						<td><input type="text" name="email" placeholder="email" value="${addressBookEntry.email}"/></td>
					</tr>
					<tr>
						<td><input type="text" name="zip" placeholder="zip" value="${addressBookEntry.zip}"/></td>
					</tr>
				</table>
				<br/>
				<table class="horizontal-buttons">
					<tr>
						<td><button type="submit" class="btn btn-lg btn-primary preview-link">Find Entry</button></td>
						<td><a href="${pageContext.request.contextPath}/home.html" class="btn btn-lg btn-primary preview-link">Return</a></td>
					</tr>
				</table>
			</div>
		</form:form>
	</div>
</body>
</html>