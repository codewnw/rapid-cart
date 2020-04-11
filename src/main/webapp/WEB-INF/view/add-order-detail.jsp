<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Add Customer</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<table>
		<form:form action="save" modelAttribute="orderDetail">

			<tr>
				<td>Order Total :</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td>Order Date :</td>
				<td><form:input path="quantity" /></td>
			</tr>

			<form:input path="orderDetailId" type="hidden" />

			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</form:form>
	</table>

</body>
</html>