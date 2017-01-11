package com.shop.cart;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
@WebServlet("/addproductform")
public class AddProduct extends HttpServlet {
	public void  doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		String productname = req.getParameter("productname");
		String price = req.getParameter("price");
		int pr = Integer.parseInt(price);
		Product p =new Product();
		List<Product> listp;
		HttpSession session=req.getSession(false);
		listp = (List<Product>) session.getAttribute("listp");
		listp.add(p);
		//List result = au.getTypes(c);
		try {
			p.setProductname(productname);
			p.setPrice(pr);
			int i = ProductDAO.add(p);
			if(i > 0)
			{
				res.sendRedirect("addproduct-success.jsp");
			}else{
				res.sendRedirect("addproduct-error.jsp");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//req.setAttribute("styles", result);
		//RequestDispatcher view = req.getRequestDispatcher("result.jsp");
		//view.forward(req, res);
	}
}
