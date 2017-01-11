<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Products</title>
</head>
<body>
	<%@page import="com.shop.cart.*,java.util.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<center>
	<h1>Product List</h1><p>Add Products to you cart!
	</p>
	<%
	List<Product> listp;
	listp = (List<Product>) session.getAttribute("listp");
	%>
	<table border="1" width="90%" style="text-align:center">
		<tr>
			<th>Product Name</th>
			<th>Price</th>
			<th>Add Quantity</th>
		</tr>
		<c:forEach items="${listp}" var="p">
			<tr>
				<td>${p.getProductname()}</td>
				<td>${p.getPrice()}</td>
				<td><a href="editquantity.jsp?name=${p.getProductname()}&price=${p.getPrice()}" style="text-align:center">Add</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	</center>
	<a href="ModifyProducts.jsp">View Cart</a>
	<a href="LogoutServlet">Logout</a>
</body>
</html>