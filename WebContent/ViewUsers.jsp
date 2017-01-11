<%@ page import="java.sql.*"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The User Database Table</title>
</head>
<body>
	
	<h1 style="text-align: center">List of Users</h1>
	<%
		Connection connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "c##nikhilsc",
				"nikhilsc");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement
				.executeQuery("select * from completepurchase");
	%>
	<center>
	<table style="text-align: center" border="2">
		<tr>
			<th>User Name</th>
			<th>Date of Purchase</th>
			<th>Products Bought</th>
			<th>Total Cost</th>
		</tr>
		<%
			while (resultSet.next()) {
		%>
		<tr>
			<td><%=resultSet.getString(1)%></td>
			<td><%=resultSet.getString(2)%></td>
			<td><%=resultSet.getString(3)%></td>
			<td><%=resultSet.getString(4)%></td>

		</tr>
		<%
			}
		%>		
	</table>
	</center>
	<br>
	<p></p>
	<br>
	<a href="adminProfile.html">Profile</a>
	<a href="LogoutServlet">Logout</a>
</body>
</html>