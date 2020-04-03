<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>item List</title>
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/css/carousel.css"
	rel="stylesheet">

</head>
<body>
	<div class="row">
		<div class="col-lg-1">&nbsp;</div>
		<div class="col-lg-10">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Name</th>
						<th scope="col">qnty</th>
						<th scope="col">price</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${items}" var="item">
						<c:url var="updateLink" value="/items/update">
							<c:param name="id" value="${item.id}" />
						</c:url>
						<c:url var="deleteLink" value="/items/delete">
							<c:param name="id" value="${item.id}" />
						</c:url>
						<tr>
							<th scope="row">${item.id}</th>
							<td>${item.name}</td>
							<td>${item.qnty}</td>
							<td>${item.price}</td>
							<td><a href="${updateLink}">Update</a> / <a
								href="${deleteLink}">Delete</a></td>
						
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<a class="btn btn-success" href="add">Add Customer</a>
		</div>
		<div class="col-lg-1">&nbsp;</div>
	</div>
</body>
</html>