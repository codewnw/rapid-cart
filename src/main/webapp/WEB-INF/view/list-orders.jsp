<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Order List</title>
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
						<th scope="col">Order ID</th>
						<th scope="col">Customer ID</th>
						<th scope="col">Order Total</th>
						<th scope="col">Order Date</th>
						<th scope="col">Zip code</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orders}" var="order">
						<c:url var="updateLink" value="/orders/update">
							<c:param name="id" value="${order.orderId}" />
						</c:url>
						<c:url var="deleteLink" value="/orders/delete">
							<c:param name="id" value="${order.orderId}" />
						</c:url>
						<tr>
							<th scope="row">${order.orderId}</th>
							<td>${order.customer.id}</td>
							<td>${order.orderTotal}</td>
							<td>${order.orderDate}</td>
							<td>${order.zipcode}</td>
							<td><a href="${updateLink}">Update</a> / <a
								href="${deleteLink}">Delete</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<a class="btn btn-success" href="add">Add Order</a>
		</div>
		<div class="col-lg-1">&nbsp;</div>
	</div>
</body>
</html>