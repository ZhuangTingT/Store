package com.kgc.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO 
{
	// 连接数据库
	public static Connection getConnection()
	{
		Connection conn  = null;
		try 
		{
			Class.forName(Const.DRIVER_CLASS);
			conn = DriverManager.getConnection(Const.URL, Const.USERNAME, Const.PASS);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	// 断开数据库
	public static void closeAll(Connection conn, Statement sta, ResultSet res)
	{
		try 
		{
			if(res != null)
				res.close();
			if(sta != null)
				sta.close();
			if(conn != null)
				conn.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
