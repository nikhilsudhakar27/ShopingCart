<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete form</title>
</head>
<body>
	<%@page import="com.shop.cart.*" %>
	
	<% String productname = request.getParameter("name"); %>	
		<% String price = request.getParameter("price"); 
			
		%>
		
		
	<center>
	<h1>Delete product</h1>
	<form action="DeleteProductAdmin" method="post">
		<table>
		<tr>
			<td>Product Name:</td>
			<td><input type="text" name="productname" id="productname" value="<%=productname%>" readonly></td>
		</tr>
		<tr>
			<td>Product price:</td>
			<td><input type="number" name="price" id="price" value="<%=price%>" readonly></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Delete product"/></td>
			
		</tr>
		</table>
	</form>
	</center>
	<br>
	<a href="ViewProductsAdmin.jsp">Back</a>
</body>
</html>