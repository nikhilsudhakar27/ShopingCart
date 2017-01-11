package com.shop.cart;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
@WebServlet("/addpurchaseform")
public class AddPurchase extends HttpServlet {
	public void  doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
		String productname = req.getParameter("productname");
		String price = req.getParameter("price");
		String quantity = req.getParameter("quantity");
		int pr = Integer.parseInt(price);
		int q = Integer.parseInt(quantity);
		int total=pr*q;
		String name="";
		HttpSession session = req.getSession(false);
		List<Product> list;
		list = (List<Product>)session.getAttribute("list");
		if(session!=null)
		{
			name = (String) session.getAttribute("name");

		}
		Product p =new Product();
		p.setProductname(productname);
		p.setPrice(pr);
		p.setQuantity(q);
		p.setTotal(total);
		list.add(p);
		productname=productname.replaceAll("\\s","");;
		System.out.println("List is This: "+list);
		session.setAttribute("list", list);
		List<Product> listp;
		listp = (List<Product>) session.getAttribute("listp");
		for (Iterator<Product> iter = listp.listIterator(); iter.hasNext(); ) {
		    Product pro = iter.next();
		    String pname=pro.getProductname();
			pname = pname.replaceAll("\\s","");
			if(pname.equals(productname)) 
		    {
				
				iter.remove();
		    }
		}
		
		//int i = ProductDAO.addquantity(p,name);
		//if(i > 0)
		{
			res.sendRedirect("success-addproduct.jsp");
		}//else{
			//res.sendRedirect("editquantity.jsp");
		//}
	}
}
