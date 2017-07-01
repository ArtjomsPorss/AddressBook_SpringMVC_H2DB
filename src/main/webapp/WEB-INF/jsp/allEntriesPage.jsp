<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<link href="<c:url value="/resources/css/lavish-bootstrap.css" />" rel="stylesheet">
	<script src="/resources/js/bootstrap.js"></script>
	<script src="/resources/js/jquery-3.2.1.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Entries</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="container">
			<h1>Entries</h1>
			<table class="table table-bordered table-striped table-hover">
				<colgroup>
					<col style="width:15%">
					<col style="width:15%">
					<col style="width:34%">
					<col style="width:10%">
					<col style="width:18%">
					<col style="width:8%">
				</colgroup>
				<thead>
					<tr>
						<th>Name</th>
						<th>Surname</th>
						<th>Address</th>
						<th>Phone Number</th>
						<th>email</th>
						<th>zip</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="entry" items="${entryList}">
					<form:form method="POST" commandName="addressBookEntry" action="deleteEntry.html">
					<form:hidden path="id" value="${entry.id}"/>
					<tr>
						<td>${entry.name}</td>
						<td>${entry.surname}</td>
						<td>${entry.address}</td>
						<td>${entry.phoneNumber}</td>
						<td>${entry.email}</td>
						<td>${entry.zip}</td>
						<td><a type="submit" href="${pageContext.request.contextPath}/editEntryPage.html?id=${entry.id}" class="btn btn-warning btn-sm preview-link">Edit</a></td>
						<td><button type="submit" class="btn btn-danger btn-sm preview-link">Delete</button></td>
					</tr>					
					</form:form>
				</c:forEach>
				</tbody>
			</table>
			<br/>
			<table class="horizontal-buttons">
				<tr>
					<td><a href="${pageContext.request.contextPath}/home.html" class="btn btn-lg btn-primary preview-link">Return</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>