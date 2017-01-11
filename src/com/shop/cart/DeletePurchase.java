package com.shop.cart;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
@WebServlet("/deletepurchaseform")
public class DeletePurchase extends HttpServlet {
	public void  doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		String productname = req.getParameter("productname");
		String price = req.getParameter("price");
		String quantity = req.getParameter("quantity");
		int pr = Integer.parseInt(price);
		int q = Integer.parseInt(quantity);
		int total=pr*q;
		String name="";
		HttpSession session = req.getSession(false);
		if(session!=null)
		{
			name = (String) session.getAttribute("name");

		}
		List<Product> list;
		list = (List<Product>) session.getAttribute("list");
		Product p =new Product();
		p.setProductname(productname);
		p.setPrice(pr);
		p.setQuantity(q);
		p.setTotal(total);
		productname = productname.replaceAll("\\s","");
		List<Product> listp;
		listp = (List<Product>) session.getAttribute("listp");
		listp.add(p);
		session.setAttribute("listp", listp);
		for (Iterator<Product> iter = list.listIterator(); iter.hasNext(); ) {
		    Product pro = iter.next();
		    String pname=pro.getProductname();
			pname = pname.replaceAll("\\s","");
			if(pname.equals(productname)) 
		    {
		        
				iter.remove();
		    }
		}
		//int i = ProductDAO.deletequantity(p,name);
		//if(i > 0)
		//{
			res.sendRedirect("ModifyProducts.jsp");
		//}else{
			//res.sendRedirect("deleteproductuser.jsp");
		//}
	}
}
