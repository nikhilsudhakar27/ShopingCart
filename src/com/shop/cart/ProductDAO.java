package com.shop.cart;
import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpSession;


public class ProductDAO {
	private static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "c##nikhilsc",
					"nikhilsc");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static int add(Product p) throws SQLException {
		int status = 0;
		try {
			Connection con = getConnection();
			int i=p.getPrice();
			System.out.println("This is the no:"+i);
			PreparedStatement pst = con
					.prepareStatement("insert into myproduct (productname,price) values(?,?)");
			pst.setString(1, p.getProductname());
			pst.setInt(2, p.getPrice());
			status = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
	public static List<Product> getAllRecords(){
		List<Product> list = new ArrayList<Product>();
		try{
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select productname,price from myproduct");
			System.out.println("select productname,price from myproduct excuted!!!!!");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				Product p =new Product();
				p.setProductname(rs.getString("productname"));
				p.setPrice(rs.getInt("price"));
				System.out.println(rs.getString("productname"));
				list.add(p);
			}
		}catch(Exception e){System.out.println(e);}
		System.out.println(list);
		return list;
		
	}
	public static int addquantity(Product p,String username){
		int status = 0;
		try{
			
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into mypurchaser (username,productname,price,quantity,total) values(?,?,?,?,?)");
			pst.setString(1,username);
			pst.setString(2, p.getProductname());
			pst.setInt(3, p.getPrice());
			pst.setInt(4, p.getQuantity());
			pst.setInt(5, p.getTotal());
			status=pst.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int modifyquantity(Product p,String username){
		int status = 0;
		try{
			
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("update mypurchaser set quantity=?,total=? where productname=? AND username=?");
			pst.setInt(1,p.getQuantity());
			pst.setInt(2,p.getTotal());
			pst.setString(3, p.getProductname());
			pst.setString(4, username);
			status=pst.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int deletequantity(Product p,String username){
		int status = 0;
		try{
			
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("delete from mypurchaser where productname=? AND username=?");
			pst.setString(1, p.getProductname());
			pst.setString(2, username);
			status=pst.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int modifyprice(Product p){
		int status = 0;
		try{
			
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("update myproduct set price=? where productname=?");
			pst.setInt(1,p.getPrice());
			pst.setString(2, p.getProductname());
			status=pst.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int deleteproduct(Product p){
		int status = 0;
		try{
			
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("delete from myproduct where productname=?");
			pst.setString(1, p.getProductname());
			status=pst.executeUpdate();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
