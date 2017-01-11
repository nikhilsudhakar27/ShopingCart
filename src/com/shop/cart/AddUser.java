package com.shop.cart;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
@WebServlet("/adduserform")
public class AddUser extends HttpServlet {
	public void  doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		String f = req.getParameter("firstname");
		String l = req.getParameter("lastname");
		String user = req.getParameter("username");
		String p = req.getParameter("password");
		User u =new User();
		//List result = au.getTypes(c);
		try {
			u.setFirstname(f);
			u.setLastname(l);
			u.setUsername(user);
			u.setPassword(p);
			int i = UserDAO.insert(u);
			if(i > 0)
			{
				res.sendRedirect("adduser-success.jsp");
			}else{
				res.sendRedirect("adduser-error.jsp");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//req.setAttribute("styles", result);
		//RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		//view.forward(req, res);
	}
}
