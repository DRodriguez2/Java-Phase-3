<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<body>
	<div class="container p-3 my-3 bg-dark text-white">
		<h1>Search For User</h1>
		<form action="users" method="post">
			<div class="form-group">
				User ID: <input type="text" class="form-control" name="userID"
					placeholder="user id goes here" required>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<div>${result}</div>
	</div>
</body>
</html>