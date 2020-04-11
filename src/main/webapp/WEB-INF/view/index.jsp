<%@ page isELIgnored="false"%>
<html>
<body>

	<h1>Customer Controller (project-like)</h1>
	<ul>
		<li><a href="customers/add">Add Customer</a></li>
		<li><a href="customers/list">List Customers</a></li>
	</ul>

	<hr>
	<h2>Item Controller</h2>
	<ul>
		<li><a href="${pageContext.request.contextPath}/items/add">Add
				Items</a></li>
		<li><a href="${pageContext.request.contextPath}/items/list">List
				Items</a></li>
	</ul>

	<hr>
	<h1>Order Controller</h1>
	<ul>
		<li><a href="orders/add">Add Order</a></li>
		<li><a href="orders/list">List Orders</a></li>
	</ul>


	<h1>Order Details Controller</h1>
	<ul>
		<li><a href="orderDetails/add">Add OrderDetails</a></li>
		<li><a href="orderDetails/list">List OrderDetails</a></li>
	</ul>
</body>
</html>
