<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Selected Products</title>
</head>
<body>
	<%@page import="com.shop.cart.*,java.util.*" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<center>
	<h1>Cart List</h1><p>Products added to your cart!
	</p>
	<%
	    List<Product> list;
		list = (List<Product>) session.getAttribute("list");
	%>
	<table border="1" width="90%" style="text-align:center">
		<tr>
			<th>Product Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Total</th>
		</tr>
		
		<c:forEach items="${list}" var="p">
			<tr>
				<td>${p.getProductname()}</td>
				<td>${p.getPrice()}</td>
				<td>${p.getQuantity()}</td>
				<td>${p.getTotal()}</td>
				<td><a href="editproduct.jsp?productname=${p.getProductname()} &price=${p.getPrice()}&quantity=${p.getQuantity()}">Edit</a></td>
				<td><a href="deleteproductuser.jsp?productname=${p.getProductname()}&price=${p.getPrice()}&quantity=${p.getQuantity()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	</center>
	<a href="ViewProducts.jsp">Back</a>
	<a href="ConfirmProduct.jsp">Confirm</a>
	<a href="LogoutServlet">Logout</a>
</body>
</html>