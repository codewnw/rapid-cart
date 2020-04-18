<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>404 | Page Not Found</title>
</head>
<body>
	<h1>Page Not Found</h1>
	<p>
		The page (<strong style="color: red"><i>${url}</i></strong>) you are
		looking for is not found.
	</p>


	<hr>
	Go to
	<a href="${pageContext.request.contextPath}/">Home</a>
</body>
</html>