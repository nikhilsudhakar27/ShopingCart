package com.shop.cart;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpSession;




public class UserDAO {
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

	public static int insert(User u) throws SQLException {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement pst = con
					.prepareStatement("insert into signup (firstname,lastname,username,password) values(?,?,?,?)");
			pst.setString(1, u.getFirstname());
			pst.setString(2, u.getLastname());
			pst.setString(3, u.getUsername());
			pst.setString(4, u.getPassword());
			status = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
	public static int getUser(String user,String p) throws SQLException {
		//User u=null;
		int status=0;
		try{
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from signup where username=? AND password=?");
			pst.setString(1, user);
			pst.setString(2, p);

			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				System.out.println("username in db:" +rs.getString("username")+" and in password:"+rs.getString("password"));
				//User u =new User();
				
						
					status=1;
					
			}
		}catch(Exception e){System.out.println(e);}
		return status;
	}	
}