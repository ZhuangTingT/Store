package com.kgc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kgc.dao.GoodsDAO;
import com.kgc.entity.Goods;

public class AlterGoods extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");		
		GoodsDAO goodsDAO = new GoodsDAO();
		Goods goods = goodsDAO.getGoodsById(id);
		
		HttpSession session = request.getSession();
		session.setAttribute("goods", goods);
		response.sendRedirect("../altergoods.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String price = request.getParameter("price");
		
		GoodsDAO goodsDAO = new GoodsDAO();
		boolean flag = goodsDAO.alterGoods(id, name, type, price);
		if(flag)
			response.sendRedirect("/Store/servlet/FindGoods");
		else 
			response.sendRedirect("/Store/servlet/AlterGoods?id="+id);
	}

}
