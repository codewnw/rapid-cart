<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>500 | Internal Server Error</title>
</head>
<body>
	<h1>Oops, Something when wrong.</h1>
	<p>Please try again after sometime...</p>


	<hr>
	Go to
	<a href="${pageContext.request.contextPath}/">Home</a>
</body>
</html>