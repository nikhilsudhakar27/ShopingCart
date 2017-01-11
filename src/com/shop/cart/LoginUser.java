package com.shop.cart;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

@WebServlet("/login")
public class LoginUser extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		String user = req.getParameter("username");
		String p = req.getParameter("password");
		HttpSession session;
		// List result = au.getTypes(c);
		if (user.equals("admin") && p.equals("admin")) {
			session = req.getSession(true);
			session.setAttribute("name", user);
			List<Product> listp = new ArrayList<Product>(); 
			listp=ProductDAO.getAllRecords();
			session.setAttribute("listp", listp);
			res.sendRedirect("AdminProfileServlet");
			
		} else {
			try {
				int i = UserDAO.getUser(user, p);
				System.out.println(i);
				System.out.println("Username: " + user + " Password: " + p);
				if (i > 0) {
					session = req.getSession(true);
					session.setAttribute("name", user);
					List<Product> list =new ArrayList<Product>();
					session.setAttribute("list", list);
					List<Product> listp = new ArrayList<Product>(); 
							listp=ProductDAO.getAllRecords();
					session.setAttribute("listp", listp);
					System.out.println(listp);
					res.sendRedirect("ProfileServlet");
					
				} else {
					res.sendRedirect("login-error.jsp");
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		// req.setAttribute("styles", result);
		// RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		// view.forward(req, res);
	}

}
