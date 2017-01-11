package com.shop.cart;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
@WebServlet("/modifypurchaseform")
public class ModifyPurchase extends HttpServlet {
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
		for(Product pro:list)
		{
			String pname=pro.getProductname();
			pname = pname.replaceAll("\\s","");
			if(pname.equals(productname))
			{
				//list.remove(p1)
				//System.out.println("Found same"+pro.getProductname());
				pro.setQuantity(q);
				pro.setTotal(total);
				//System.out.println("quantity"+pro.getQuantity());
			}
		}
		//list.add(p);
		//int i = ProductDAO.modifyquantity(p,name);
		//if(i > 0)
		//{
			res.sendRedirect("ModifyProducts.jsp");
		//}else{
			//res.sendRedirect("editproduct.jsp");
		//}
	}
}
