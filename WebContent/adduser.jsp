<%@ page import="com.shop.cart.UserDAO" %>
<jsp:useBean id="u"  class="com.shop.cart.User"></jsp:useBean>    
<jsp:setProperty property="*" name="u"/>
<%
	int i = UserDAO.insert(u);
	if(i > 0)
	{
		response.sendRedirect("adduser-success.jsp");
	}else{
		response.sendRedirect("adduser-error.jsp");
	}
%>
