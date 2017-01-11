<%@ page import="java.sql.*"%>
<%@ page session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Final List of Products Selected!</title>
</head>
<body>
	<%@page import="com.shop.cart.*,java.util.*,java.io.*"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<center>
		<h1 style="text-align: center">Selected Products</h1>
		<%
			List<Product> list;
			list = (List<Product>) session.getAttribute("list");

			Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "c##nikhilsc",
					"nikhilsc");
			Statement statement = connection.createStatement();
		%>
		<%
			String name = (String) request.getSession().getAttribute("name");
			System.out.println("My name is: " + name);
		%>
		<%
			int completeTotal = 0;
			StringBuffer sb = new StringBuffer();
			for (Product pro : list) {
				String productname = pro.getProductname();
				productname = productname.replaceAll("\\s", "");
				sb.append(productname+" . ");
				int total = pro.getTotal();
				completeTotal += total;
			}
			String productList = sb.toString();
			java.util.Date date = new java.util.Date();
			String mydate = date.toString();
			String sql = "insert into completepurchase (username,dated,productlist,total) values ('"
					+ name
					+ "','"
					+ mydate
					+ "','"
					+ productList
					+ "','"
					+ completeTotal + "')";
			System.out.println("My Query is:" + sql);
			//String sql = "select productname,price,quantity,total from mypurchaser where username='"
			//	+ name + "'";
			//System.out.println("Query is: " + sql);
			//ResultSet resultSet = statement.executeQuery(sql);
			if(!list.isEmpty())
			statement.executeUpdate(sql);
		%>
		<p>
			Hello
			<%=name%>, Your transaction is complete!
		</p>
		<table style="text-align: center" border="0">
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
				</tr>
			</c:forEach>
		</table>
		
		<p>Total amount of Transaction is:</p>
		
		<p><%=completeTotal%></p>
		
	</center>

	<a href="LogoutServlet">Logout</a>
</body>
</html>