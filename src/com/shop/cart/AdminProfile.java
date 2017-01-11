package com.shop.cart;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AdminProfileServlet")
public class AdminProfile extends HttpServlet{
	protected void  doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		req.getRequestDispatcher("adminProfile.html").include(req, res);
		
		HttpSession session = req.getSession(false);
		if(session!=null)
		{
			String name = (String) session.getAttribute("name");
			out.print("Hello, "+name+" Welcome to Profile");
		}
		else{
			out.print("Please login first");
			req.getRequestDispatcher("index.html").include(req, res);
		}
		out.close();
	}
}