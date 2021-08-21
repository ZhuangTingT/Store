<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  
    <table>
    	<tr>
    		<td> name </td>   <td> type </td>   <td> price </td>   <td> delete </td>   <td> alter </td>
    	</tr>
    	<c:forEach var="goods" items="${list}" >
    		<tr>
    			<td> ${ goods.name } </td>
    			<td> ${ goods.type } </td>
    			<td> ${ goods.price } </td>
    			<td><a href = "/Store/servlet/DeleteGoods?id=${ goods.id }">删除</a></td>
    			<td><a href = "/Store/servlet/AlterGoods?id=${ goods.id }">修改</a></td>
    		</tr>
    	</c:forEach>
    </table>
    
    <input type="button" onclick="window.location.href='addgoods.html'" value="添加">
	
  </body>
</html>
