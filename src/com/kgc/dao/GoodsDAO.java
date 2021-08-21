package com.kgc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.kgc.entity.*;
import com.kgc.tools.BaseDAO;

public class GoodsDAO 
{
	public List<Goods> getGoods()
	{
		Connection conn = null;
		Statement sta = null;
		ResultSet res = null;
		
		List<Goods> ls = new ArrayList<Goods>();
		try
		{
			conn = BaseDAO.getConnection();
			sta = conn.createStatement();
			res = sta.executeQuery("select * from goods");
			while(res.next())
			{
				int id = res.getInt("id");
				String name = res.getString("name");
				String type = res.getString("type");
				double price = res.getDouble("price");
				ls.add(new Goods(id, name, type, price));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			BaseDAO.closeAll(conn, sta, res);
		}
		return ls;
	}
	
	public void deleteGoods(String id)
	{
		Connection conn = null;
		PreparedStatement sta = null;
		try
		{
			conn = BaseDAO.getConnection();
			sta = conn.prepareStatement("delete from goods where id=?;");
			sta.setInt(1, Integer.parseInt(id));
			sta.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			BaseDAO.closeAll(conn, sta, null);
		}
	}
	
	public Goods getGoodsById(String id)
	{
		Connection conn = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		Goods goods = null;
		try
		{
			conn = BaseDAO.getConnection();
			sta = conn.prepareStatement("select * from goods where id=?");
			
			sta.setInt(1, Integer.parseInt(id));
			res = sta.executeQuery();
			res.next();
			int Id = res.getInt("id");
			String Name = res.getString("name");
			String Type = res.getString("type");
			double Price = res.getDouble("price");
			goods = new Goods(Id, Name, Type, Price);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			BaseDAO.closeAll(conn, sta, res);
		}
		return goods;
	}
	
	public boolean alterGoods(String id, String name, String type, String price)
	{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement sta = null;
		
		try
		{
			conn = BaseDAO.getConnection();
			sta = conn.prepareStatement("update goods set name=?,type=?,price=? where id=?");
			sta.setString(1, name);
			sta.setString(2, type);
			sta.setString(3, price);
			sta.setInt(4, Integer.parseInt(id));
			if(sta.executeUpdate() > 0)
				flag = true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			BaseDAO.closeAll(conn, sta, null);
		}
		return flag;
	}
	
	public void addGoods(String name, String type, String price)
	{
		Connection conn = null;
		PreparedStatement sta = null;
		
		try
		{
			conn = BaseDAO.getConnection();
			sta = conn.prepareStatement("insert into goods (name,type,price) values (?,?,?)");
			sta.setString(1, name);
			sta.setString(2, type);
			sta.setString(3, price);
			sta.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			BaseDAO.closeAll(conn, sta, null);
		}
	}
}
