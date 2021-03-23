<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Landing Page</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<body>
	<div class="container p-3 my-3 bg-dark text-white">
		<h1>Success</h1>
		<div class="form-group">
		Your login has been successful
		</div>
		<div>
		<a href="<c:url value="/Logout"/>" class="btn btn-info" role="button">Logout</a>
		</div>
		
	</div>
</body>
</html>