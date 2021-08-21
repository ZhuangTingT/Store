package com.kgc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kgc.tools.BaseDAO;

public class UsersDAO 
{
	public boolean loginCheck(String usersName, String passWord)
	{
		boolean logCheck = false;
		
		Connection conn = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		try
		{
			conn = BaseDAO.getConnection();
			sta = conn.prepareStatement("select count(*) from users where usersname=? and password=?");
			sta.setString(1, usersName);
			sta.setString(2, passWord);

			res = sta.executeQuery();
			res.next();
			if(res.getInt(1) > 0)
				logCheck = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return logCheck;
	}
}
