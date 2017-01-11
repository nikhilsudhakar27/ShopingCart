package com.shop.cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	protected void  doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		req.getRequestDispatcher("index.html").include(req, res);
		
		HttpSession session = req.getSession(false);
		session.invalidate();
		out.print("You are Successfully Logged out");
		out.close();
	}
}
