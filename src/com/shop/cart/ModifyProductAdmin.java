package com.shop.cart;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
@WebServlet("/ModifyProductAdmin")
public class ModifyProductAdmin extends HttpServlet {
	public void  doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		String productname = req.getParameter("productname");
		String price = req.getParameter("price");
		int pr = Integer.parseInt(price);
		
		
		
		String name="";
		HttpSession session = req.getSession(false);
		if(session!=null)
		{
			name = (String) session.getAttribute("name");

		}
		List<Product> listp;
		listp = (List<Product>) session.getAttribute("listp");
		Product p =new Product();
		p.setProductname(productname);
		p.setPrice(pr);
		productname = productname.replaceAll("\\s","");
		for(Product pro:listp)
		{
			String pname=pro.getProductname();
			pname = pname.replaceAll("\\s","");
			if(pname.equals(productname))
			{
				//list.remove(p1)
				//System.out.println("Found same"+pro.getProductname());
				pro.setPrice(pr);
				//System.out.println("quantity"+pro.getQuantity());
			}
		}
		//list.add(p);
		int i = ProductDAO.modifyprice(p);
		if(i > 0)
		{
			res.sendRedirect("ViewProductsAdmin.jsp");
		}else{
			res.sendRedirect("modifyproductadmin.jsp");
		}
	}
}
