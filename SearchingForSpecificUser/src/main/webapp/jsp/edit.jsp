<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<body>
	<div class="container p-3 my-3 bg-dark text-white">
		<h1>Edit User</h1>
		<form:form action="/edit" method="post" modelAttribute="user">
			<div class="form-group">
				<form:label path="userID">User ID:</form:label>
				<input type="text" class="form-control" name="userID"
					value="${user.getUserID()}" readonly>
			</div>
			<div class="form-group">
				<form:label path="firstName">First Name:</form:label>
				<input type="text" class="form-control" name="firstName"
					value="${user.getFirstName()}" required>
			</div>
			<div class="form-group">
				<form:label path="lastName">Last Name:</form:label>
				<input type="text" class="form-control" name="lastName"
					value="${user.getLastName()}" required>
			</div>
			<button type="submit" class="btn btn-primary">Update</button>
			<a href="users" class="btn btn-info" role="button">Return</a>
		</form:form>
		<div>${result}</div>
	</div>
</body>
</html>