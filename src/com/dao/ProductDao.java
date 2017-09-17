package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.ProductBean;

public class ProductDao
{
	public ArrayList<ProductBean> viewItems(String s)
	{
		ArrayList<ProductBean> pb = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ProductBean b = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456");
			ps = c.prepareStatement("select * from Product where status = ?");
			ps.setString(1, s);
			pb = new ArrayList<ProductBean>();
			rs = ps.executeQuery();
			while(rs.next())
			{
				b = new ProductBean();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPrice(rs.getDouble(3));
				b.setQuantity(rs.getInt(4));
				b.setStatus(rs.getString(5));
				pb.add(b);
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return pb;
	}

	public ProductBean getProduct(int s1) {
		// TODO Auto-generated method stub
		ProductBean t = null;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456");
			ps = c.prepareStatement("select * from Product where productId = ?");
			ps.setInt(1, s1);
			rs = ps.executeQuery();
			while(rs.next())
			{
				t = new ProductBean();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setPrice(rs.getDouble(3));
				t.setQuantity(rs.getInt(4));
				t.setStatus(rs.getString(5));
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return t;
	}

	public boolean delProduct(int s1) {
		// TODO Auto-generated method stub
		int flag;
		Connection c = null;
		PreparedStatement ps = null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456");
			ps = c.prepareStatement("delete from Product where productId = ?");
			ps.setInt(1, s1);
			flag = ps.executeUpdate();
			if(flag > 0)
				return true;
			else
				return false;
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}