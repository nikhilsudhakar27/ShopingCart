<%@ page import="com.shop.cart.*" %>
<jsp:useBean id="p"  class="com.shop.cart.Product"></jsp:useBean>    
<jsp:setProperty property="*" name="u"/>
<%
	int i= ProductDAO.addquantity(p,"");
	response.sendRedirect("ViewProducts.jsp");
	
%>
